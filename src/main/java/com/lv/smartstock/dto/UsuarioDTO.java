package com.lv.smartstock.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lv.smartstock.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String id;
	@Length(min=5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String nome;
	@Email(message = "Email inválido.")
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String senha;
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
//		senha = obj.getSenha();
	}
}
