package com.poly.service;

import java.util.List;

import com.poly.entity.Loaisanpham;

public interface LoaiSP_Service {
	public List<Loaisanpham> findAll() ;
	
	public Loaisanpham findById(Integer idLoai) ;
	
	public Loaisanpham create(Loaisanpham Loaisanpham) ;
	
	public Loaisanpham update(Loaisanpham Loaisanpham) ;
	
	public void delete(Integer idLoai);
}
