package com.swdegao.quartz.job;

import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.swdegao.quartz.entity.JobAndTrigger;
import com.swdegao.quartz.service.IJobAndTriggerService;
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class HelloJob implements BaseJob {  
	@Autowired
    private IJobAndTriggerService iJobService;
	
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
    
    private static final String jobName= "HelloJob";
    private static final String displayName= "";
	private static final String jobGroupName= "HelloJobGroup";
	private static final String description= "分发数据对接翠亨水务远程抄表系统";
	private static final String cronVersion = "1.0";
	private static final String author = "DeGao Team";

    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("Hello Job 执行时间: " + new Date());  
        Random random = new Random();
        int num = random.nextInt();
        System.out.println(num);
        if(num%2 == 0) {
        	 iJobService.updateTriggerOnceState(new JobAndTrigger("SUCCESS", jobName, jobGroupName));
        }else {
        	iJobService.updateTriggerOnceState(new JobAndTrigger("ERROR", jobName, jobGroupName));
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
