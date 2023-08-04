package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@Controller
@RequestMapping("donhang")
public class DonHangWebController {
//	 @Autowired
//	 private RestTemplate restTemplate;
//	 @GetMapping("/quanLyDonHang")
//	 public String showProductList(Model model) {
//		 ResponseEntity<HoaDon[]> response = restTemplate.getForEntity("http://localhost:8080/list/hoadon", HoaDon[].class);
//		 HoaDon[] hoadons = response.getBody();
//		 model.addAttribute("hoadons",hoadons);
//		 return "homeAD/quanLyDonHang";
//	 }
	@Autowired
	DonHangService dohangService;

	@GetMapping("/list")
	 public String List(Model model) {
	List<HoaDon> listHd = dohangService.findAll();
	model.addAttribute("listHd",listHd);
		 return "homeAD/quanLyDonHang";
	 }
		@RequestMapping("chiTietDonHang/{idHd}")
		public String detail(Model model, @PathVariable("idHd") Integer idHd) {
			HoaDon item = dohangService.findById(idHd);
			model.addAttribute("item", item);
			return "product/detail";
		}
}