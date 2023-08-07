package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.LoaiSanPhamService;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/loaisanpham")
public class LoaiSanPhamRestAPIController {
	@Autowired
	LoaiSanPhamService loaispsvc;
	
	@GetMapping("{idLoai}")
	public Loaisanpham getOne2(@PathVariable("idLoai") Integer idLoai) {
		return loaispsvc.findById(idLoai);
	}
	
	@GetMapping("/list")
	public List<Loaisanpham> getAllLoaiSanPhams(Model model){
		return loaispsvc.findAll();
	}
	
	@GetMapping("/edit/{idLoai}")
	public Loaisanpham getOne(@PathVariable("idLoai") Integer idLoai) {
		return loaispsvc.findById(idLoai);
	}
	
	@PostMapping("/create")
	public Loaisanpham create(@RequestBody Loaisanpham loaisanpham) {
		return loaispsvc.create(loaisanpham);
		
	}
	
	@PutMapping("/update/{idLoai}")
	public Loaisanpham update(@PathVariable("idLoai") Integer idLoai, @RequestBody Loaisanpham loaisanpham) {
		return loaispsvc.update(loaisanpham);
	}
	
	@DeleteMapping("/delete/{idLoai}")
	public void delete(@PathVariable("idLoai") Integer idLoai) {
		loaispsvc.delete(idLoai);
	}
	
}
