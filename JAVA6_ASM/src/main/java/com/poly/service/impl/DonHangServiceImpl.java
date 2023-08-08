package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.HoadonDAO;
import com.poly.entity.HoaDon;
import com.poly.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	HoadonDAO hdDao;

	@Override
	public List<HoaDon> findAll() {
		return hdDao.findAll();
	}

	@Override
	public HoaDon findById(Integer idHd) {
		return hdDao.findById(idHd).get();
	}

	@Override
	public HoaDon create(HoaDon hoadon) {
		return hdDao.save(hoadon);
	}

	@Override
	public HoaDon update(HoaDon hoadon) {
		return hdDao.save(hoadon);
	}

}