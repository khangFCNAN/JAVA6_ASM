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
	@Autowired
	KhachHangService khsv;
	 
	@Override
	public List<KhachHang> findAll() {
		return khdao.findAll();
	}

	@Override
	public KhachHang findTkAndMk(String taiKhoan, String matKhau) {
		return khdao.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	}

	@Override
	public KhachHang findByUsername(KhachHang taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public KhachHang create(KhachHang khachHang) {
		return khdao.save(khachHang);
	}
	

    @Override
    public KhachHang findByTaiKhoan(String taiKhoan) {
        return khdao.findByTaiKhoan(taiKhoan);
    }
	
	public List<KhachHang> getAdministrators() {
		return khdao.getAdministrators();
	}

	@Override
	public KhachHang findById(String taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
