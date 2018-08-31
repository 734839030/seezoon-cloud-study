package com.seezoon.spring.cloud.provider.service;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudService {

	@RequestMapping("/say")
	public String say(String msg) {
		return "hello " + msg;
	}
	
	@RequestMapping("/get/{id}")
	public UserInfoDto get(@PathVariable("id") String id) {
		UserInfoDto dto = new UserInfoDto();
		dto.setId(id);
		dto.setBirthday(new Date());
		dto.setName("hdf" + id);
		return dto;
	}
	@RequestMapping("/save")
	public int save(@RequestBody UserInfoDto dto) {
		System.out.println(dto.toString());
		return 1;
	}
	
}
