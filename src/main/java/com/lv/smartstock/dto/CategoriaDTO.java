package com.lv.smartstock.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lv.smartstock.entities.Categoria;
import com.lv.smartstock.entities.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min=3, max=80, message = "O tamanho deve ser entre 3 e 80 caracteres")
	private String nome;
	private List<Produto> produtos_ids = new ArrayList<>();
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
		produtos_ids = obj.getProdutos_ids();
	}

}
