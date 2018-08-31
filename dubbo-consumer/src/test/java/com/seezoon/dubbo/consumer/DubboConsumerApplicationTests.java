
package com.seezoon.dubbo.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seezoon.dubbo.api.UserInfoService;
import com.seezoon.dubbo.api.dto.UserInfoDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Rollback(false)
public  class DubboConsumerApplicationTests {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserInfoService userInfoService;
	@Test
	public void t1() {
		UserInfoDto userInfoDto = userInfoService.get("1");
		System.out.println(userInfoDto.getName());
	}
}