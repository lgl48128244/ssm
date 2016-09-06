package com.ssm.project.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssm.project.model.User;
import com.ssm.project.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService;
	private static final Integer PAGE = 1;
	private static final Integer ROWS = 3;

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 登录页面
	 */
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "/login";
	}

	/**
	 * login
	 * @param UId
	 * @param upassword
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/login")
	public String login(String UId, String upassword, HttpServletRequest request) {
		User user = userService.getLogin(UId, upassword);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			//页面跳转至欢迎界面(系统首页面)
			request.setAttribute("message", "登录成功！");
			return "/index";
		} else {
			//跳转至登录界面
			request.setAttribute("message", "登录失败,用户名或密码错误！");
			return "/login";
		}
	}

	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		request.setAttribute("message", "注销成功！");
		return "/login";
	}

	/**
	 * userinfo
	 */
	@RequestMapping("/info")
	public String info(HttpServletRequest request, @RequestParam("uId") String uid, @RequestParam("upassword") String upassword) {
		User user = userService.getLogin(uid, upassword);
		request.setAttribute("user", user);
		return "/jsp/user/user_editor";
	}

	/**
	 * edit
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(User user, HttpServletRequest request) {
		int count = userService.update(user);
		if (count > 0) {
			request.setAttribute("message", "修改成功");
			return "/jsp/user/user";
		} else {
			request.setAttribute("message", "修改失败");
			return "/jsp/user/user";
		}
	}

	/**
	 * list
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		List<User> userslist = userService.findByPage(PAGE, ROWS);
		int totalPage = userService.searchRecordsNextPage(ROWS);
		if (userslist != null) {
			request.setAttribute("userslist", userslist);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", PAGE);
			return "/jsp/user/account_list";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * nextPage
	 * @return                               
	 */
	@RequestMapping("/selectNextPage")
	public String selectNextPage(HttpServletRequest request) {
		int next = Integer.parseInt(request.getParameter("page"));
		List<User> userslist = userService.findByPage(next, ROWS);
		if (userslist != null) {
			int total = userService.searchRecordsNextPage(ROWS);
			request.setAttribute("userslist", userslist);
			request.setAttribute("currentPage", next);
			request.setAttribute("totalPage", total);
		}
		return "/jsp/user/account_list";
	}

	/**
	 * add
	 */
	@RequestMapping("/add")
	public String add(User user, RedirectAttributes attributes) {
		if (userService.save(user)) {
			attributes.addFlashAttribute("message", "添加成功");
			return "redirect:/user/list";
		} else {
			attributes.addFlashAttribute("message", "添加失败");
			return "redirect:/user/list";
		}
	}

	/**
	 * checkName
	 * @throws IOException 
	 */
	@RequestMapping("/checkName")
	public void checkName(@RequestParam String uname, HttpServletResponse response) throws IOException {
		//去数据库进行唯一验证
		List<User> users = userService.searchCheckUnameOnly(uname);
		if (users.size() > 0) {
			response.getWriter().print("false");
		} else {
			response.getWriter().print("true");
		}
	}

	/**
	 * update
	 * @throws IOException 
	 */
	@RequestMapping("/update")
	public String update(String uId, @RequestParam("password") String upassword, HttpServletRequest request) {
		if (userService.update(upassword, Integer.valueOf(uId))) {
			request.setAttribute("message", "密码修改成功，请重新登录！");
			return "/jsp/user/account_editor";
		}
		request.setAttribute("message", "密码修改失败！");
		return "/jsp/user/account_editor";
	}

	/**
	 * delete
	 */
	@RequestMapping("/userdelete")
	public String delete(@RequestParam String id, RedirectAttributes attributes) {
		if (userService.delete(Integer.valueOf(id))) {
			attributes.addFlashAttribute("message", "删除成功");
			return "redirect:/user/list";
		}
		attributes.addFlashAttribute("message", "删除失败");
		return "redirect:/user/list";
	}
}
