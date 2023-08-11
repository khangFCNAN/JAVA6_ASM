package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Authority;
import com.poly.entity.KhachHang;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.taiKhoan IN ?1")
	List<Authority> authoritiesOf(List<KhachHang> taiKhoans);
}
