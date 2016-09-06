package com.ssm.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.EmailMapper;
import com.ssm.project.dao.UserMapper;
import com.ssm.project.model.Email;
import com.ssm.project.model.EmailExample;
import com.ssm.project.model.User;
import com.ssm.project.model.UserExample;
import com.ssm.project.util.BaseServices;

@Service
public class EmailService extends BaseServices {
	private EmailMapper emailMapper;
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public EmailMapper getEmailMapper() {
		return emailMapper;
	}

	@Resource
	public void setEmailMapper(EmailMapper emailMapper) {
		this.emailMapper = emailMapper;
	}

	/**
	 * write
	 */
	public List<User> saveWrite() {
		logger.info("写邮件");
		List<User> list = new ArrayList<User>();
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUnameIsNotNull();
			list = userMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}

	/**
	 * save
	 */
	public int save(Email email) {
		logger.info("保存发件信息");
		int count = 0;
		try {
			if (email != null) {
				emailMapper.insert(email);
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return count;
	}

	/**
	 * list
	 */
	public List<Email> findReveive(Integer pageNum, Integer pageSize, String nickname) {
		logger.info("收件箱");
		List<Email> list = new ArrayList<Email>();
		try {
			PageHelper.startPage(pageNum, pageSize);
			EmailExample example = new EmailExample();
			example.createCriteria().andEIdIsNotNull().andIsdeletedEqualTo(0).andRecipientsEqualTo(nickname);
			list = emailMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}

	/**
	 * 收件箱查看下一页
	 */
	public int searchRecordsNextPage(Integer pageSize, String userName) {
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull().andIsdeletedEqualTo(0).andRecipientsEqualTo(userName);
		int total = emailMapper.countByExample(example);
		int pageNo = total / pageSize;
		if (total % pageSize > 0) {
			pageNo++;
		}
		return pageNo;
	}

	/**
	 * recycle
	 */
	public List<Email> findRecycle(Integer pageNum, Integer pageSize, String nickname) {
		logger.info("回收站");
		List<Email> list = new ArrayList<Email>();
		try {
			PageHelper.startPage(pageNum, pageSize);
			EmailExample example = new EmailExample();
			example.createCriteria().andEIdIsNotNull().andIsdeletedEqualTo(1).andRecipientsEqualTo(nickname);
			list = emailMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}
	/**
	 * 垃圾箱查看下一页
	 */
	public int searchRecordsNextPageByRecycle(Integer pageSize, String userName) {
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull().andIsdeletedEqualTo(1).andRecipientsEqualTo(userName);
		int total = emailMapper.countByExample(example);
		int pageNo = total / pageSize;
		if (total % pageSize > 0) {
			pageNo++;
		}
		return pageNo;
	}
	/**
	 * reduction
	 */
	public boolean updateReduction(Integer id) {
		logger.info("还原");
		try {
			Email email = emailMapper.selectByPrimaryKey(id);
			email.setIsdeleted(0);
			int count = emailMapper.updateByPrimaryKey(email);
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
	 * deleteVirtual
	 */
	public boolean deleteVirtual(Integer id) {
		logger.info("更新邮件");
		try {
			Email email = findDetail(id);
			email.setIsread("已读");
			email.setIsdeleted(1);
			int count = emailMapper.updateByPrimaryKey(email);
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
		logger.info("删除");
		try {
			int count = emailMapper.deleteByPrimaryKey(id);
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
	public Email findDetail(Integer id) {
		logger.info("邮件详情");
		Email email = null;
		try {
			email = emailMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return email;
	}

	/**
	 * update
	 */
	public boolean update(Integer id) {
		logger.info("更新邮件");
		try {
			Email email = findDetail(id);
			email.setIsread("已读");
			int count = emailMapper.updateByPrimaryKey(email);
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
