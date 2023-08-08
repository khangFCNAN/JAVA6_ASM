package com.poly.RestAPIController;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.HoadonDAO;
import com.poly.entity.HoaDon;
import com.poly.entity.KhachHang;
import com.poly.service.DonHangService;
import com.poly.service.KhachHangService;

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
