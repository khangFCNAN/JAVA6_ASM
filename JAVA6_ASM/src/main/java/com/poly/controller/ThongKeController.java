package com.poly.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.SanPham;
import com.poly.interfaces.HoaDonRepository;
import com.poly.interfaces.SanPhamRepository;


@Controller
@RequestMapping("/thongke")
public class ThongKeController {
	@Autowired
	HoaDonRepository hoaDonRepository;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@GetMapping("/form")
	public String getThongKe(Model model) {

		Date endDate = new Date();
		Double tongDoanhThu = hoaDonRepository.getTongDoanhThu(endDate);
		Integer soSanPhamDaBan = hoaDonRepository.getSoSanPhamDaBan(endDate);
		Integer soDonHang = hoaDonRepository.getSoDonHang(endDate);

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	    numberFormat.setRoundingMode(RoundingMode.HALF_UP);
	    numberFormat.setMaximumFractionDigits(0);
	    String tongDoanhThuVND = numberFormat.format(tongDoanhThu);

		model.addAttribute("tongDoanhThu", tongDoanhThuVND);
		model.addAttribute("soSanPhamDaBan", soSanPhamDaBan);
		model.addAttribute("soDonHang", soDonHang);
		
		//ban chay
		List<SanPham> sanPhamBanChayNhat = sanPhamRepository.getSanPhamBanChayNhat();
		Double tongGiaTri = 0.0;
		for (SanPham sanPham : sanPhamBanChayNhat) {
		    tongGiaTri += sanPham.getGiaSp();
		}
		model.addAttribute("sanPhamBanChayNhat", sanPhamBanChayNhat);
		model.addAttribute("tongGiaTri", tongGiaTri);
		
		return "/homeAD/QLThongKe";
	}

	@GetMapping("/form2")
	public String quanLyThongKe2(Model model) {
		return "/homeAD/QLThongKe2";
	}
}
