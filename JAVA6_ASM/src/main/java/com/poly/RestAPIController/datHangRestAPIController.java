package com.poly.RestAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class datHangRestAPIController {
	@Autowired
	DonHangService orderService;

	@PostMapping
	public HoaDon create(@RequestBody HoaDon hoadon) {
		System.out.println(hoadon);
		return orderService.create(hoadon);
	}
}