package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.poly.entity.HoaDon;

@CrossOrigin("*")
@Controller
@RequestMapping("indexAD")
public class donhangWebController {
	 @Autowired
	 private RestTemplate restTemplate;
	 @GetMapping("/quanLyDonHang")
	 public String showProductList(Model model) {
		 ResponseEntity<HoaDon[]> response = restTemplate.getForEntity("http://localhost:8080/list/hoadon", HoaDon[].class);
		 HoaDon[] hoadons = response.getBody();
		 model.addAttribute("hoadons",hoadons);
		 return "homeAD/quanLyDonHang";
	 }
}
