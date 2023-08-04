package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Loaisanpham;
import com.poly.service.LoaiSP_Service;

@CrossOrigin("*")
@RestController
@RequestMapping("/list")
public class LoaiSPRestAPIController {
	@Autowired
	 private LoaiSP_Service loaiSPServiece;
	
	@GetMapping("/loaiSP")
	public List<Loaisanpham> getAllLoaisanphams(){
		return loaiSPServiece.findAll();
	}
	
//	@GetMapping("/edit/{idLoai}")
//	public Loaisanpham getOne(@PathVariable("idLoai") Integer idLoai) {
//		return loaiSPServiece.findById(idLoai);
//	}
}
