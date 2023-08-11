package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable{
	@Id
	private String id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authority;
	
}
