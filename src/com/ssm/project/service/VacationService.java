package com.ssm.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.VacationMapper;
import com.ssm.project.model.Vacation;
import com.ssm.project.model.VacationExample;
import com.ssm.project.util.BaseServices;

@Service
public class VacationService extends BaseServices {

	private VacationMapper vacationMapper;

	public VacationMapper getVacationMapper() {
		return vacationMapper;
	}

	@Resource
	public void setVacationMapper(VacationMapper vacationMapper) {
		this.vacationMapper = vacationMapper;
	}

	/**
	 * list
	 */
	public List<Vacation> findByPage(Integer pageNum, Integer pageSize) {
		logger.info("假期信息");
		List<Vacation> list = null;
		try {
			PageHelper.startPage(pageNum, pageSize);
			VacationExample example = new VacationExample();
			example.createCriteria().andVIdIsNotNull();
			list = vacationMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}

	/**
	 * list
	 */
	public List<Vacation> findAll() {
		logger.info("假期信息");
		List<Vacation> list = null;
		try {
			VacationExample example = new VacationExample();
			example.createCriteria().andVIdIsNotNull();
			list = vacationMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}

	/**
	 * nextPage
	 */
	public int searchRecordsNextPage(Integer pageSize) {
		VacationExample example = new VacationExample();
		example.createCriteria().andVIdIsNotNull();
		int total = vacationMapper.countByExample(example);
		int pageNo = total / pageSize;
		if (total % pageSize > 0) {
			pageNo++;
		}
		return pageNo;
	}

	/**
	 * add
	 */
	public boolean save(Vacation vacation) {
		logger.info("保存假期信息");
		try {
			int count = vacationMapper.insert(vacation);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return false;
	}

	/**
	 * detail
	 */
	public Vacation findDetail(Integer vId) {
		logger.info("获取申请信息");
		Vacation vacation = null;
		try {
			vacation = vacationMapper.selectByPrimaryKey(vId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return vacation;
	}

	/**
	 * audit
	 */
	public boolean update(Vacation vacation) {
		logger.info("是否审核");
		int count = 0;
		try {
			count = vacationMapper.updateByPrimaryKey(vacation);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return false;
	}

	/**
	 * delete
	 */
	public boolean delete(Integer id) {
		logger.info("取消或删除申请");
		try {
			int count = vacationMapper.deleteByPrimaryKey(id);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return false;
	}
}