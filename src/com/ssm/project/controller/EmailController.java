package com.ssm.project.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssm.project.model.Email;
import com.ssm.project.model.User;
import com.ssm.project.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController implements ServletContextAware {
	private ServletContext servletContext;
	private EmailService emailService;
	private static final Integer PAGE = 1;
	private static final Integer ROWS = 3;

	Map<String, Object> map = new HashMap<String, Object>();

	public EmailService getEmailService() {
		return emailService;
	}

	@Resource
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * 写邮件
	 */
	@RequestMapping(value = ("/write"), method = RequestMethod.GET)
	public String write(HttpServletRequest request) {
		List<User> list = emailService.saveWrite();
		if (list != null) {
			request.setAttribute("list", list);
			return "/jsp/email/write";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 上传邮件
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("accessory") CommonsMultipartFile file) {
		try {
			if (!file.isEmpty()) {
				String sender = request.getParameter("sender");
				String isread = request.getParameter("isread");
				String isdeleted = request.getParameter("isdeleted");
				String recipients = request.getParameter("recipients");
				String title = request.getParameter("title");
				String content = request.getParameter("content");

				String path = request.getSession().getServletContext().getRealPath("/download/");// 文件保存目录，也可自定为绝对路径
				String fileName = file.getOriginalFilename();// getOriginalFilename和getName是不一样的哦

				Email email = new Email();
				email.setSender(sender);
				email.setIsdeleted(Integer.valueOf(isdeleted));
				email.setIsread(isread);
				email.setRecipients(recipients);
				email.setTitle(title);
				email.setContent(content);
				email.setAccessory(fileName);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String time = sdf.format(date);
				email.setTime(time);
				emailService.save(email);

				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				//file.getFileItem().write(targetFile); //将上传的文件写入新建的文件中
				file.transferTo(targetFile);
				request.setAttribute("message", "上传成功");
				return "/jsp/email/write";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", "上传失败");
		return "/jsp/email/write";
	}

	/**
	 * 下载邮件(注意修改tomcat下的server.xml乱码问题)
	 * @throws IOException 
	 */
	@RequestMapping(value = ("/download"), method = { RequestMethod.POST, RequestMethod.GET })
	public String download(@RequestParam String fileName, HttpServletResponse response) throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String ctxPath = this.servletContext.getRealPath("/download/") + File.separator; //获取本地存储路径 "/download/";
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.reset();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			System.out.println(fileName);
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	/**
	 * 详情
	 */
	@RequestMapping(value = ("/detail"), method = RequestMethod.GET)
	public String detail(HttpServletRequest request, @RequestParam String EId) {
		Email email = emailService.findDetail(Integer.valueOf(EId));
		if (email != null) {
			request.setAttribute("email", email);
			return "/jsp/email/details";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 已读
	 */
	@RequestMapping(value = ("/update"), method = { RequestMethod.POST, RequestMethod.GET })
	public String update(@RequestParam String EId, @RequestParam("r") String nickname, RedirectAttributes attributes) {
		if (emailService.update(Integer.valueOf(EId))) {
			attributes.addAttribute("nickname", nickname).addFlashAttribute("message", "邮件已阅读！");
			return "redirect:/email/reveive";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 收件箱
	 */
	@RequestMapping(value = ("/reveive"), method = RequestMethod.GET)
	public String list(HttpServletRequest request, @RequestParam String nickname) {
		List<Email> list = emailService.findReveive(PAGE, ROWS, nickname);
		int totalPage = emailService.searchRecordsNextPage(ROWS, nickname);
		if (list != null) {
			request.setAttribute("list", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", PAGE);
			return "/jsp/email/index";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 删除至回收站
	 * @throws IOException 
	 */
	@RequestMapping(value = ("/deleteVirtual"))
	public String deleteVirtual(@RequestParam String EId, @RequestParam String nickname, RedirectAttributes attributes) {
		if (emailService.deleteVirtual(Integer.valueOf(EId))) {
			attributes.addAttribute("nickname", nickname).addFlashAttribute("message", "删除成功！");
			return "redirect:/email/reveive";
		}
		attributes.addAttribute("nickname", nickname).addFlashAttribute("message", "删除失败！");
		return "redirect:/email/reveive";
	}

	/**
	 * 回收站
	 */
	@RequestMapping(value = ("/recycle"), method = RequestMethod.GET)
	public String recycle(HttpServletRequest request, @RequestParam String r) {
		List<Email> list = emailService.findRecycle(PAGE, ROWS, r);
		int totalPage = emailService.searchRecordsNextPageByRecycle(ROWS, r);
		if (list != null) {
			request.setAttribute("list", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", PAGE);
			return "/jsp/email/delete";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 物理删除
	 */
	@RequestMapping(value = ("/delete"))
	public String delete(@RequestParam String EId, @RequestParam String r, RedirectAttributes attributes) {
		if (emailService.delete(Integer.valueOf(EId))) {
			attributes.addAttribute("r", r).addFlashAttribute("message", "删除成功！");
			return "redirect:/email/recycle";
		}
		attributes.addAttribute("r", r).addFlashAttribute("message", "删除失败！");
		return "redirect:/email/recycle";
	}

	/**
	 * 还原
	 */
	@RequestMapping(value = ("/reduction"))
	public String reduction(@RequestParam String EId, @RequestParam String r, RedirectAttributes attributes) {
		if (emailService.updateReduction(Integer.valueOf(EId))) {
			attributes.addAttribute("r", r).addFlashAttribute("message", "还原成功！");
			return "redirect:/email/recycle";
		}
		attributes.addAttribute("r", r).addFlashAttribute("message", "还原失败！");
		return "redirect:/email/recycle";
	}

	/**
	 * 收件箱分页查找下一页
	 * @return                               
	 */
	@RequestMapping(value = ("/selectNextPage"), method = RequestMethod.GET)
	public String selectNextPage(HttpServletRequest request) {
		int next = Integer.parseInt(request.getParameter("page"));
		User users = (User) request.getSession().getAttribute("user");
		String userName = users.getNickname();
		List<Email> list = emailService.findReveive(next, ROWS, userName);
		if (list != null) {
			int total = emailService.searchRecordsNextPage(ROWS, userName);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", next);
			request.setAttribute("totalPage", total);
		}
		return "/jsp/email/receiving";
	}

	/**
	 * 垃圾箱分页查找下一页
	 * @return                               
	 */
	@RequestMapping(value = ("/selectNextPageByRecycle"), method = RequestMethod.GET)
	public String selectNextPageByRecycle(HttpServletRequest request) {
		int next = Integer.parseInt(request.getParameter("page"));
		User users = (User) request.getSession().getAttribute("user");
		String userName = users.getNickname();
		List<Email> list = emailService.findRecycle(next, ROWS, userName);
		if (list != null) {
			int total = emailService.searchRecordsNextPageByRecycle(ROWS, userName);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", next);
			request.setAttribute("totalPage", total);
		}
		return "/jsp/email/delete";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
