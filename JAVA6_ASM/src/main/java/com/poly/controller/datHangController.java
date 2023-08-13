package com.poly.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;


@Controller
public class datHangController {
	DonHangService orderService;       
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/giohang")
	public String giohang(Model model) {
		return "/home/testGioHang";
	}
	
	@GetMapping("/giohang/dathang")
	public String checkout( HoaDon hoadon, Model model) {
//		HttpSession session = request.getSession();
//		// Lấy tên tài khoản từ HttpSession
//		String taiKhoan = (String) session.getAttribute("taiKhoan");
//		System.out.println(taiKhoan);
//		// Gửi tên tài khoản đến view template
//		model.addAttribute("taiKhoan", taiKhoan);
		return "home/dathang";
	}
	
	@RequestMapping("/giohang/lichsu")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("lichsus", orderService.findAllByTaiKhoan(username));
		return "home/lichsu";
	}
	
	@RequestMapping("/dathang/lichsu/{idHd}")
	public String detail(@PathVariable("idHd") Integer idHd, Model model) {
		model.addAttribute("lichsu", orderService.findById(idHd));
		return "home/lichsu";
	}
}
    