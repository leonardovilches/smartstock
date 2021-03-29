package com.lv.smartstock.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Document
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	private String nome;
	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	public Usuario(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
}
