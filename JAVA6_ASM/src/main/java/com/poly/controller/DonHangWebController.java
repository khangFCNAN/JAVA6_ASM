package com.poly.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@Controller
@RequestMapping("/quanLyDonHang")
public class DonHangWebController {

	@Autowired
	DonHangService donhangService;

	@GetMapping("/list")
	public String List(Model model) {
		return "homeAD/quanLyDonHang";
	}
	
	@RequestMapping("/create")
	public String createDonHang(Model model, HoaDon hoadon) {
		return "/home/lichsu";
	}

	@GetMapping("chiTietDonHang/{idHd}")
	public String detail(Model model, @PathVariable("idHd") Integer idHd) {
		return "redirect:/quanLyDonHang/list";
	}
	
	
	
	@RequestMapping("/capNhatTrangThai")
	public String capNhatTrangThai(Model model) {
		return "homeAD/capNhatTrangThai";
	}
	
	@ModelAttribute("trangThai")
	public Map<String, String> getCountries(){
		Map<String, String> map = new HashMap<>();
		map.put("CD", "Chưa duyệt");
		map.put("CVC", "Chờ vận chuyển");
		map.put("CLH", "Chờ lấy hàng");
		map.put("DLH", "Đang lấy hàng");
		map.put("DVC", "Đang vận chuyển");
		return map;
	}
}