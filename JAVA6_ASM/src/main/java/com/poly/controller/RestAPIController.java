package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;

@CrossOrigin("*")
@RestController
@RequestMapping("/list")
public class RestAPIController {
	
	@Autowired
	public SanphamDAO spdao;
	
	@GetMapping("/sanpham")
	public List<SanPham> getAllSanPhams(Model model){
		return spdao.findAll();
	}
	
}
