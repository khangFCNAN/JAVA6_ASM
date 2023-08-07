package com.poly.RestAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/lichSu")
public class lichSuRestController {
	@Autowired
	public DonHangService donhangService;

	@GetMapping("/list")
	public List<HoaDon> getAllHoaDons(Model model) {
		return donhangService.findAll();

}
}
