package com.poly.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;


@Controller
@RequestMapping("/quanLySanPham")
public class SanPhamWebController {
	
	 @Autowired
	 private SanPhamService spservice;
	 
	 @GetMapping("/list")
	    public String listSanPham(Model model) throws IllegalStateException, IOException  {
	       List<SanPham> listSp = spservice.findAll();
	       model.addAttribute("sanphams", listSp);
	       model.addAttribute("sanpham", new SanPham());
	       return "/homeAD/quanLySanPham";
	 }
	 
	
	 @GetMapping("/edit/{idSp}")
	 public String editSanPham( Model model, @PathVariable("idSp") Integer idSp) throws IllegalStateException, IOException {
	     SanPham sanpham = spservice.findById(idSp);
	     List<SanPham> listSp = spservice.findAll();
	       model.addAttribute("sanphams", listSp);
	     model.addAttribute("sanpham", sanpham);
	     return "/homeAD/quanLySanPham"; // Đảm bảo tên template là chính xác
	 }
}
