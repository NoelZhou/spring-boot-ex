package com.swdegao.quartz.job;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.util.UriEncoder;
import com.alibaba.fastjson.JSON;
import com.swdegao.quartz.common.URLConfig;
import com.swdegao.quartz.entity.DataFactory;
import com.swdegao.quartz.entity.ScadaDevice;
import com.swdegao.quartz.entity.ScadaDeviceValues;
import com.swdegao.quartz.service.ICuiHService;
import com.swdegao.quartz.utils.HTTPUtils;
import com.swdegao.quartz.utils.PropertyUtils;
import com.swdegao.quartz.utils.StringUtils;

public class DataFactoryForCuiH implements BaseJob {

	private static Logger _log = LoggerFactory.getLogger(DataFactoryForCuiH.class);

	private static final String jobName = "DataFactoryForCuiH";
	private static final String displayName = "水表实时数据";
	private static final String jobGroupName = "DataFactoryForCuiHGroup";
	private static final String description = "翠亨水务计量漏损等监控表的实时数据";
	private static final String cronVersion = "1.0";
	private static final String author = "DeGao Team";

	@Autowired
	public ICuiHService iCuiHService;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.info("DataFactoryForCuiH 执行时间: " + new Date());
		getAllDevices(checkDateOrNull());
	}
	/**
	 * 检查properties文件中是否有设备日期
	 * @return
	 */
	public Boolean checkDateOrNull() {
		return PropertyUtils.isEmpty();
	}
	/**
	 * 获取所有设备信息
	 * @param isProNul
	 */
	public void getAllDevices(Boolean isProNul){
		List<ScadaDevice> scadaDevices = JSON.parseArray(HTTPUtils.getHttpResponse(URLConfig.SCADA_DEVs),
				ScadaDevice.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(StringUtils.join(scadaDevices, ",").toString());
		scadaDevices.stream().forEach(device -> {
			String id = String.valueOf(device.getUserTerminals());
			if(!isProNul) {
				String preDateTime = "";
				try {
					String value = PropertyUtils.getKeyValue(id);
					if(value!=null) {
						long prelong = df.parse(value).getTime();
						preDateTime = df.format(new Date(prelong+1000));
					}else {
						_log.info("properties文件中没有该设备日期信息："+id+",检查是否有数据");
						String url = String.format(URLConfig.SCADA_VALs, id);
						_log.debug(url);
						getAllDatas(url,device);
						return;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String nowDateTiem = df.format(new Date());
				String uriPre = UriEncoder.encode(preDateTime);
				String uriNow = UriEncoder.encode(nowDateTiem);
				String url = String.format(URLConfig.SCADA_VALs_TIME, id, uriPre, uriNow);
				_log.debug(url);
				getAllDatas(url,device);
			}else {
				String url = String.format(URLConfig.SCADA_VALs, id);
				_log.debug(url);
				getAllDatas(url,device);
			}
		
		});
	}
	/**
	 * 根据url和设备信息，获取单个设备所有数据
	 * @param url
	 * @param device
	 */
	public void getAllDatas(String url,ScadaDevice device) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ScadaDeviceValues> scadaDeviceValues = JSON.parseArray(
				HTTPUtils.getHttpResponse(url),
				ScadaDeviceValues.class);
		if(scadaDeviceValues.isEmpty()) {
			_log.info("没有数据需要插入");
			return;
		}else {
			scadaDeviceValues.stream().forEach(value -> {
				// 存放插入翠亨数据库的数据
				List<DataFactory> lDataFactories = new ArrayList<DataFactory>();
				_log.info("插入的设备的id:  " + value.getId());
				_log.info("data数据总数:  " + value.getId());
				StringBuffer sBuffer = new StringBuffer();
				sBuffer.append(df.format(value.getData().get(value.getData().size() - 1).getTime()));
				value.getData().stream().forEach(deviceValue -> {
					DataFactory dataFactory = new DataFactory();
					dataFactory.setMeter_id(String.valueOf(value.getId()));
					dataFactory.setFactory_no(device.getName());
					dataFactory.setCollectiondate(deviceValue.getTime());
					dataFactory.setPressure(deviceValue.getValue().getPressure());
					dataFactory.setPflownum(deviceValue.getValue().getReadNumber());
					dataFactory.setCflownum(deviceValue.getValue().getReverseNumber());
					dataFactory.setFlow(deviceValue.getValue().getTotalFlow());
					lDataFactories.add(dataFactory);
				});
				int size = lDataFactories.size();
				if (size <= 1000) {
					iCuiHService.insertDataOfRealTimeByBatch(lDataFactories);
				} else {
					int temp = size / 1000;
					int yuNum = size % 1000;
					for (int i = 0; i < temp; i++) {
						_log.info("正在插入中的数据数:"+lDataFactories.subList(1000 * i, 1000 * (i + 1)).size());
						iCuiHService.insertDataOfRealTimeByBatch(lDataFactories.subList(1000 * i, 1000 * (i + 1)));
						if (yuNum != 0 && i == temp - 1) {
							_log.info("正在插入中的数据数:"+lDataFactories.subList(1000 * temp, 1000 * temp + yuNum).size());
							iCuiHService.insertDataOfRealTimeByBatch(
									lDataFactories.subList(1000 * i, 1000 * (i + 1) + yuNum));
						}
					}
				}
				/**
				 * 更新properties文件中设备最后插入的一条数据时间
				 */
				PropertyUtils.updateProperties(String.valueOf(value.getId()), sBuffer.toString());
			});
		}
	}
	
	@Override
	public String getJobName() {
		return jobName;
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return displayName;
	}

	@Override
	public String getGroupName() {
		return jobGroupName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getCronVersion() {
		// TODO Auto-generated method stub
		return cronVersion;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return author;
	}
}
