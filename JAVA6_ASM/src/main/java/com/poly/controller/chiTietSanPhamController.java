package com.poly.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;



@CrossOrigin("*")
@Controller
@RequestMapping("chitietsanpham")
public class chiTietSanPhamController {

	@Autowired
	SanPhamService sanphamService;

	@RequestMapping("sanpham/{idSp}")

	public String chitietsanpham(Model model, @PathVariable("idSp") Integer idSp) {
		SanPham sanpham = sanphamService.findById(idSp);
		model.addAttribute("sanpham", sanpham);
		return "home/chitietsanpham";
	}
}
