package com.ssm.project.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.project.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class UserMapperTest {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Test
	public void test() {
		User user = new User();
		user.setuId(105);
		user.setUpassword("accp");
		User user2 = userMapper.login(user);
		System.out.println(user2.getNickname());
	}

	@Test
	public void test1() {
		User user = new User();
		user.setUtelephone("12345678");
		int count = userMapper.updateByPrimaryKey(user);
		System.out.println(count);
	}
}
