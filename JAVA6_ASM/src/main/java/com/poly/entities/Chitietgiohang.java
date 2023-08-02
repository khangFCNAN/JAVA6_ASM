package com.poly.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
