package com.lv.smartstock.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "produtos")
@Entity
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(notes = "Nome Categoria")
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}