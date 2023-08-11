package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hoadons")
public class HoaDon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHd;

	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	KhachHang khachhang;

	@Column(insertable = false, updatable = false)
	String taiKhoan;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayTao")
	Date NgayTao;

	String diaChi;

	@Column(name = "tong_tien")
	double tongTien;

	String sdt;
	String trangThai;
	String ghiChu;

	@JsonIgnore
	@OneToMany(mappedBy = "hoadon")
	List<Hoadonchitiet> hoadonchitiet;

}