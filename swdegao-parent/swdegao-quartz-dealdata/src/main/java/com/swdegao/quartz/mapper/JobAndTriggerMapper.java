package com.swdegao.quartz.mapper;

import java.util.List;
import com.swdegao.quartz.entity.JobAndTrigger;
public interface JobAndTriggerMapper {
	public List<JobAndTrigger> getJobAndTriggerDetails(JobAndTrigger jobAndTri);
	public void updateTriggerOnceState(JobAndTrigger jobAndTri);
}
