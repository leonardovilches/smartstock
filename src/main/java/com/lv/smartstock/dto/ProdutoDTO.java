package com.lv.smartstock.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lv.smartstock.entities.Categoria;
import com.lv.smartstock.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private Double preco;
	private List<Categoria> categoria_ids = new ArrayList<>();
	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
		categoria_ids = obj.getCategoria_ids();
	}
}
