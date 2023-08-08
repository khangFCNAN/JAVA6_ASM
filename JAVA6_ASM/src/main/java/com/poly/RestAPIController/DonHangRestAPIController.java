package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/donhang")
public class DonHangRestAPIController {

	@Autowired
	public DonHangService donhangService;

	@GetMapping("/list")
	public List<HoaDon> getAllHoaDons(Model model) {
		return donhangService.findAll();

	}
	
	@PostMapping("/create")
	public HoaDon create(@RequestBody HoaDon hoadon) {
		return donhangService.create(hoadon);
	}

	@GetMapping("/edit/{idHd}")
	public HoaDon getOne(@PathVariable("idHd") Integer idHd) {
		return donhangService.findById(idHd);
	}

	@PutMapping("/update")
	public HoaDon update(@PathVariable("idHd") Integer idHd, @RequestBody HoaDon donhang) {
		return donhangService.update(donhang);
	}

}
