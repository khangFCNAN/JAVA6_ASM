package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexAD")
public class indexADController {
	
	@RequestMapping("/form")
	public String index(Model model) {
		return "/homeAD/indexAD";
	}
	
	@RequestMapping("/quanLySanPham")
	public String quanLySanPham(Model model) {
		return "/homeAD/quanLySanPham";
	}
	
	@GetMapping("/thongke/form")
	public String quanLyThongKe(Model model) {
		return "/homeAD/QLThongKe";
	}
	
	@GetMapping("/thongke/form2")
	public String quanLyThongKe2(Model model) {
		return "/homeAD/QLThongKe2";
	}
}
