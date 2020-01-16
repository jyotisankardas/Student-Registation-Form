package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.constant.Constant;
import com.nit.domain.StudentLogin;
import com.nit.entity.StudentEntity;
import com.nit.service.StudentService;

@Controller
public class StudentLogInController {

	@Autowired
	private StudentService service;

	/**
	 * This method is used for lunch login form page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String lunchLoginPage(Model model) {
		StudentLogin login = new StudentLogin();
		model.addAttribute("login", login);
		return "login";
	}

	/**
	 * This method is used for get data form db s/w
	 * 
	 * @param login
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("login") StudentLogin login, Model model) {
		StudentEntity entity = service.getdatabymailandpws(login);
		if (entity != null) {
			String smsg = Constant.smsg;
			model.addAttribute("smsg", smsg);
			return "redirect:/dasboard";

		} else {
			String emsg = Constant.emsg;
			model.addAttribute("emsg", emsg);
		}

		return "login";

	}
}
