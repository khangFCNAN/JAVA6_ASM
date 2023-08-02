package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.SanphamDAO;
import com.poly.entities.SanPham;

@CrossOrigin("*")
@RestController
@RequestMapping("/sanpham")
public class sanphamController {
	
	@Autowired
	public SanphamDAO spdao;
	
	@GetMapping("/list")
	public List<SanPham> getAll(Model model){
		return spdao.findAll();
	}
}
