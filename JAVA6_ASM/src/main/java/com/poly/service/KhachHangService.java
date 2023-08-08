package com.poly.service;

import com.poly.entity.KhachHang;

public interface KhachHangService {

    KhachHang findByTaiKhoan(String taiKhoan);
}