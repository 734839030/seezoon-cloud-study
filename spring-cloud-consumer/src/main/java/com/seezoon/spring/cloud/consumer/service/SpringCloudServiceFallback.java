package com.seezoon.spring.cloud.consumer.service;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class SpringCloudServiceFallback implements SpringCloudService{

	@Override
	public String say(String msg) {
		return "系统繁忙";
	}

	@Override
	public UserInfoDto get(String id) {
		return null;
	}

	@Override
	public int save(UserInfoDto dto) {
		return -1;
	}

}
