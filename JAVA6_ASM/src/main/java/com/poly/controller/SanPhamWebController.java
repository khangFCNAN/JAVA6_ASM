package com.poly.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;

@Controller
@RequestMapping("/quanLySanPham")
public class SanPhamWebController {
	
	@Autowired
	 private SanPhamService spservice;
	 
	 @RequestMapping("/list")
	    public String listSanPham(Model model) {
	       List<SanPham> listSp = spservice.findAll();
	       model.addAttribute("sanphams", listSp);
	       return "homeAD/quanLySanPham";
	  }
	
	 @RequestMapping("/delete/{idSp}")
	 public String deleteSanPham(Model model) {
		 return "redirect:/quanLySanPham/list";
	 }
	 
	 @RequestMapping("/create")
	 public String createSanPham(Model model, SanPham sanpham) {
		 return "redirect:/quanLySanPham/list";
	 }
	 
	 @RequestMapping("/update/{idSp}")
	 public String updateSanPham(Model model, SanPham sanpham) {
		 return "redirect:/quanLySanPham/list";
	 }
}
