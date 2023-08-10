package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = { @UniqueConstraint(columnNames = { "taiKhoan", "Roleid" }) })
public class Authorities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private KhachHang taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "Roleid")
	private Role role;
}
