package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@Controller
@RequestMapping("quanlyctdonhang")
public class chiTietDonHangWebController {

	@Autowired
	DonHangService dohangService;

	@GetMapping("/list")
	 public String List(Model model) {
			 return "homeAD/quanLyChiTietDonhang";
	 }
	
	
	@GetMapping("edit/{idHd}")
	public String detail(Model model, @PathVariable("idHd") Integer idHd) {
		HoaDon hoadon = dohangService.findById(idHd);
		model.addAttribute("hoadon", hoadon);
		return "homeAD/quanLyChiTietDonhang";
	}
}