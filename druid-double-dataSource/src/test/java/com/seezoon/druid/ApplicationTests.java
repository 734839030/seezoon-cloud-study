
package com.seezoon.druid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seezoon.druid.entity.DemoUser;
import com.seezoon.druid.one.dao.DemoUserDao1;
import com.seezoon.druid.service.DemoService;
import com.seezoon.druid.two.dao.DemoUserDao2;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Rollback(false)
public  class ApplicationTests {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DemoUserDao1 demoUserDao1;
	@Autowired
	private DemoUserDao2 demoUserDao2;
	@Autowired
	private DemoService demoService;
	@Test
	public void t1() {
		DemoUser selectByPrimaryKey = demoUserDao1.selectByPrimaryKey("16dca42ba8df4fa894df0b9d9a900ad2");
		logger.info(selectByPrimaryKey.getId());
		DemoUser selectByPrimaryKey2 = demoUserDao2.selectByPrimaryKey("16dca42ba8df4fa894df0b9d9a900ad2");
		logger.info(selectByPrimaryKey2.getId());
	}
	
	@Test
	public void t2() {
		demoService.save();
	}
}