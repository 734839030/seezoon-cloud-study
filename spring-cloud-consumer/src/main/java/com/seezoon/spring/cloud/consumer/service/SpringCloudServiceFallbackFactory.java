package com.seezoon.spring.cloud.consumer.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

// fallback trigger
@Component
public class SpringCloudServiceFallbackFactory implements FallbackFactory<SpringCloudService> {
	@Override
	public SpringCloudService create(Throwable cause) {
		return new SpringCloudService() {

			@Override
			public String say(String msg) {
				throw new RuntimeException(cause.getMessage());
			}

			@Override
			public UserInfoDto get(String id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int save(UserInfoDto dto) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
}