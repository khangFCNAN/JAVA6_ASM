package com.poly.RestAPIController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.entity.HoaDon;
import com.poly.entity.Hoadonchitiet;
import com.poly.service.DonHangService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class datHangRestAPIController {
	@Autowired
	DonHangService orderService;
	@Autowired
	private HttpServletRequest request;
	
	private final ObjectMapper objectMapper;

    public datHangRestAPIController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

	@PostMapping("/createHoaDon")
	public HoaDon create(@RequestBody HoaDon hoadon) {

		HttpSession session = request.getSession();
		String taiKhoan = (String) session.getAttribute("taiKhoan");
		
		hoadon.setTaiKhoan(taiKhoan);

		System.out.println(hoadon);
		return orderService.create(hoadon);
	}
	
//	@PostMapping("/createHDCT")
//	public Hoadonchitiet createHDCT(HoaDon hoadon, Hoadonchitiet hdct) {
//		hdct = new Hoadonchitiet();
//		hdct.set
//		return orderService.create(hoadon);
//	}
	
	@GetMapping("/session")
    public ResponseEntity<JsonNode> getSessionData(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String taiKhoan = (String) session.getAttribute("taiKhoan");

        // Tạo đối tượng JsonNode chứa giá trị tài khoản
        JsonNode json = objectMapper.createObjectNode().put("taiKhoan", taiKhoan);

        // Trả về đối tượng JsonNode dưới dạng phản hồi JSON
        return ResponseEntity.ok(json);
    }
}