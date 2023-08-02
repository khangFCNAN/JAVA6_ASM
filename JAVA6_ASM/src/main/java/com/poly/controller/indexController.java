package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sanpham")
public class indexController {
	@Autowired
	private SanphamDAO sanphamdao;
	
	@GetMapping
	public List<SanPham> getSanPhams(){
		return sanphamdao.findAll();
	}
}
