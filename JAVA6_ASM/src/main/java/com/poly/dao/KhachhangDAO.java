package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.KhachHang;


public interface KhachhangDAO extends JpaRepository<KhachHang, String> {

	Page<KhachHang> findAllByhoTenLike(String keywords, Pageable pageable);

	Page<KhachHang> findAllBytaiKhoanLike(String keywords, Pageable pageable);

	KhachHang findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);

	KhachHang findByTaiKhoan(String taiKhoan);
	
	KhachHang findBymaXacNhan(String maXacNhan);
	KhachHang findByEmail(String email);

	@Query("SELECT k FROM KhachHang k WHERE k.trangThai = true")
	List<KhachHang> findActiveCustomers();

	@Query("SELECT k FROM KhachHang k WHERE k.trangThai = false")
	List<KhachHang> findUnActiveCustomers();

	@Query("SELECT k FROM KhachHang k WHERE k.admin = true")
	List<KhachHang> findAdminCustomers();

	@Query("SELECT k FROM KhachHang k WHERE k.admin = false")
	List<KhachHang> findUnAdminCustomers();

	@Query("SELECT DISTINCT ar.taiKhoan FROM Authority ar WHERE ar.role.id IN('GD','NV')")
	List<KhachHang> getAdministrators();
	
//	 @Query("SELECT COUNT(u) > 0 FROM KhachHang u WHERE u.taiKhoan = ?1")
//	  boolean existsByTaiKhoan(String taiKhoan);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM KhachHang u WHERE u.taiKhoan = ?1")
	boolean existsByTaiKhoan(String taiKhoan);
	    
//	    @Query("SELECT COUNT(u) > 0 FROM KhachHang u WHERE u.email = ?1")
//	    boolean existsByEmail(String email);
	
	@Query(value = "SELECT COUNT(*) > 0 FROM KhachHang u WHERE u.email = ?1", nativeQuery = true)
	boolean existsByEmail(String email);

}
