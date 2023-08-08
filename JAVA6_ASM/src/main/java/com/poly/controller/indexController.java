package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.poly.entity.SanPham;

@CrossOrigin("*")
@Controller
@RequestMapping("/index")
public class indexController {
	@Autowired
	 private RestTemplate restTemplate;
	
	@GetMapping("/form")
	public String index(Model model) {
		//Hiển thị sản phẩm
		ResponseEntity<SanPham[]> response = restTemplate.getForEntity("http://localhost:8080/list/sanpham", SanPham[].class);
        SanPham[] sanphams = response.getBody();
        model.addAttribute("sanphams", sanphams);
		return "home/index";
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
		return "home/giohang";
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
