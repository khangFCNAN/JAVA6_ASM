package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.SanphamDAO;
import com.poly.entities.SanPham;
@CrossOrigin("*")
@RestController
public class quanLySanPham {

	@Autowired
	SanphamDAO sanphamdao;

	@GetMapping("form/list/")
	public List<SanPham> getAllSanPhams(Model model){
		return sanphamdao.findAll();
	}
}
