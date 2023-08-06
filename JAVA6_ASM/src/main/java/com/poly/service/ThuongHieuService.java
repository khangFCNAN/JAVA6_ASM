package com.poly.service;

import java.util.List;

import com.poly.entity.Thuonghieu;

public interface ThuongHieuService {

	public List<Thuonghieu> findAll() ;
	
	public Thuonghieu findById(Integer idTh) ;

	public Thuonghieu create(Thuonghieu thuonghieu) ;

	public Thuonghieu update(Thuonghieu thuonghieu) ;

	public void delete(Integer idTh);
}
