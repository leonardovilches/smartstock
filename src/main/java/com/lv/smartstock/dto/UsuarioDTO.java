package com.lv.smartstock.dto;

import javax.validation.constraints.NotEmpty;

import com.lv.smartstock.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String senha;
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
}
