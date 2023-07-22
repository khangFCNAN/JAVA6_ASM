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
	
	@RequestMapping("/quanLySanPham")
	public String quanLySanPham(Model model) {
		return "/homeAD/quanLySanPham";
	}
	@RequestMapping("/quanLyDonHang")
	public String quanLyHoaDon(Model model) {
		return "/homeAD/quanLyDonHang";
	}
	@RequestMapping("/quanLyChiTietDonhang")
	public String quanLyChTietHoaDon(Model model) {
		return "/homeAD/quanLyChiTietDonhang";
	}
	@RequestMapping("/capNhatTrangThai")
	public String capNhatTrangThai(Model model) {
		return "/homeAD/capNhatTrangThai";
	}
}
