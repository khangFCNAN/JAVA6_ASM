package com.poly.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.KhachHang;


public interface UserRepository extends JpaRepository<KhachHang, String> {
	KhachHang findBymaXacNhan(String maXacNhan);
	KhachHang findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);
    KhachHang findByEmail(String email);
    KhachHang findByTaiKhoan(String taiKhoan);
    
    @Query("SELECT COUNT(u) > 0 FROM KhachHang u WHERE u.taiKhoan = ?1")
    boolean existsByTaiKhoan(String taiKhoan);
    
    @Query("SELECT COUNT(u) > 0 FROM KhachHang u WHERE u.email = ?1")
    boolean existsByEmail(String email);

}
