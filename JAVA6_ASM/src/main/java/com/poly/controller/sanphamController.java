package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.SanphamDAO;
import com.poly.entities.SanPham;

@CrossOrigin("*")
@RestController
public class sanphamController {
	@Autowired
	SanphamDAO spdao;
	
	@GetMapping("/sanpham/list")
	
	public List<SanPham> getAll(Model model){
		
		return spdao.findAll();
		
	}
	
}
