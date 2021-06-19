package com.lv.smartstock.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lv.smartstock.entities.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteOnlyPasswordDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min=4, max = 16, message = "O tamanho deve ser entre 4 a 16 caracteres")
	private String senhaNova;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String senhaAtual;

	
	public ClienteOnlyPasswordDTO(Cliente obj, String senhaAtual) {
		id = obj.getId();
		senhaNova = obj.getSenha();
		this.senhaAtual = senhaAtual;
	}

	
}