package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexAD")
public class indexADController {
	
	@RequestMapping("/form")
	public String index(Model model) {
		return "/homeAD/indexAD";
	}
}
