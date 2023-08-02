package com.poly.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entities.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
//	// theo ngay
	@Query("SELECT SUM(h.tongTien) FROM HoaDon h WHERE h.NgayTao = :NgayTao")
	Double getTongDoanhThuByNgayMua(@Param("NgayTao") Date ngayMua);

	// theo thang
	@Query("SELECT SUM(h.tongTien) FROM HoaDon h WHERE MONTH(h.NgayTao) = :thang AND YEAR(h.NgayTao) = :nam")
	Double getTongDoanhThuByThangMua(@Param("thang") Integer thang, @Param("nam") Integer nam);

	// theo quy
	@Query("SELECT SUM(h.tongTien) FROM HoaDon h WHERE h.NgayTao BETWEEN :ngayBatDau AND :ngayKetThuc")
	Double getTongDoanhThuByKhoangThoiGian(@Param("ngayBatDau") Date ngayBatDau,
			@Param("ngayKetThuc") Date ngayKetThuc);

	// thong ke doanh thu theo loai sp
	@Query("SELECT lsp.tenLoai, SUM(cthd.soLuong * cthd.gia) " + "FROM Hoadonchitiet cthd "
			+ "JOIN cthd.sanpham sp " + "JOIN sp.loaisanpham lsp " + "GROUP BY lsp.tenLoai "
			+ "ORDER BY SUM(cthd.soLuong * cthd.gia) DESC")
	List<Object[]> getDoanhThuTheoLoaiSanPham();
//
	// Tính tổng doanh thu từ trước đến nay
	@Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE hd.NgayTao <= :endDate")
	Double getTongDoanhThu(@Param("endDate") Date endDate);
////
	// Tính số sản phẩm đã bán từ trước đến nay
	@Query("SELECT SUM(cthd.soLuong) FROM Hoadonchitiet cthd WHERE cthd.hoadon.NgayTao <= :endDate")
	Integer getSoSanPhamDaBan(@Param("endDate") Date endDate);
//
	// Tính số đơn hàng từ trước đến nay
	@Query("SELECT COUNT(hd.idHd) FROM HoaDon hd WHERE hd.NgayTao <= :endDate")
	Integer getSoDonHang(@Param("endDate") Date endDate);

	// Tính số hóa đơn đã xác nhận từ trước đến nay
	@Query("SELECT COUNT(hd.idHd) FROM HoaDon hd WHERE hd.NgayTao <= :endDate AND hd.trangThai = 'Đã xác nhận'")
	Integer getSoHoaDonDaXacNhan(@Param("endDate") Date endDate);
}
