package com.poly.RestAPIController;

import java.util.List;
import java.util.Optional;

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

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sanpham")
public class SanPhamRestAPIController {
	
	@Autowired
	SanPhamService sanphamsvc;
	
	@GetMapping("/list")
	public List<SanPham> getAllSanPhams(Model model){
		return sanphamsvc.findAll();
	}
	
	@GetMapping("/edit/{idSp}")
	public SanPham getOne(@PathVariable("idSp") Integer idSp) {
		return sanphamsvc.findById(idSp);
	}
	
	@PostMapping("/create")
	public SanPham create(@RequestBody SanPham sanpham) {
		return sanphamsvc.create(sanpham);
	}
	
	@PutMapping("/update/{idSp}")
	public SanPham update(@PathVariable("idSp") Integer idSp, @RequestBody SanPham sanpham) {
		return sanphamsvc.update(sanpham);
	}
	
	@DeleteMapping("/delete/{idSp}")
	public void delete(@PathVariable("idSp") Integer idSp) {
		sanphamsvc.delete(idSp);
	}
	
}
