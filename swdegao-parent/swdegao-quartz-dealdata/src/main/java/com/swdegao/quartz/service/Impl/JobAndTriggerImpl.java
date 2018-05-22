package com.swdegao.quartz.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swdegao.quartz.entity.JobAndTrigger;
import com.swdegao.quartz.mapper.JobAndTriggerMapper;
import com.swdegao.quartz.service.IJobAndTriggerService;

@Service
public class JobAndTriggerImpl implements IJobAndTriggerService{

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;
	@Override
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(JobAndTrigger jobAndTri,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails(null);
		PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
		return page;
	}
	@Override
	public void updateTriggerOnceState(JobAndTrigger jobAndTri) {
		jobAndTriggerMapper.updateTriggerOnceState(jobAndTri);
	}

}