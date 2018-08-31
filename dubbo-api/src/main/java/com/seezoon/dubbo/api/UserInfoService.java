package com.seezoon.dubbo.api;

import java.util.List;

import com.seezoon.dubbo.api.dto.UserInfoDto;

public interface UserInfoService {

	public UserInfoDto get(String id);
	public List<UserInfoDto> findList();
}
