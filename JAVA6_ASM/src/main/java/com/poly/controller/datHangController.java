package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.service.DonHangService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class datHangController {
	DonHangService orderService;       
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "/home/testGioHang";
	}
	
	@RequestMapping("/giohang/dathang")
	public String checkout() {
		return "/home/dathang";
	}
	
	@RequestMapping("/giohang/lichsu")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("lichsus", orderService.findByTaiKhoan(username));
		return "home/lichsu";
	}
	
	@RequestMapping("/dathang/lichsu/{idHd}")
	public String detail(@PathVariable("idHd") Integer idHd, Model model) {
		model.addAttribute("lichsu", orderService.findById(idHd));
		return "home/lichsu";
	}
}
    