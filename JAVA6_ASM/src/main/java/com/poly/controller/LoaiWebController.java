package com.poly.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Loaisanpham;

@Controller
@RequestMapping("/quanLyLoaiSp")
public class LoaiWebController {
	@GetMapping("/list")
	public String listSanPham() throws IllegalStateException, IOException {
		return "/homeAD/quanLyLoaiSP";
	}
	
	 @RequestMapping("/delete/{idLoai}")
	 public String deleteLoaiSanPham(Model model) {
		 return "redirect:/quanLyLoaiSp/list";
	 }
	 
	 @RequestMapping("/create")
	 public String createLoaiSanPham(Model model, Loaisanpham sanpham) {
		 return "redirect:/quanLyLoaiSp/list";
	 }
	 
	 @RequestMapping("/update/{idLoai}")
	 public String updateLoaiSanPham(Model model, Loaisanpham sanpham) {
		 return "redirect:/quanLyLoaiSp/list";
	 }
}
