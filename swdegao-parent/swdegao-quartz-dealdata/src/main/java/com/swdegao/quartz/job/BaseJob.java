package com.swdegao.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job{
	
	
	public String getJobName();
	public String getDisplayName(); 
	public String getGroupName();  
	public String getDescription(); 
	public String getCronVersion();  
	public String getAuthor(); 
    
	public void execute(JobExecutionContext context) throws JobExecutionException;
}

