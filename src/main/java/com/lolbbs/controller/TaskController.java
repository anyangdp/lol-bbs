package com.lolbbs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lolbbs.util.RequestData;

@RestController
public class TaskController {
	private RequestData requestData = new RequestData();
	
	@RequestMapping("/test")
	public Object queryTest() throws Exception{
		return "success";
	}
	
	@RequestMapping("/queryTask")
	public Object queryTask() throws Exception {
		Object obj = requestData.requestApiDataForPojo("?jobtype=100&action=query", HttpMethod.GET, new Object[]{},
				Object.class);
		return obj;
	}
	
}
