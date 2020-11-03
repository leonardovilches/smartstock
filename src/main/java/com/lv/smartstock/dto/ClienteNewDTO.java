package com.lv.smartstock.dto;

import java.io.Serializable;

import com.lv.smartstock.entities.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	
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
