package com.swdegao.quartz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.quartz.TriggerKey;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.swdegao.quartz.entity.JobAndTrigger;
import com.swdegao.quartz.entity.Result;
import com.swdegao.quartz.job.BaseJob;
import com.swdegao.quartz.job.MyJobListener;
import com.swdegao.quartz.service.IJobAndTriggerService;
import com.swdegao.quartz.utils.ClassUtil;
import com.swdegao.quartz.utils.DateUtil;

@RestController
@RequestMapping("/job")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class JobController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private Scheduler scheduler;
    
    @Autowired
    private IJobAndTriggerService iJobService;
	
	@PostMapping("/add")
	public Result save(JobAndTrigger jobAndTri){
		LOGGER.info("新增任务");
		try {
			//获取Scheduler实例、废弃、使用自动注入的scheduler、否则spring的service将无法注入
	        //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	        //如果是修改  展示旧的 任务
	        if(jobAndTri.getOldJobGroup()!=null){
	        	JobKey key = new JobKey(jobAndTri.getOldJobName(),jobAndTri.getOldJobGroup());
	        	scheduler.deleteJob(key);
	        }
	        Class cls = Class.forName(jobAndTri.getJobClassName()) ;
	        cls.newInstance();
	        //构建job信息
	        JobDetail job = JobBuilder.newJob(cls).withIdentity(jobAndTri.getJobName(),
	        		jobAndTri.getJobGroup())
	        		.withDescription(jobAndTri.getDescription()).build();
	        // 触发时间点
	        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobAndTri.getCronExpression());
	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+jobAndTri.getJobName(), jobAndTri.getJobGroup())
	                .startNow().withSchedule(cronScheduleBuilder).build();	
	        scheduler.getListenerManager().addJobListener(new MyJobListener());
	        //交由Scheduler安排触发
	        scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}
	
	@PostMapping("/list")
	public Result list(JobAndTrigger jobAndTri,Integer pageNo,Integer pageSize) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		LOGGER.info("任务列表");
		PageInfo<JobAndTrigger> pInfo = iJobService.getJobAndTriggerDetails(jobAndTri,pageNo, pageSize);
		List<JobAndTrigger> list = pInfo.getList();
		List<JobAndTrigger> resultList = new ArrayList<>();
		List<Class> classes = ClassUtil.getAllClassByInterface(Class.forName("com.swdegao.quartz.job.BaseJob"));  
//        classes.forEach(clas -> System.out.println(clas.getName()));
		for (Class clas :classes) {
			BaseJob baseJob = (BaseJob) clas.newInstance();
			if(jobAndTri.getJobName()!=null&&!jobAndTri.getJobName().equals(baseJob.getJobName())) {
				continue;//如果没有匹配的jobname，跳到下一步循环
			}
			Optional<JobAndTrigger> opt = list.stream().filter(job -> job.getJobClassName().equals(clas.getName())).findFirst();
			JobAndTrigger jobTemp = null;
			if(opt.isPresent()) {
				jobTemp = opt.get();
				jobTemp.setIsInstall(true);
				jobTemp.setPrevFireTime(DateUtil.timeStamp2Date(String.valueOf(Long.parseLong(jobTemp.getPrevFireTime())/1000), null));
				jobTemp.setNextFireTime(DateUtil.timeStamp2Date(String.valueOf(Long.parseLong(jobTemp.getNextFireTime())/1000), null));
				jobTemp.setCronVersion(baseJob.getCronVersion());
				jobTemp.setAuthor(baseJob.getAuthor());
			}else {
				jobTemp=new JobAndTrigger(false,baseJob,clas.getName());
			}
			resultList.add(jobTemp);
        } 
		return Result.ok(resultList);
	}
	
	@PostMapping("/trigger")
	public  Result trigger(JobAndTrigger jobAndTri,HttpServletResponse response) {
		try {
		     JobKey key = new JobKey(jobAndTri.getJobName(),jobAndTri.getJobGroup());
		     scheduler.triggerJob(key);
		} catch (SchedulerException e) {
			 e.printStackTrace();
			 return Result.error();
		}
		return Result.ok();
	}
	
	@PostMapping("/pause")
	public  Result pause(JobAndTrigger jobAndTri,HttpServletResponse response) {
		LOGGER.info("停止任务");
		try {
		     JobKey key = new JobKey(jobAndTri.getJobName(),jobAndTri.getJobGroup());
		     scheduler.pauseJob(key);
		} catch (SchedulerException e) {
			 e.printStackTrace();
			 return Result.error();
		}
		return Result.ok();
	}
	
	@PostMapping("/resume")
	public  Result resume(JobAndTrigger jobAndTri,HttpServletResponse response) {
		LOGGER.info("恢复任务");
		try {
		     JobKey key = new JobKey(jobAndTri.getJobName(),jobAndTri.getJobGroup());
		     scheduler.resumeJob(key);
		} catch (SchedulerException e) {
			 e.printStackTrace();
			 return Result.error();
		}
		return Result.ok();
	}
	
	@PostMapping("/remove")
	public  Result remove(JobAndTrigger jobAndTri,HttpServletResponse response) {
		try {  
            TriggerKey triggerKey = TriggerKey.triggerKey(jobAndTri.getJobName(), jobAndTri.getJobGroup());  
            // 停止触发器  
            scheduler.pauseTrigger(triggerKey);  
            // 移除触发器  
            scheduler.unscheduleJob(triggerKey);  
            // 删除任务  
            scheduler.deleteJob(JobKey.jobKey(jobAndTri.getJobName(), jobAndTri.getJobGroup()));  
            System.out.println("removeJob:"+JobKey.jobKey(jobAndTri.getJobName()));  
        } catch (Exception e) {  
        	e.printStackTrace();
            return Result.error();
        }  
		return Result.ok();
	}
}
