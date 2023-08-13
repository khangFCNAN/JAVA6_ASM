package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.HoaDon;
import com.poly.entity.Hoadonchitiet;
import com.poly.entity.SanPham;

public interface DonHangService {
	public List<HoaDon> findAll();

	public HoaDon findById(Integer idHd);

	public HoaDon create(HoaDon donhang);
	
	public Hoadonchitiet createHDCT(Hoadonchitiet hdct);
	
	public HoaDon create1(JsonNode orderData);
	
	public HoaDon update(HoaDon donhang);

	public List<HoaDon> findAllByTaiKhoan(String taiKhoan);

	List<SanPham> getChiTietDonHang(Integer idHd);
	
}
