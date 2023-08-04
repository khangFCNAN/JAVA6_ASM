package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.HoaDon;




public interface DonHangService {
public List<HoaDon> findAll();
public HoaDon findById(Integer idHd);

}
