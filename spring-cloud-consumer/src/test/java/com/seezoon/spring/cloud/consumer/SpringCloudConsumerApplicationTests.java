
package com.seezoon.spring.cloud.consumer;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seezoon.spring.cloud.consumer.service.SpringCloudService;
import com.seezoon.spring.cloud.consumer.service.UserInfoDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Rollback(false)
public class SpringCloudConsumerApplicationTests {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SpringCloudService springCloudService;
	@Autowired
	private Environment environment;
	@Test
	public void t0() throws InterruptedException {
		String property = environment.getProperty("hystrix.command.SpringCloudService#say(String).circuitBreaker.requestVolumeThreshold");
		
		String say = springCloudService.say("world");
		System.out.println("say:" + say);
	}
	@Test
	public void t1() throws InterruptedException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(50);
		newFixedThreadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				String say = springCloudService.say("world");
				System.out.println("say:" + say);
			}
		});
		newFixedThreadPool.awaitTermination(1, TimeUnit.HOURS);
	}
	@Test
	public void t2() {
		UserInfoDto userInfoDto = springCloudService.get("1");
		System.out.println("userInfoDto:" + userInfoDto.getName());
	}
	@Test
	public void t3() {
		UserInfoDto dto = new UserInfoDto();
		dto.setId("dsadsa");
		dto.setBirthday(new Date());
		dto.setName("hdf" + "dsadsa");
		int i = springCloudService.save(dto);
		System.out.println("userInfoDto save:" + i);
	}
}
