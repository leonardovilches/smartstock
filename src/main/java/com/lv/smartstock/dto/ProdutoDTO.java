package com.lv.smartstock.dto;

import java.io.Serializable;

import com.lv.smartstock.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
	}
}
