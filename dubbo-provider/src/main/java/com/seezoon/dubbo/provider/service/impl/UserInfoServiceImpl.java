package com.seezoon.dubbo.provider.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.seezoon.dubbo.api.UserInfoService;
import com.seezoon.dubbo.api.dto.UserInfoDto;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public UserInfoDto get(String id) {
		UserInfoDto dto = new UserInfoDto();
		dto.setId(id);
		dto.setBirthday(new Date());
		dto.setName("hdf" + id);
		return dto;
	}

	@Override
	public List<UserInfoDto> findList() {
		return new ArrayList<UserInfoDto>();
	}

}
