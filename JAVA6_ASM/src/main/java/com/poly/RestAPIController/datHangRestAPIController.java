package com.poly.RestAPIController;

import java.util.List;

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
import com.poly.entity.HoaDonRequest;
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
	public HoaDon createHD(@RequestBody HoaDonRequest hoaDonRequest) {
		HttpSession session = request.getSession();
		String taiKhoan = (String) session.getAttribute("taiKhoan");
		HoaDon hoadon = new HoaDon();
		hoadon.setTaiKhoan(taiKhoan);
		hoadon.setDiaChi(hoaDonRequest.getHoaDon().getDiaChi());
		hoadon.setGhiChu(hoaDonRequest.getHoaDon().getGhiChu());
		hoadon.setNgayTao(hoaDonRequest.getHoaDon().getNgayTao());
		hoadon.setTongTien(hoaDonRequest.getHoaDon().getTongTien());
		hoadon.setSdt(hoaDonRequest.getHoaDon().getSdt());
		hoadon.setTrangThai(hoaDonRequest.getHoaDon().getTrangThai());
		
		List<Hoadonchitiet> listHdct = hoaDonRequest.getHdct();
		HoaDon hdDaThemVaoCSDL = orderService.create(hoadon);
		
		for (Hoadonchitiet hoadonchitiet : listHdct) {
			hoadonchitiet.setIdHd(hdDaThemVaoCSDL.getIdHd());
			System.out.println(hoadonchitiet);
			orderService.createHDCT(hoadonchitiet);
		}
		return hoadon;
	}
	
	
	
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