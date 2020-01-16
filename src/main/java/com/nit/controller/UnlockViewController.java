package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.constant.Constant;
import com.nit.domain.StudentUnlock;	
import com.nit.entity.StudentEntity;
import com.nit.service.StudentService;

@Controller
public class UnlockViewController {
	@Autowired
	private StudentService service;

	/**
	 * This method is used for lunch unlock form page
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unlock")
	public String unlockAccount(HttpServletRequest req, Model model) {
		StudentUnlock unlock = new StudentUnlock();
		unlock.setEmail(req.getParameter("email"));
		model.addAttribute("unlock", unlock);
		return "unlock";

	}

	/**
	 * This method is used for unlock Account
	 * 
	 * @param unlock
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/active")
	public String acctiveAccount(@ModelAttribute("unlock") StudentUnlock unlock, Model model) {
		StudentEntity entity = service.fetchDatabypwsandemail(unlock);
		if (entity == null) {
			String uemsg = Constant.uemsg;
			model.addAttribute("uemsg", uemsg);
		} else {
			String usmsg = Constant.usmsg;
			model.addAttribute("usmsg", usmsg);
		}

		return "unlock";

	}

}
