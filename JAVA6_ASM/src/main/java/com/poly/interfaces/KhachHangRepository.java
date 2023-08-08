package com.poly.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    KhachHang findByTaiKhoan(String taiKhoan);
}