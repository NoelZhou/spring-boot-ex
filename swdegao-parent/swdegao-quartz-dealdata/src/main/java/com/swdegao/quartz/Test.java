package com.swdegao.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.swdegao.quartz.common.URLConfig;
import com.swdegao.quartz.entity.DataFactory;
import com.swdegao.quartz.entity.ScadaDevice;
import com.swdegao.quartz.entity.ScadaDeviceValues;
import com.swdegao.quartz.job.NewJob;
import com.swdegao.quartz.service.ICuiHService;
import com.swdegao.quartz.utils.HTTPUtils;
import com.swdegao.quartz.utils.PropertyUtils;
import com.swdegao.quartz.utils.StringUtils;;

public class Test {
	
	@Autowired
	public ICuiHService iHService;
	
	public static void test1()
	{
		//存放插入翠亨数据库的数据
//		List<DataFactory> lDataFactoriesF = new ArrayList<DataFactory>();
//		List<DataFactory> lDataFactoriesS = new ArrayList<DataFactory>();
		List<DataFactory> lDataFactories = new ArrayList<DataFactory>();
		
		List<ScadaDevice> scadaDevices = JSON.parseArray(HTTPUtils.getHttpResponse(URLConfig.SCADA_DEVs), ScadaDevice.class);
//    	scadaDevices.stream().forEach(sDevice ->{
//    		DataFactory dataFactory = new DataFactory();
//    		dataFactory.setMeter_id(String.valueOf(sDevice.getId()));
//    		dataFactory.setFactory_no(sDevice.getNameFactory());
//    		String modelName = sDevice.getModelName().split(" ")[0];
//    		if(modelName.equals("物联网大表")) {
//    			dataFactory.setMeter_type(18);
//    		}else if(modelName.equals("电磁流量计")) {
//    			dataFactory.setMeter_type(19);
//    		}else if(modelName.equals("脉冲流量计")) {
//    			dataFactory.setMeter_type(51);
//    		}
//    		lDataFactories.add(dataFactory);
//    	});
		String ids =StringUtils.join(scadaDevices, ",").toString();
    	List<ScadaDeviceValues> scadaDeviceValues = JSON.parseArray(HTTPUtils.getHttpResponse(URLConfig.SCADA_VALs+ids),ScadaDeviceValues.class);
    	scadaDeviceValues.stream().forEach(value -> {
    		value.getData().stream().forEach(deviceValue -> {
    			DataFactory dataFactory = new DataFactory();
        		dataFactory.setMeter_id(String.valueOf(value.getId()));
        		dataFactory.setFactory_no(value.getName());
    			dataFactory.setPressure(deviceValue.getValue().getPressure());
    			dataFactory.setPflownum(deviceValue.getValue().getReadNumber());
    			dataFactory.setCflownum(deviceValue.getValue().getReverseNumber());
    			dataFactory.setFlow(deviceValue.getValue().getTotalFlow());
    			lDataFactories.add(dataFactory);
    			
    		});
    	});
    	System.out.println(JSON.toJSONString(lDataFactories));
 
	}
	public void test2() throws SchedulerException {
		 SchedulerFactory factory = new StdSchedulerFactory();  
	        // 从工厂里面拿到一个scheduler实例  
	        Scheduler scheduler = factory.getScheduler();  
	        // 计算任务的开始时间，DateBuilder.evenMinuteDate方法是取下一个整数分钟  
	        Date runTime = DateBuilder.evenMinuteDate(new Date());  
	        // 真正执行的任务并不是Job接口的实例，而是用反射的方式实例化的一个JobDetail实例  
	        JobDetail job = JobBuilder.newJob(NewJob.class).withIdentity("job1", "group1").build();  
	        // 定义一个触发器，startAt方法定义了任务应当开始的时间  
	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();  
	        // 将任务和Trigger放入scheduler  
	        scheduler.scheduleJob(job, trigger);  
	        scheduler.start();  
	        try {  
	            // 等待65秒，保证下一个整数分钟出现，这里注意，如果主线程停止，任务是不会执行的  
	            Thread.sleep(65L * 1000L);  
	        } catch (Exception e) {  
	  
	        }  
	        // scheduler结束  
	        scheduler.shutdown(true);  
	}
	
	public static void main(String[] args) throws Throwable {  
//       test3();
//		System.out.println("dasda{%d}",1);
//		System.out.println(URLEncoder.encode("http://121.40.63.15:8889/WebApi/GetScadaValue?ids=160&TimeBeg=2018-05-21 23:45:01&TimeEnd=2018-05-22 15:31:05","utf-8"));
//		System.out.println(URLEncoder.encode("http://121.40.63.15:8889/WebApi/GetScadaValue?ids=160&TimeBeg=2018-05-21 23:45:01&TimeEnd=2018-05-22 15:31:05", "utf-8" ));
//		System.out.println(new Date().getTime());
		
		HTTPUtils.getHttpResponse("http://121.40.63.15:8889/WebApi/GetScadaValue?ids=160");
	} 
	
	public static void test3() {
//		PropertyUtils.updateProperties("222", "dasdas");
		System.out.println(PropertyUtils.getKeyValue("160"));
	}
}













