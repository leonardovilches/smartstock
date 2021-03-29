package com.lv.smartstock.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "produtos_ids")
//@Entity
@Document
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	private String nome;
	
//	@ManyToMany(mappedBy="categorias")
//	private List<Produto> produtos = new ArrayList<>();
	@DBRef
    private List<Produto> produtos_ids = new ArrayList<>();
	
	public Categoria(String id, String nome, List<Produto> produtos_ids ) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtos_ids = produtos_ids;
	}
}
