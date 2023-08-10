package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Authorities;
import com.poly.entity.KhachHang;

public interface AuthorityDAO extends JpaRepository<Authorities, Integer> {
	@Query("SELECT DISTINCT a FROM Authorities a WHERE a.taiKhoan IN ?1")
	List<Authorities> authoritiesOf(List<KhachHang> taiKhoans);
}
