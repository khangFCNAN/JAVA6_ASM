package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ThuonghieuDAO;
import com.poly.entity.Thuonghieu;
import com.poly.service.ThuongHieuService;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService{
	@Autowired
	ThuonghieuDAO thdao;

	@Override
	public List<Thuonghieu> findAll() {
		return thdao.findAll();
	}

	@Override
	public Thuonghieu findById(Integer idTh) {
		return thdao.findById(idTh).get();
	}

	@Override
	public Thuonghieu create(Thuonghieu thuonghieu) {
		return thdao.save(thuonghieu);
	}

	@Override
	public Thuonghieu update(Thuonghieu thuonghieu) {
		return thdao.save(thuonghieu);

	}

	@Override
	public void delete(Integer idTh) {
		thdao.deleteById(idTh);
	}
}
