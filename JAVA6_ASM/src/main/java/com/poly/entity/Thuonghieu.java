package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
