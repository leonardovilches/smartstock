package com.lv.smartstock.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "categoria_ids")
@Document
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private Double preco;
	
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name = "PRODUTO_CATEGORIA",joinColumns = @JoinColumn(name = "produto_id"),
//			inverseJoinColumns = @JoinColumn(name = "categoria_id")
//	)
//	private List<Categoria> categorias = new ArrayList<>();
	@DBRef
	private List<Categoria> categoria_ids;

	public Produto(String id, String nome, Double preco, List<Categoria> categoria_ids) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria_ids = categoria_ids;
	}
}
