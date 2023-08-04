package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@Controller
@RequestMapping("quanLySanPham")
public class SanPhamWebController {
	 
	 @Autowired
	 private SanPhamService spservice;
	 
	 @GetMapping("/list")
	    public String listSanPham(Model model) {
	       List<SanPham> listSp = spservice.findAll();
	       model.addAttribute("sanphams", listSp);
	        return "homeAD/quanLySanPham";
	  }
	 
	 @GetMapping("edit/{idSp}")
	 public String editSanPham(@PathVariable("idSp") Integer idSp, Model model, SanPham spItem) {
		 spItem = spservice.findById(idSp);
		 model.addAttribute("sanpham", spItem);
		 System.out.println(spItem);
		 return "homeAD/quanLySanPham";
	 }
	 
}
