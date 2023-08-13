package com.poly.service;

import java.util.List;

import com.poly.entity.KhachHang;

public interface KhachHangService {
	
	public List<KhachHang> findAll() ;
	public KhachHang findByUsername(KhachHang taiKhoan);
	public KhachHang findTkAndMk(String taiKhoan, String matkhau);
	public KhachHang create(KhachHang khachHang);
	public KhachHang findById(String taiKhoan);
	//vinh them
	KhachHang findByTaiKhoan(String taiKhoan);
	// AK them
//	boolean doiMatKhau(String taiKhoan, String matKhau, String matKhauMoi);
	
}
