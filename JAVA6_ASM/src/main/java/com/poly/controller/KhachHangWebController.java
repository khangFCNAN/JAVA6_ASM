package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KhachHangWebController {
	@RequestMapping("/quanLyKhachHang/list")
	public String thuongHieu(Model model) {
		return "/homeAD/quanLyKhachHang";
	}
}
