package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@Controller
@RequestMapping("/capNhatDonHang")

public class updateDonHangController {
	@RequestMapping("/CapNhatTrangThaiDonHang")
	public String updateStatus(@RequestParam("trangThai") String trangThai) {
	    // Xử lý cập nhật trạng thái dựa trên giá trị newStatus
	    // ...
	    return "redirect:/thong-tin-don-hang"; // Chuyển hướng sau khi cập nhật thành công
	}
}
