package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("indexAD")
public class indexADController {
	
	@RequestMapping("form")
	public String index(Model model) {
		return "/homeAD/indexAD";
	}
	
	@GetMapping("/thongke/form")
	public String quanLyThongKe(Model model) {
		return "/homeAD/QLThongKe";
	}
	
	@GetMapping("/thongke/form2")
	public String quanLyThongKe2(Model model) {
		return "/homeAD/QLThongKe2";
	}
	@RequestMapping("/thuongHieu")
	public String thuongHieu(Model model) {
		return "/homeAD/quanLyThuongHieu";
	}
	
	@RequestMapping("/phanLoai")
	public String phanLoai(Model model) {
		return "/homeAD/quanLyLoaiSP";
	}
	
	@RequestMapping("/khachHang")
	public String khachHang(Model model) {
		return "/homeAD/quanLyKhachHang";
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
