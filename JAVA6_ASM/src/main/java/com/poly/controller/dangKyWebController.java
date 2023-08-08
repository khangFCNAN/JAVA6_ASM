package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.KhachHang;
@CrossOrigin("*")
@Controller
@RequestMapping("dangKy")
public class dangKyWebController {
	@RequestMapping("/User")
	public String DangKy(Model model,KhachHang khachhang) {
		
		return "/home/DangKy";
	}
}
