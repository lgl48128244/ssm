package com.ssm.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class SpringView {

	/**
	 * ModelAndView
	 */
	@RequestMapping(value = "/show1", method = RequestMethod.POST)
	public ModelAndView show1(@RequestParam String name) {
		ModelAndView mv = new ModelAndView("/ssm/jsp/view/show.jsp");
		mv.addObject("name1", name);
		return mv;
	}
	@RequestMapping("/index")
	public String index(){
		return "/jsp/view/show";
	}
}
