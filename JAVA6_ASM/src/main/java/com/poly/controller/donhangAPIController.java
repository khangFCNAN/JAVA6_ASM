package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.HoadonDAO;
import com.poly.entity.HoaDon;

@CrossOrigin("*")
@RestController
@RequestMapping("/list")
public class donhangAPIController {
@Autowired 
public HoadonDAO hdDao;

@GetMapping("/hoadon")
public List<HoaDon> getAllHoaDons(Model model){
	return hdDao.findAll();
}
}
