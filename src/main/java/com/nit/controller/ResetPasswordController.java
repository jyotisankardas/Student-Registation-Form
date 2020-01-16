package com.nit.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.domain.ResetPassword;
import com.nit.service.StudentService;

@Controller
public class ResetPasswordController {

	@Autowired
	private StudentService service;

	/**
	 * This method is used for open  page for Reset password 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/resetpassword")
	public String restpasswordForm(Model model) {
		ResetPassword reset = new ResetPassword();
		model.addAttribute("reset", reset);
		return "reset";
	}

	/**
	 * This method is used for get password
	 * @param reset
	 * @param model
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/showpws")
	public String getPassword(@ModelAttribute("reset") ResetPassword reset, Model model)
			throws MessagingException, IOException {
		String msg = service.getPassword(reset);

		model.addAttribute("msg", msg);
		return "reset";
	}

}
