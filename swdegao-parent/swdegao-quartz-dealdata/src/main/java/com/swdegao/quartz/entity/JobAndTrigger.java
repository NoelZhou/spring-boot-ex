package com.swdegao.quartz.entity;

import com.swdegao.quartz.job.BaseJob;

/**
 * 实体类
 */
public class JobAndTrigger{
	
	/**
	 * 任务定义实例
	 */
	private Boolean isInstall;
	private String displayName;
	private String cronVersion;
	private String author;
	/**
	 * 数据库中实例
	 */
	private String triggerOnceState;
	private String jobName;//任务名称
	private String jobGroup;//任务分组
	private String description;//任务描述
	private String jobClassName;//执行类
	private String cronExpression;//执行时间
	private String triggerName;//
	private String triggerState;//任务状态
	private String nextFireTime;//下次执行时间
	private String prevFireTime;//上次执行时间
	
	private String oldJobName;//任务名称 用于修改
	private String oldJobGroup;//任务分组 用于修改
	
	public JobAndTrigger() {
		super();
	}
	public JobAndTrigger(Boolean isInstall,BaseJob baseJob, String jobClassName) {
		super();
		this.setIsInstall(isInstall);
		this.jobName = baseJob.getJobName();
		this.jobGroup = baseJob.getGroupName();
		this.description = baseJob.getDescription();
		this.jobClassName = jobClassName;
		this.displayName = baseJob.getDisplayName();
		this.cronVersion = baseJob.getCronVersion();
		this.author = baseJob.getAuthor();
	}
	
	public JobAndTrigger(String triggerOnceState,String jobName, String jobGroup) {
		super();
		this.triggerOnceState = triggerOnceState;
		this.jobName = jobName;
		this.jobGroup = jobGroup;
	}

	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getTriggerState() {
		return triggerState;
	}
	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}
	public String getOldJobName() {
		return oldJobName;
	}
	public void setOldJobName(String oldJobName) {
		this.oldJobName = oldJobName;
	}
	public String getOldJobGroup() {
		return oldJobGroup;
	}
	public void setOldJobGroup(String oldJobGroup) {
		this.oldJobGroup = oldJobGroup;
	}
	public Boolean getIsInstall() {
		return isInstall;
	}
	public void setIsInstall(Boolean isInstall) {
		this.isInstall = isInstall;
	}
	
	public String getNextFireTime() {
		return nextFireTime;
	}
	public String getPrevFireTime() {
		return prevFireTime;
	}
	public void setNextFireTime(String nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
	public void setPrevFireTime(String prevFireTime) {
		this.prevFireTime = prevFireTime;
	}
	public String getDisplayName() {
		return displayName;
	}
	public String getCronVersion() {
		return cronVersion;
	}
	public String getAuthor() {
		return author;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public void setCronVersion(String cronVersion) {
		this.cronVersion = cronVersion;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTriggerOnceState() {
		return triggerOnceState;
	}
	public void setTriggerOnceState(String triggerOnceState) {
		this.triggerOnceState = triggerOnceState;
	}
}
