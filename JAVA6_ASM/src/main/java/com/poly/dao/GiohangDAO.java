package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entities.GioHang;
import com.poly.entities.KhachHang;

public interface GiohangDAO extends JpaRepository<GioHang, Integer> {

	@Query("SELECT gh FROM GioHang gh WHERE gh.khachhang = :khachhang")
	GioHang findByKhachhang(@Param("khachhang") KhachHang khachhang);

}
