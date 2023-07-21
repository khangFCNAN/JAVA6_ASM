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
	
	@RequestMapping("/thuongHieu")
	public String thuongHieu(Model model) {
		return "/homeAD/thuongHieu";
	}
	
	@RequestMapping("/phanLoai")
	public String phanLoai(Model model) {
		return "/homeAD/quanLyLoaiSP";
	}
	
	@RequestMapping("/khachHang")
	public String khachHang(Model model) {
		return "/homeAD/quanLyKhachHang";
	}
	
	@RequestMapping("/thongKe1")
	public String thongKe1(Model model) {
		return "/homeAD/quanLyThongKe1";
	}
	
	@RequestMapping("/thongKe2")
	public String thongKe2(Model model) {
		return "/homeAD/quanLyThongKe2";
	}
	
}
