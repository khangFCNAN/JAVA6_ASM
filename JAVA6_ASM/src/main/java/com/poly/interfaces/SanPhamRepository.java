package com.poly.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
	@Query("SELECT sp, SUM(cthd.soLuong) AS tongSoLuong, SUM(cthd.soLuong * sp.giaSp) AS giaTriBan "
			+ "FROM SanPham sp " + "JOIN sp.hoadonchitiet cthd "
			+ "GROUP BY sp.idSp, cthd.soLuong,sp.giaSp,sp.loaisanpham,sp.tenSp,sp.anhSp,sp.moTa,sp.baoHanh,sp.ngayTao,sp.soLuong,sp.thuonghieu " + "ORDER BY SUM(cthd.soLuong) DESC")
	List<Object[]> getSanPhamBanChayNhat();

}
