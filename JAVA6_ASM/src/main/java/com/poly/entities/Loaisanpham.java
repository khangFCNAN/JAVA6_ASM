package com.poly.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Loaisanphams")
public class Loaisanpham implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loai")
	Integer idLoai;
	
	@Column(name = "ten_loai")
	@NotBlank(message = "Chưa nhập tên loại")
	String tenLoai;
	@OneToMany(mappedBy = "loaisanpham")
	List<SanPham> sanphams;
}
