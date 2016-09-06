package com.ssm.project.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.ssm.project.model.Email;
import com.ssm.project.model.EmailExample;

public interface EmailMapper {

	int countByExample(EmailExample example);

	int deleteByExample(EmailExample example);

	int deleteByPrimaryKey(Integer eId);

	int insert(Email record);

	int insertSelective(Email record);

	Email selectByPrimaryKey(Integer eId);

	int updateByExampleSelective(@Param("record") Email record, @Param("example") EmailExample example);

	int updateByExample(@Param("record") Email record, @Param("example") EmailExample example);

	int updateByPrimaryKeySelective(Email record);

	int updateByPrimaryKey(Email record);

	Page<Email> selectByExample(EmailExample example);

}