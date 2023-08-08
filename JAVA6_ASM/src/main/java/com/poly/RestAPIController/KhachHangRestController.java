package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.KhachHang;
import com.poly.entity.SanPham;
import com.poly.service.KhachHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/khachHang")
public class KhachHangRestController {
	
	@Autowired
	KhachHangService khsv;
	
	@GetMapping("/list")
	public List<KhachHang> getAll(Model model) {
		return khsv.findAll();
	}
	@PostMapping("/create")
	public KhachHang create(@RequestBody KhachHang khachhang) {
		return khsv.create(khachhang);
	}

}
