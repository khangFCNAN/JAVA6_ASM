package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@Controller
@RequestMapping("/quanLyDonHang")
public class DonHangWebController {

	@Autowired
	DonHangService dohangService;

	@GetMapping("/list")
	 public String List(Model model) {
			 return "homeAD/quanLyDonHang";
	 }
	
//	@GetMapping("chiTietDonHang/{idHd}")
//	public ResponseEntity<HoaDon> getDonHangById(@PathVariable("idHd") Integer idHd) {
//	    HoaDon donHang = dohangService.findById(idHd);
//	    if (donHang == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//	    return ResponseEntity.ok(donHang);
//	}
	
	@GetMapping("chiTietDonHang/{idHd}")
	public String detail(Model model, @PathVariable("idHd") Integer idHd) {
		return "/quanlyctdonhang/list";
	}
}