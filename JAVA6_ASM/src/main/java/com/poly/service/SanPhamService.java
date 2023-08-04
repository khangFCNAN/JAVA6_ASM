package com.poly.service;

import java.util.List;

import com.poly.entity.SanPham;

public interface SanPhamService {
public List<SanPham> findAll() ;
	
	public SanPham findById(Integer idSp) ;

//	public List<SanPham> findByCategoryId(String cid);

	public SanPham create(SanPham SanPham) ;

	public SanPham update(SanPham SanPham) ;

	public void delete(Integer id);
}