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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon update(HoaDon donhang) {
		// TODO Auto-generated method stub
		return null;
	}

}