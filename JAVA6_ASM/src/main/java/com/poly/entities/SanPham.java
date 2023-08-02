package com.poly.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType; 
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sanphams")
public class SanPham implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_sp")
	Integer idSp;
	
//	@NotBlank(message = "{NotBlank.sanpham.tenSp}")
	@Column(name = "ten_sp")
	String tenSp;
	
//	@Min(value = 0, message = "{Min.sanpham.giaSp}")
//	@NotNull(message = "{NotNull.sanpham.giaSp}")
	@Column(name = "gia_sp")
	Double giaSp;
	
//	@NotBlank(message = "{NotBlank.sanpham.anhSp}")
	@Column(name = "anh_sp")
	String anhSp;
	
//	@Min(value = 0, message = "{Min.sanpham.soLuong}")
//	@NotNull(message = "{NotNull.sanpham.soLuong}")
	@Column(name = "so_luong")
	Integer soLuong;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tao")
	Date ngayTao = new Date();
	
	@Column(name = "mo_ta")
	String moTa;
	
	@NotNull(message = "{NotNull.sanpham.baoHanh}")
	@Column(name = "bao_hanh")
	Boolean baoHanh;
	
	@NotBlank(message = "{NotBlank.sanpham.loaisanpham}")
	@ManyToOne
	@JoinColumn(name = "id_loai")
	Loaisanpham loaisanpham;

	@NotBlank(message = "{NotBlank.sanpham.thuonghieu}")
	@ManyToOne
	@JoinColumn(name = "id_th")
	Thuonghieu thuonghieu;

	
}
