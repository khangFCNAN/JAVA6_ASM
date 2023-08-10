package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.HoaDon;
import com.poly.entity.SanPham;

public interface HoadonDAO extends JpaRepository<HoaDon, Integer> {

	@Query("SELECT o FROM HoaDon o WHERE  o.taiKhoan = ?1")

	Page<HoaDon> findAllBytaiKhoanLike(String keywords, Pageable pageable);

	@Query(value = "SELECT sp FROM SanPham sp JOIN sp.hoadonchitiet hdct WHERE hdct.hoadon.idHd = :idHd")
	List<SanPham> getSanPhamByHoaDonId(@Param("idHd") Integer idHd);

	@Query("UPDATE HoaDon SET trangThai = :trangThai WHERE idHd = :idHd")
	Page<HoaDon> findAllBytrangThaiLike(String trangThai, Pageable pageable);

	@Query("SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai")
	List<HoaDon> findByTrangThai(@Param("trangThai") String trangThai);

	@Query("SELECT h FROM HoaDon h WHERE h.taiKhoan = :taiKhoan")
	List<HoaDon> findByTaiKhoan(@Param("taiKhoan") String taiKhoan);

	@Query("SELECT h FROM HoaDon h WHERE h.khachhang.taiKhoan = :taiKhoan AND h.trangThai = :trangThai")
	List<HoaDon> findByTaiKhoanAndTrangThai(@Param("taiKhoan") String taiKhoan, @Param("trangThai") String trangThai);

}