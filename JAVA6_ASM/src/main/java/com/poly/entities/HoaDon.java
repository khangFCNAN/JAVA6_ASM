package com.poly.entities;

import java.io.Serializable;
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
@Table(name = "Hoadons")
public class HoaDon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHd;
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	KhachHang khachhang;

	@Column(insertable = false, updatable = false)
	private String taiKhoan;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayTao")
	private Date NgayTao;

	String diaChi;

	@Column(name = "tong_tien")
	private double tongTien;

	private String sdt;
	String trangThai;
	private String ghiChu;
	@OneToMany(mappedBy = "hoadon")
	List<Hoadonchitiet> hoadonchitiet;

}