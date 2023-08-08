package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.KhachhangDAO;
import com.poly.entity.KhachHang;
import com.poly.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired
	KhachhangDAO khdao;

	@Override
	public List<KhachHang> findAll() {
		return khdao.findAll();
	}

	@Override
	public KhachHang findTkAndMk(String taiKhoan, String matKhau) {
		return khdao.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	}

}
