package com.poly.service;

import java.util.List;

import com.poly.entity.KhachHang;

public interface KhachHangService {
	
	public List<KhachHang> findAll() ;
	public KhachHang findTkAndMk(String taiKhoan, String matkhau);
}
