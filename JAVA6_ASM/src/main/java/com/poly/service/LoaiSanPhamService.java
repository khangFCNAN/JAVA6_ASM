package com.poly.service;

import java.util.List;

import com.poly.entity.Loaisanpham;

public interface LoaiSanPhamService {
	public List<Loaisanpham> findAll();

	public Loaisanpham findById(Integer idLoai);

	public Loaisanpham create(Loaisanpham loaisanpham);

	public Loaisanpham update(Loaisanpham loaisanpham);

	public void delete(Integer idLoai);
}
