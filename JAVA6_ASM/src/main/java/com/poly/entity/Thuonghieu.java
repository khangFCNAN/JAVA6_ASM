package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Thuonghieus")
public class Thuonghieu implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idTh;
	
	String tenTh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "thuonghieu")
	
	List<SanPham> sanphams;

	@Override
	public String toString() {
		return "Thuonghieu [idTh=" + idTh + ", tenTh=" + tenTh + ", sanphams=" + sanphams + "]";
	}
}
