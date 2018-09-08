package com.seezoon.druid.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seezoon.druid.entity.DemoUser;
import com.seezoon.druid.one.dao.DemoUserDao1;
import com.seezoon.druid.two.dao.DemoUserDao2;

@Service
@Transactional
public class DemoService {

	@Autowired
	private DemoUserDao1 demoUserDao1;
	@Autowired
	private DemoUserDao2 demoUserDao2;
	
	public void save() {
		DemoUser demoUser = new DemoUser();
		demoUser.setId("1");
		demoUser.setAge(1);
		demoUser.setName("s");
		demoUser.setBirthday(new Date());
		demoUser.setCreateBy("1");
		demoUser.setCreateDate(new Date());
		demoUser.setUpdateBy("1");
		demoUser.setUpdateDate(new Date());
		demoUserDao1.insert(demoUser);
		demoUserDao2.insert(demoUser);
	}
}
