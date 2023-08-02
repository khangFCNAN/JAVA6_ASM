package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Hoadonchitiet;


public interface HoadonchitietDAO extends JpaRepository<Hoadonchitiet, Integer> {
//	@Modifying
//	@Query("UPDATE HoaDon o SET o.trangThai = false WHERE o.idHd = :idHd")
//	void updateTrangThaiHoaDon(@Param("idHd") Integer idHd);
	public List<Hoadonchitiet> findAllByIdHd(int idHd);
}