package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.LoaisanphamDAO;
import com.poly.entity.Loaisanpham;
import com.poly.service.LoaiSP_Service;

@Service
public class LoaiSP_Service_impl implements LoaiSP_Service{
	@Autowired
	LoaisanphamDAO loaiSpDAO;
	
	@Override
	public List<Loaisanpham> findAll() {
		return loaiSpDAO.findAll();
	}

	@Override
	public Loaisanpham findById(Integer idLoai) {
		return loaiSpDAO.findById(idLoai).get();
	}

	@Override
	public Loaisanpham create(Loaisanpham Loaisanpham) {
		return loaiSpDAO.save(Loaisanpham);
	}

	@Override
	public Loaisanpham update(Loaisanpham Loaisanpham) {
		return loaiSpDAO.save(Loaisanpham);
	}

	@Override
	public void delete(Integer idLoai) {
		loaiSpDAO.deleteById(idLoai);
	}
}
