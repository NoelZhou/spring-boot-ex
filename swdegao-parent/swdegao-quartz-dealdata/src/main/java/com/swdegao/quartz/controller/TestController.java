package com.swdegao.quartz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.swdegao.quartz.entity.JobAndTrigger;
import com.swdegao.quartz.service.ICuiHService;
import com.swdegao.quartz.service.IJobAndTriggerService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	public IJobAndTriggerService iJobAndTriggerService;
	
	@Autowired
	public ICuiHService iCuiHService;
	
	@PostMapping("/listDS")
	public List<JobAndTrigger> test1(Integer pageNo,Integer pageSize){
		PageInfo<JobAndTrigger> pInfo = iJobAndTriggerService.getJobAndTriggerDetails(null, pageNo, pageSize);
		List<JobAndTrigger> list = pInfo.getList();
		return list;
	}
	
	@GetMapping("/list")
	public List<JobAndTrigger> test2(Integer pageNo,Integer pageSize){
		PageInfo<JobAndTrigger> pInfo = iJobAndTriggerService.getJobAndTriggerDetails(null, pageNo, pageSize);
		List<JobAndTrigger> list = pInfo.getList();
		return list;
	}
}
