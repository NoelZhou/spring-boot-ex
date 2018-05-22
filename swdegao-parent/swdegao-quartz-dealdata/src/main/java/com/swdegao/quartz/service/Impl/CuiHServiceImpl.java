package com.swdegao.quartz.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.DS;
import com.swdegao.quartz.entity.DataFactory;
import com.swdegao.quartz.entity.MeterDay;
import com.swdegao.quartz.mapper.CuiHMapper;
import com.swdegao.quartz.service.ICuiHService;
@Service
public class CuiHServiceImpl implements ICuiHService {

	@Autowired
	public CuiHMapper cuiHMapper;
	
	@DS("one")
	@Override
	public void insertDataOfMeterDay(MeterDay meterDay) {
	}
	
	@DS("one")
	@Override
	public void insertDataOfRealTime(DataFactory dataFactory) {
		cuiHMapper.insertDataOfRealTime(dataFactory);
	}
	
	@DS("one")
	@Override
	public void insertDataOfRealTimeByBatch(List<DataFactory> listDataFactory) {
		cuiHMapper.insertDataOfRealTimeByBatch(listDataFactory);
		
	}

}
