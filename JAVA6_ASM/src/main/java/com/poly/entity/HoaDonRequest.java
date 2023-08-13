package com.poly.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonRequest {
	private HoaDon hoaDon;
	private List<Hoadonchitiet> hdct;
	
}
