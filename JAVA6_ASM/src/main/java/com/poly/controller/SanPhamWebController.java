package com.poly.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;


@Controller
@RequestMapping("/quanLySanPham")
public class SanPhamWebController {
	
	 @GetMapping("/list")
	    public String listSanPham() throws IllegalStateException, IOException  {
	       return "/homeAD/quanLySanPham";
	 }
}
