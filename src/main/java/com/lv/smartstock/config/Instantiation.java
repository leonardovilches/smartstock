package com.lv.smartstock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lv.smartstock.repositories.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
//		usuarioRepository.deleteAll();
//		
//		Usuario leo = new Usuario(null, "Leonardo Vilches", "leovilches08@gmail.com", "1234");
//		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com", "1234");
//		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com", "1234");
//		
//		usuarioRepository.saveAll(Arrays.asList(leo, alex, bob));
	}

}
