package com.poly.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = { @UniqueConstraint(columnNames = { "taiKhoan", "Roleid" }) })
public class Authority {
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
