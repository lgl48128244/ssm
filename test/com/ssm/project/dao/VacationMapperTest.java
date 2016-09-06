package com.ssm.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.project.model.Vacation;
import com.ssm.project.model.VacationExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:./config/applicationContext.xml" })
public class VacationMapperTest {

	private VacationMapper vacationMapper;

	public VacationMapper getVacationMapper() {
		return vacationMapper;
	}

	@Resource
	public void setVacationMapper(VacationMapper vacationMapper) {
		this.vacationMapper = vacationMapper;
	}

	@Test
	public void test() {
		VacationExample example = new VacationExample();
		example.createCriteria().andVIdIsNotNull();
		List<Vacation> list = vacationMapper.selectByExample(example);
		for (Vacation vacation : list) {
			System.out.println(vacation.getName());
		}
	}
}
