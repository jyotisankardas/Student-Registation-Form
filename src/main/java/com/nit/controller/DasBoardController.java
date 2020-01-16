package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasBoardController {

	/**
	 * This method is used for open Dasboards
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dasboard")
	public String show(Model model) {

		return "dasboard";

	}

}
