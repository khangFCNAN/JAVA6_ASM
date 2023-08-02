package com.poly.entities;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
	@NotBlank(message = "Chưa nhập tên sản phẩm")
	@Column(name = "ten_sp")
	String tenSp;
	 
	@Min(value = 0, message = "Không nhập giá âm hoặc có chữ cái")
	@NotNull(message = "Không để trống giá")
	@Column(name = "gia_sp")
	Double giaSp;
	
	@Column(name = "anh_sp")
	String anhSp;
	
	@Min(value = 0, message = "Không nhập số lượng âm hoặc có chữ cái")
	@NotNull(message = "Không để trống số lượng")
	@Column(name = "so_luong")
	Integer soLuong;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tao")
	Date ngayTao = new Date();

	@Column(name = "mo_ta")
	String moTa;
	
	@NotNull(message = "Vui lòng chọn bảo hành")
	@Column(name = "bao_hanh")
	Boolean baoHanh;

	@ManyToOne
	@NotNull(message = "Chưa chọn loại")
	@JoinColumn(name = "id_loai")
	Loaisanpham loaisanpham;

	@ManyToOne
	@NotNull(message = "Chưa chọn thương hiệu")
	@JoinColumn(name = "id_th")
	Thuonghieu thuonghieu;

	@OneToMany(mappedBy = "sanpham")
	List<Hoadonchitiet> hoadonchitiet;

	@OneToMany(mappedBy = "sanpham")
	List<Chitietgiohang> chitietgiohang;

}
