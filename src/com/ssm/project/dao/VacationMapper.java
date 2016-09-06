package com.ssm.project.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.ssm.project.model.Vacation;
import com.ssm.project.model.VacationExample;

public interface VacationMapper {
    int countByExample(VacationExample example);

    int deleteByExample(VacationExample example);

    int deleteByPrimaryKey(Integer vId);

    int insert(Vacation record);

    int insertSelective(Vacation record);

    Page<Vacation> selectByExample(VacationExample example);

    Vacation selectByPrimaryKey(Integer vId);

    int updateByExampleSelective(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByExample(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByPrimaryKeySelective(Vacation record);

    int updateByPrimaryKey(Vacation record);
}