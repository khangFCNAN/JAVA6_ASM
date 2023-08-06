package com.poly.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quanLySanPham")
public class SanPhamWebController {
	 
	 @Autowired	 
	 @GetMapping("/list")
	    public String listSanPham(Model model) throws IllegalStateException, IOException  {
	       return "/homeAD/quanLySanPham";
	 }
	 

}
