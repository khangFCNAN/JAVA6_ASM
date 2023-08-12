package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
	public void setHoaDon(HoaDon hoadon2) {
		// TODO Auto-generated method stub
		
	}
}