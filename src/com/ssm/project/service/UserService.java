package com.ssm.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.UserMapper;
import com.ssm.project.model.User;
import com.ssm.project.model.UserExample;
import com.ssm.project.util.BaseServices;

@Service
public class UserService extends BaseServices {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 登录
	 * @param upk
	 * @param pwd
	 * @return
	 */
	public User getLogin(String upk, String pwd) {
		logger.info("用户登录");
		User user = new User();
		user.setuId(Integer.valueOf(upk));
		user.setUpassword(pwd);
		User user2 = userMapper.login(user);
		try {
			if (user2 == null) {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return user2;
	}

	/**
	 * 修改
	 */
	public int update(User user) {
		logger.info("修改用户");
		int count = 0;
		try {
			count = userMapper.updateByPrimaryKey(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return count;
	}

	/**
	 * list
	 */
	public List<User> findByPage(Integer pageNum, Integer pageSize) {
		logger.info("用户列表信息");
		List<User> list = null;
		try {
			PageHelper.startPage(pageNum, pageSize);
			UserExample example = new UserExample();
			example.createCriteria().andUIdIsNotNull();
			list = userMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return list;
	}

	/**
	 * 收件箱查看下一页
	 */
	public int searchRecordsNextPage(Integer pageSize) {
		UserExample example = new UserExample();
		example.createCriteria().andUIdIsNotNull();
		int total = userMapper.countByExample(example);
		int pageNo = total / pageSize;
		if (total % pageSize > 0) {
			pageNo++;
		}
		return pageNo;
	}

	/**
	 * add
	 */
	public boolean save(User user) {
		logger.info("添加用户");
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUnameEqualTo(user.getUname());
			List<User> users = userMapper.selectByExample(example);
			if (users.size() > 0) {
				return false;
			} else {
				userMapper.insert(user);
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
		logger.info("删除用户");
		try {
			int count = userMapper.deleteByPrimaryKey(id);
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
	 * updatepwd
	 */
	public boolean update(String pwd, Integer uId) {
		logger.info("修改密码");
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUIdEqualTo(uId);
			User user = new User();
			user.setUpassword(pwd);
			user.setuId(uId);
			int count=userMapper.updateByExampleSelective(user, example);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return false;
	}

	/**
	 * checkName
	 * @param uname
	 * @return
	 */
	public List<User> searchCheckUnameOnly(String uname) {
		// TODO Auto-generated method stub
		logger.info("验证用户名唯一");
		List<User> users = null;
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUnameEqualTo(uname);
			users = userMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作失败" + e.getMessage());
		}
		return users;
	}
}
