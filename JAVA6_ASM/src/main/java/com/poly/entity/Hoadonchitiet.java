package com.poly.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
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

@SuppressWarnings("serial")


//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hoadonchitiets")
public class Hoadonchitiet implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHdct;
	
	@ManyToOne
	@JoinColumn(name = "idHd")
	private HoaDon hoadon;
	
	@Column(insertable=false, updatable=false)
	public Integer idHd;
	
	@ManyToOne
	@JoinColumn(name = "idSp")
	
	SanPham sanpham;
	@Column(insertable=false, updatable=false)
	public Integer idSp;

	public Double gia;
	
	public Integer soLuong;
	
	public SanPham getSanPham() {
		return this.sanpham;
	}
	public void setSanPham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	
	public Integer getSoLuong() {
		return this.soLuong;
	}
	public void setSoLuong(Integer soluong) {
		this.soLuong = soluong;
	}
	
	public Double getGia() {
		return this.gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	
	
	
	
	
}