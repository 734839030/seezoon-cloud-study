package com.seezoon.spring.cloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="spring-cloud-provider", fallback=SpringCloudServiceFallback.class,fallbackFactory=SpringCloudServiceFallbackFactory.class)
public interface SpringCloudService {
	@RequestMapping("/say")
	public String say(@RequestParam(name="msg") String msg);
	@RequestMapping("/get/{id}")
	public UserInfoDto get(@PathVariable("id") String id);
	
	@RequestMapping(value="/save")
	public int save(UserInfoDto dto);
	
}
