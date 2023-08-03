package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;


@CrossOrigin("*")
@Controller
@RequestMapping("indexAD")
public class SanPhamWebController {
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @Autowired
	 private SanphamDAO spdao;
	 
	 @GetMapping("/quanLySanPham")
	    public String showProductList(Model model) {
	        ResponseEntity<SanPham[]> response = restTemplate.getForEntity("http://localhost:8080/list/sanpham", SanPham[].class);
	        SanPham[] sanphams = response.getBody();
	        model.addAttribute("sanphams", sanphams);
	        return "homeAD/quanLySanPham";
	  }
	 
	
	 
}
