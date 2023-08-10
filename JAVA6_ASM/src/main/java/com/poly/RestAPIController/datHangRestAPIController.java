package com.poly.RestAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	public String createDonHang(Model model, HoaDon hoadon) {
		return "/home/lichsu";
	}
	/*
	 * @PostMapping public HoaDon create(@RequestBody HoaDon hoadon) { double
	 * totalAmount = 0.0;
	 * 
	 * for (Hoadonchitiet hdct : hoadon.getHoadonchitiet()) { double quantity =
	 * hdct.getSoLuong(); double price = hdct.getSanPham().getGiaSp(); double
	 * subtotal = quantity * price;
	 * 
	 * totalAmount += subtotal; }
	 * 
	 * hoadon.setTongTien(totalAmount);
	 * 
	 * return orderService.create(hoadon); }
	 */
}