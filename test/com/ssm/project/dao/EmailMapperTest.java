package com.ssm.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.project.model.Email;
import com.ssm.project.model.EmailExample;
import com.ssm.project.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class EmailMapperTest {

	private EmailMapper emailMapper;
	private EmailService emailService;

	public EmailMapper getEmailMapper() {
		return emailMapper;
	}

	@Resource
	public void setEmailMapper(EmailMapper emailMapper) {
		this.emailMapper = emailMapper;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	@Resource
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Test
	public void test() {
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull();
		List<Email> list = emailMapper.selectByExample(example);
		for (Email email : list) {
			System.out.println(email.getTitle());
		}

	}

	@Test
	public void test1() {
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull().andIsreadEqualTo("已读").andRecipientsEqualTo("hahaa");
		List<Email> list = emailMapper.selectByExample(example);
		for (Email email : list) {
			System.out.println(email.getContent());
		}
	}

	
	@Test
	public void test3() {
		
	}
}
