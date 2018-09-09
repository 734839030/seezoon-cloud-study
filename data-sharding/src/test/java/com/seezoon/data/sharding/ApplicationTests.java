
package com.seezoon.data.sharding;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seezoon.data.sharding.dao.DemoUserDao;
import com.seezoon.data.sharding.entity.DemoUser;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Rollback(false)
public  class ApplicationTests {

	@Autowired
	private DemoUserDao demoUserDao;
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void qry() {
		DemoUser record = new DemoUser();
		record.setUserId(1);
		List<DemoUser> selectList = demoUserDao.selectList(null);
		System.out.println(selectList.size());
	}
	@Test
	public void save() {
		DemoUser record = new DemoUser();
		record.setUserId(1);
		record.setName("黄扥风");
		demoUserDao.insert(record);
	}
}