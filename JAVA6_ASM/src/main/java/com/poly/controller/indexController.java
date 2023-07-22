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
		return "home/sanpham";
	}
	@RequestMapping("/chitietsanpham")
	public String chitietsanpham(Model model) {
		return "/chitietsanpham";
	}
	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "/home/giohang";
	}
	@RequestMapping("/dathang")
	public String dathang(Model model) {
		return "/home/dathang";
	}
	
	@RequestMapping("/donhang")
	public String donhang(Model model) {
		return "/home/donhang";
	}
	
	@RequestMapping("/DangNhap")
	public String DangNhap(Model model) {
		return "/home/DangNhap";
	}
	
	@RequestMapping("/DangKy")
	public String DangKy(Model model) {
		return "/home/DangKy";
	}
	
	@RequestMapping("/DoiMatKhau")
	public String DoiMatKhau(Model model) {
		return "/home/DoiMatKhau";
	}
	
	@RequestMapping("/CapNhatTaiKhoan")
	public String CapNhatTaiKhoan(Model model) {
		return "/home/CapNhatTaiKhoan";
	}
	@RequestMapping("/QuenMatKhau")
	public String QuenMatKhau(Model model) {
		return "/home/QuenMatKhau";
	}
}
