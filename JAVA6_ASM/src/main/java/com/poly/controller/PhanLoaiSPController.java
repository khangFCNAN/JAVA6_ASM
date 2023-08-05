package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Loaisanpham;
import com.poly.entity.SanPham;
import com.poly.service.LoaiSP_Service;
import com.poly.service.SanPhamService;

@CrossOrigin("*")
@Controller
@RequestMapping("PhanLoaiSP")
public class PhanLoaiSPController {
	@Autowired
	 private LoaiSP_Service loaiSPServiece;
	@Autowired
	private SanPhamService spservice;
	
	@RequestMapping("/sanpham")
    public String listSanPham(Model model, @RequestParam("cid") Optional<String> cid) {
		List<SanPham> list;
		if(cid.orElse("").isEmpty()) {
			// Hiển thị sản phẩm
			list = spservice.findAll();
		}else {
			// Lấy danh sách sản phẩm thuộc loại sản phẩm có ID tương ứng với giá trị của "cid"
			list = spservice.findByLoaisanphamId(cid.get());
		}
		// Thêm danh sách sản phẩm vào đối tượng Model với tên "items"
		model.addAttribute("items", list);
		// Hiển thị tên tiêu đề
			model.addAttribute("title", "Danh sách sản phẩm");
		// Hiển thị loại sản phẩm trên thanh NAVBAR
			List<Loaisanpham> listLoai = loaiSPServiece.findAll();
			model.addAttribute("loaiSP", listLoai);
			
        return "home/sanpham";
  }
	
}
