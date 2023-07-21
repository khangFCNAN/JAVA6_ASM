package com.poly.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class indexController {
	
	@RequestMapping("/form")
	public String index(Model model) {
		return "home/index";
	}
	
	@RequestMapping("/sanpham")
	public String sanpham(Model model) {
		return "home/sanpham";
	}
	
	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "home/giohang";
	}
}
