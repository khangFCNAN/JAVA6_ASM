package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hoadons")
public class HoaDon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHd;

	@ManyToOne()
	@JoinColumn(name = "tai_khoan", insertable = false, updatable = false)
	KhachHang khachhang;

	@Column(name = "tai_khoan")
	String taiKhoan;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tao")
	Date NgayTao = new Date();

	@Column(name = "dia_chi")
	String diaChi;

	@Column(name = "tong_tien")
	double tongTien;

	@Column(name = "sdt")
	String sdt;
	
	@Column(name = "trang_thai")
	String trangThai;
	
	@Column(name = "ghi_chu")
	String ghiChu;

	@JsonIgnore
	@OneToMany(mappedBy = "hoadon")
	List<Hoadonchitiet> hoadonchitiet;


}