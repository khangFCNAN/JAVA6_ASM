package com.poly.RestAPIController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;

@CrossOrigin("*")
@RestController
@RequestMapping("/list")
public class SanPhamRestAPIController {
	
	@Autowired
	public SanphamDAO spdao;
	
	@GetMapping("/sanpham")
	public List<SanPham> getAllSanPhams(Model model){
		return spdao.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<SanPham> getOne(@PathVariable("idSp") Integer idSp) {
		return spdao.findById(idSp);
	}
}
