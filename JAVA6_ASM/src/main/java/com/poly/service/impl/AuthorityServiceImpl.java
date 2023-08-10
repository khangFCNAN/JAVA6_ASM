package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AuthorityDAO;
import com.poly.dao.KhachhangDAO;
import com.poly.entity.Authorities;
import com.poly.entity.KhachHang;
import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDAO dao;
	@Autowired
	KhachhangDAO khdao;

	@Override
	public List<Authorities> findAuthoritiesOfAdministrators() {
		List<KhachHang> accounts = khdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public List<Authorities> findAll() {
		return dao.findAll();
	}

	@Override
	public Authorities create(Authorities auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
