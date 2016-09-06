package com.ssm.project.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.project.service.UserService;

@Controller
@RequestMapping("/mvc")
public class ProviderController {

	@Resource
	private UserService userService;

	@RequestMapping("/list")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("a", "aaaa");
		return new ModelAndView("index");
	}

	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "index";
	}

	@RequestMapping(value = "/response", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public void handle(@RequestBody String body, Writer writer) throws IOException {
		writer.write(body);
	}

	@RequestMapping("/ajax")
	@ResponseBody
	public Object ajax(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		list.add("电视");
		list.add("洗衣机");
		list.add("冰箱");
		list.add("电脑");
		list.add("汽车");
		list.add("空调");
		list.add("自行车");
		list.add("饮水机");
		list.add("热水器");
		return list;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
