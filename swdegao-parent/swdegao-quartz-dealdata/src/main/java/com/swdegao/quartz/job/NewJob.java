package com.swdegao.quartz.job;

import java.util.Date;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class NewJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(NewJob.class);  
    private static final String jobName= "NewJobData";
    private static final String displayName= "";
	private static final String jobGroupName= "NewJobDataGroup";
	private static final String description= "分发数据对接翠亨水务远程抄表系统";
	private static final String cronVersion = "1.0";
	private static final String author = "DeGao Team";

    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("New Job 执行时间: " + new Date());  
          
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
