package com.poly.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quanLyLoaiSp")
public class LoaiWebController {
	@GetMapping("/list")
	public String listSanPham() throws IllegalStateException, IOException {
		return "/homeAD/quanLyLoaiSP";
	}
}
