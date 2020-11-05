package com.lv.smartstock.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min=5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	@CPF(message = "Cpf Inválido")
	private String cpf;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String senha;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;
	
	
}
