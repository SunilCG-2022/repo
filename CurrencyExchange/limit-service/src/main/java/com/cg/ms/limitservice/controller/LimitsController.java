package com.cg.ms.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ms.limitservice.bean.Limits;
import com.cg.ms.limitservice.configuration.LimitsConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration configuration;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
		//return new Limits(1,1000);
		
	}

}
