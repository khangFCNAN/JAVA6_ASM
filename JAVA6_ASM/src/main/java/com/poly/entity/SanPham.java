package com.poly.entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sanphams")
public class SanPham implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sp")
	Integer idSp;
	
	@Column(name = "ten_sp")
	String tenSp;
	 
	
	@Column(name = "gia_sp")
	Double giaSp;
	
	@Column(name = "anh_sp")
	String anhSp;
	
	
	@Column(name = "so_luong")
	Integer soLuong;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tao")
	Date ngayTao = new Date();

	@Column(name = "mo_ta")
	String moTa;
	
	@Column(name = "bao_hanh")
	Boolean baoHanh;

	@ManyToOne
	@JoinColumn(name = "id_loai")
	Loaisanpham loaisanpham;

	@ManyToOne
	@JoinColumn(name = "id_th")
	Thuonghieu thuonghieu;

	@OneToMany(mappedBy = "sanpham")
	List<Hoadonchitiet> hoadonchitiet;

	@OneToMany(mappedBy = "sanpham")
	List<Chitietgiohang> chitietgiohang;

}
