package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.LoaiSP_Service;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@Controller
@RequestMapping("index")
public class indexController {
	@Autowired
	private SanPhamService spservice;
	@Autowired
	private LoaiSP_Service loaiSPServiece;

	@GetMapping("form")
	public String index(Model model) {
		// Hiển thị sản phẩm
		List<SanPham> list = spservice.findAll();
		model.addAttribute("items", list);
		// Hiển thị tên tiêu đề
		model.addAttribute("title", "Trang chủ");
		// Hiển thị loại sản phẩm trên thanh NAVBAR
		List<Loaisanpham> listLoai = loaiSPServiece.findAll();
		model.addAttribute("loaiSP", listLoai);
		return "home/index";
	}

	@RequestMapping("/chitietsanpham")
	public String chitietsanpham(Model model) {
		return "home/chitietsanpham";
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
