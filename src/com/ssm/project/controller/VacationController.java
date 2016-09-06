package com.ssm.project.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssm.project.model.Vacation;
import com.ssm.project.service.VacationService;

@Controller
@RequestMapping("/vacation")
public class VacationController {

	private VacationService vacationService;
	private static final Integer PAGE = 1;
	private static final Integer ROWS = 3;

	public VacationService getVacationService() {
		return vacationService;
	}

	@Resource
	public void setVacationService(VacationService vacationService) {
		this.vacationService = vacationService;
	}

	/**
	 * 假期列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		List<Vacation> list = vacationService.findByPage(PAGE, ROWS);
		int totalPage = vacationService.searchRecordsNextPage(ROWS);
		if (list != null) {
			request.setAttribute("list", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", PAGE);
			return "/jsp/vacation/vacation";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 分页查找下一页
	 * @return                               
	 */
	@RequestMapping("/selectNextPage")
	public String selectNextPage(HttpServletRequest request) {
		int next = Integer.parseInt(request.getParameter("page"));
		List<Vacation> list = vacationService.findByPage(next, ROWS);
		if (list != null) {
			int total = vacationService.searchRecordsNextPage(ROWS);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", next);
			request.setAttribute("totalPage", total);
		}
		return "/jsp/vacation/vacation";
	}

	/**
	 * 申请前准备
	 */
	@RequestMapping("/apply")
	public String apply(HttpServletRequest request) {
		List<Vacation> list = vacationService.findAll();
		request.setAttribute("list", list);
		return "/jsp/vacation/vacation_apply";
	}

	/**
	 * 申请休假
	 */
	@RequestMapping("/add")
	public String add(Vacation vacation, RedirectAttributes attributes) {
		if (vacationService.save(vacation)) {
			attributes.addFlashAttribute("message", "申请成功");
			return "redirect:/vacation/list";
		}
		attributes.addFlashAttribute("message", "申请失败");
		return "redirect:/vacation/list";
	}

	/**
	 * 审核前准备
	 */
	@RequestMapping("/detail")
	public String detail(String VId, HttpServletRequest request) {
		Vacation vacation = vacationService.findDetail(Integer.valueOf(VId));
		request.setAttribute("vacation", vacation);
		return "/jsp/vacation/vacation_audit";
	}

	/**
	 * 是否审核
	 */
	@RequestMapping("/audit")
	public String audit(Vacation vacation, RedirectAttributes attributes) {
		if (vacationService.update(vacation) && vacation.getIsstatus().equals("已审核")) {
			attributes.addFlashAttribute("message", "审核通过！");
			return "redirect:/vacation/list";
		}
		attributes.addFlashAttribute("message", "审核未通过");
		return "redirect:/vacation/list";
	}

	/**
	 * 取消审核
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam String id, @RequestParam String oper, RedirectAttributes attributes) {
		if (vacationService.delete(Integer.valueOf(id)) && "app".equals(oper)) {
			attributes.addFlashAttribute("message", "取消成功！");
			return "redirect:/vacation/list";
		} else {
			attributes.addFlashAttribute("message", "删除成功！");
			return "redirect:/vacation/list";
		}
	}
}
