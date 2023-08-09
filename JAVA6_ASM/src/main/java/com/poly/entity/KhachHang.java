package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Khachhangs")
public class KhachHang implements Serializable {
	@Id
	@Column(nullable = false, unique = true, name = "taiKhoan")
	private String taiKhoan;

	@Column(nullable = false)
	private String matKhau;

	@Column(nullable = false)
	private String hoTen;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private boolean trangThai;

	@Column(nullable = false)
	private boolean admin;

	@Column(name = "ma_xac_nhan")
	private String maXacNhan;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<GioHang> giohang;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<HoaDon> hoadon;


	public String getXacNhanMatKhau() {
		// TODO Auto-generated method stub
		return null;
	}

}
