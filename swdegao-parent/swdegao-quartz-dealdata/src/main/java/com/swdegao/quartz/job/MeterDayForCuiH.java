package com.swdegao.quartz.job;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MeterDayForCuiH implements BaseJob {

	private static Logger _log = LoggerFactory.getLogger(MeterDayForCuiH.class); 
	
	private static final String jobName= "MeterDayForCuiH";
    private static final String displayName= "水表的日结数据";
	private static final String jobGroupName= "MeterDayForCuiHGroup";
	private static final String description= "翠亨水务贸易结算水表的日结数据表";
	private static final String cronVersion = "1.0";
	private static final String author = "DeGao Team";

	
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.info("MeterDayForCuiH 执行时间: " + new Date());  
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
