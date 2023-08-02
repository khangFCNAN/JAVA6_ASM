package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.poly.entity.Chitietgiohang;
import com.poly.entity.GioHang;
import com.poly.entity.SanPham;


@EnableJpaRepositories
public interface ChitietgiohangDAO extends JpaRepository<Chitietgiohang, Integer> {

	Chitietgiohang findByGiohangAndSanpham(GioHang gioHang, SanPham sanPham);
	
//	List<Chitietgiohang> findByKhachHang(String khachhang);

	List<Chitietgiohang> findByGiohang(GioHang gioHang);

}
