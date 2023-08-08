package com.poly.service;

import java.util.List;

import com.poly.entity.HoaDon;

public interface DonHangService {
	public List<HoaDon> findAll();

	public HoaDon findById(Integer idHd);

	public HoaDon create(HoaDon donhang);
	
	public HoaDon update(HoaDon donhang);

}
