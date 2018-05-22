package com.swdegao.quartz.mapper;

import java.util.List;
import com.swdegao.quartz.entity.DataFactory;
import com.swdegao.quartz.entity.MeterDay;
public interface CuiHMapper {
	
	/**
	 * 贸易结算水表的日结数据表
	 * 每个表每天一条.
	 * @param meterDay
	 */
	public void insertDataOfMeterDay(MeterDay meterDay);
	
	/**
	 * 计量漏损等监控表的实时数据
	 * 水表实时数据中间表
	 * 针对有每隔几分钟一条数据的表.
	 * @param dataFactory
	 */
	public void insertDataOfRealTime(DataFactory dataFactory);
	
	/**
	 * 批量插入
	 */
	public void insertDataOfRealTimeByBatch(List<DataFactory> listDataFactory);
}
