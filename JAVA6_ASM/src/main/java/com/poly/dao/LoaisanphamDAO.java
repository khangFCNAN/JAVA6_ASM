package com.poly.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entities.Loaisanpham;

public interface LoaisanphamDAO extends JpaRepository<Loaisanpham, Integer> {
	Page<Loaisanpham> findAllBytenLoaiLike(String keywords, Pageable pageable);
}
