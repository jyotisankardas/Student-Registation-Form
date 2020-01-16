package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.constant.Constant;
import com.nit.domain.Student;
import com.nit.service.StudentService;

@Controller
public class ViewStudentController {

	@Autowired
	private StudentService service;

	/**
	 * This method is used for lunch registration form page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String lunchFormPage(Model model) {
		Student stu = new Student();
		model.addAttribute("student", stu);

		return "registationForm";
	}

	/**
	 * This method is used for registrations
	 * 
	 * @param stu
	 * @param attributes
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerDetails(@ModelAttribute("student") Student stu, RedirectAttributes attributes)
			throws Exception {

		boolean insertValue = service.insertValue(stu, randomAlphaNumeric(7));

		String vsmsg;
		String vemsg;

		if (insertValue == true) {
			vsmsg = Constant.vsmsg;
			attributes.addFlashAttribute("vsmsg", vsmsg);
		} else {
			vemsg = Constant.vemsg;
			attributes.addFlashAttribute("vemsg", vemsg);
		}

		return "redirect:/view";

	}

	/**
	 * This method is used for create AplphaNumeric password
	 */
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int counnt) {
		StringBuilder builder = new StringBuilder();
		while (counnt-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	@RequestMapping(value = "/email")
	public @ResponseBody String fetchemailId(HttpServletRequest req) {
		String studentEmail = req.getParameter("email");
		System.out.println(studentEmail);
		return service.getEmailId(studentEmail);
	}

}
