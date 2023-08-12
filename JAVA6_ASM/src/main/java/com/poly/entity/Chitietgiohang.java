package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Chitietgiohangs")
public class Chitietgiohang implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ctgh;
	
	@ManyToOne
	@JoinColumn(name = "idSp")
	SanPham sanpham;
	
	private Integer soLuong;
	
	@ManyToOne
	@JoinColumn(name = "idGh")
	GioHang giohang;

	@Override
	public String toString() {
		return "Chitietgiohang [id_ctgh=" + id_ctgh + ", sanpham=" + sanpham + ", soluong=" + soLuong + ", giohang="
				+ giohang + "]";
	}

}
