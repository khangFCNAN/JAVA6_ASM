package com.poly.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;

@Controller
@RequestMapping("/quanLySanPham")
public class SanPhamWebController {
	
	@Autowired
	 private SanPhamService spservice;
	 
	//An Khang làm
	 @GetMapping("/list")
	    public String listSanPham(Model model) {
	       List<SanPham> listSp = spservice.findAll();
	       model.addAttribute("sanphams", listSp);
	       return "homeAD/quanLySanPham";
	  }
}
