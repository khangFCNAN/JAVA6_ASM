package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.LoaisanphamDAO;
import com.poly.entity.Loaisanpham;
import com.poly.service.LoaiSanPhamService;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
	
	@Autowired
	LoaisanphamDAO loaispdao;
	
	@Override
	public List<Loaisanpham> findAll() {
		// TODO Auto-generated method stub
		return loaispdao.findAll();
	}

	@Override
	public Loaisanpham findById(Integer idLoai) {
		// TODO Auto-generated method stub
		return loaispdao.findById(idLoai).get();
	}

	@Override
	public Loaisanpham create(Loaisanpham loaisanpham) {
		// TODO Auto-generated method stub
		return loaispdao.save(loaisanpham);
	}

	@Override
	public Loaisanpham update(Loaisanpham loaisanpham) {
		// TODO Auto-generated method stub
		return loaispdao.save(loaisanpham);
	}

	@Override
	public void delete(Integer idLoai) {
		// TODO Auto-generated method stub
		loaispdao.deleteById(idLoai);
	}

}
