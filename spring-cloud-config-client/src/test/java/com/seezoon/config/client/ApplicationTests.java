
package com.seezoon.config.client;

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
	private Environment environment;
	//官方推荐用git + spring bus 来做配置中心，简单项目最好还是直接用spring-cloud-zookeeper-config + zkUI 自动完成参数刷新
	@Test
	public void t1() {
		System.out.println(environment.getProperty("author.name"));
	}
}