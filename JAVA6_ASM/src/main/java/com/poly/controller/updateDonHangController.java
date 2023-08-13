package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin("*")
@Controller
@RequestMapping("/capNhatDonHang")

public class updateDonHangController {
	
	
	
	@GetMapping("/list")
	public String List(Model model) {
		return "homeAD/capNhatTrangThai";
	}
	
	@GetMapping("update/{idHd}")
	public String update(Model model, @PathVariable("idHd") Integer idHd) {
		return "redirect:/capNhatDonHang/list";
	}
}
