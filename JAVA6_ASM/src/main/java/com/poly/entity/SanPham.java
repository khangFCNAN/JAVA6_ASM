package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanpham")
	List<Hoadonchitiet> hoadonchitiet;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanpham")
	List<Chitietgiohang> chitietgiohang;

	@Override
	public String toString() {
		return "SanPham [idSp=" + idSp + ", tenSp=" + tenSp + ", giaSp=" + giaSp + ", anhSp=" + anhSp + ", soLuong="
				+ soLuong + ", ngayTao=" + ngayTao + ", moTa=" + moTa + ", baoHanh=" + baoHanh + ", loaisanpham="
				+ loaisanpham + ", thuonghieu=" + thuonghieu + ", hoadonchitiet=" + hoadonchitiet + ", chitietgiohang="
				+ chitietgiohang + "]";
	}

	
}
