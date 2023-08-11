package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.SanphamDAO;
import com.poly.entity.SanPham;
import com.poly.interfaces.SanPhamRepository;
import com.poly.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	SanphamDAO spdao;
	@Autowired
	SanPhamRepository sanPhamRepository;
	
	@Override
    public List<SanPham> findByTenSpContaining(String searchInput) {
        return sanPhamRepository.findByTenSpContaining(searchInput);
    }

	@Override
	public List<SanPham> findAll() {
		return spdao.findAll();
	}

	@Override
	public SanPham findById(Integer idSp) {
		return spdao.findById(idSp).get();
	}

	@Override
	public SanPham create(SanPham sanpham) {
		return spdao.save(sanpham);
	}

	@Override
	public SanPham update(SanPham sanpham) {
		return spdao.save(sanpham);
	}

	@Override
	public void delete(Integer idSp) {
		spdao.deleteById(idSp);
	}
	
	@Override
	public List<SanPham> findByLoaisanphamId(Integer cid) {
		return spdao.findByLoaisanphamId(cid);
	}


}
