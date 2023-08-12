package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.dao.HoadonDAO;
import com.poly.dao.HoadonchitietDAO;
import com.poly.entity.HoaDon;
import com.poly.entity.Hoadonchitiet;
import com.poly.entity.SanPham;
import com.poly.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	HoadonDAO hdDao;
	
	@Autowired
	HoadonchitietDAO hdctDao;

	@Override
	public List<HoaDon> findAll() {
		return hdDao.findAll();
	}

	@Override
	public HoaDon findById(Integer idHd) {
		return hdDao.findById(idHd).get();
	}

	@Override
	public HoaDon create(HoaDon hoadon) {
		return hdDao.save(hoadon);
	}

	@Override
	public HoaDon update(HoaDon hoadon) {
		return hdDao.save(hoadon);
	}

	@Override
	public List<HoaDon> findAllByTaiKhoan(String taiKhoan) {
		return hdDao.findByTaiKhoan(taiKhoan);
	}

	@Override
	public List<SanPham> getChiTietDonHang(Integer idHd) {
	    return hdDao.getSanPhamByHoaDonId(idHd);
	}

	@Override
	public HoaDon create1(JsonNode orderData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hoadonchitiet createHDCT(Hoadonchitiet hdct) {
		return hdctDao.save(hdct);
	}


}
