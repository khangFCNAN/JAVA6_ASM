package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class indexController {
	
	@RequestMapping("/form")
	public String index(Model model) {
		return "/home/index";
	}
	
	@RequestMapping("/sanpham")
	public String sanpham(Model model) {
		return "/home/sanpham";
	}
	
	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "/home/giohang";
	}

}
