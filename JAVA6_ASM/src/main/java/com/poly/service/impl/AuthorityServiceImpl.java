package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AuthorityDAO;
import com.poly.dao.KhachhangDAO;
import com.poly.entity.Authority;
import com.poly.entity.KhachHang;
import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDAO dao;
	@Autowired
	KhachhangDAO khdao;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<KhachHang> accounts = khdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
