package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Loaisanpham;
import com.poly.service.LoaiSP_Service;
@CrossOrigin("*")
@Controller
@RequestMapping("doiMK")
public class doiMatKhauController {
	@Autowired
	private LoaiSP_Service loaiSPServiece;
	
	@RequestMapping("/DoiMatKhau")
	public String DoiMatKhau(Model model) {
		model.addAttribute("title", "Đổi mật khẩu");
		// Hiển thị loại sản phẩm trên thanh NAVBAR
		List<Loaisanpham> listLoai = loaiSPServiece.findAll();
		model.addAttribute("loaiSP", listLoai);
		return "/home/DoiMatKhau";
	}
}
