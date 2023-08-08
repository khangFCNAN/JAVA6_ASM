package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.KhachhangDAO;
import com.poly.entity.KhachHang;
import com.poly.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachhangDAO khachHangDAO;

    @Override
    public KhachHang findByTaiKhoan(String taiKhoan) {
        return khachHangDAO.findByTaiKhoan(taiKhoan);
    }
}
