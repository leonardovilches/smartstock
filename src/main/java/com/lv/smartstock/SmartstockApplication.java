package com.lv.smartstock;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lv.smartstock.entity.Categoria;
import com.lv.smartstock.entity.Produto;
import com.lv.smartstock.repository.CategoriaRepository;
import com.lv.smartstock.repository.ProdutoRepository;

@SpringBootApplication
public class SmartstockApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SmartstockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Juju");
		Categoria cat2 = new Categoria(null, "Bolo");
		
		Produto p1 = new Produto(null, "Chocolate", 5.0);
		Produto p2 = new Produto(null, "Ninho com nutella", 5.0);
		Produto p3 = new Produto(null, "Negresco", 5.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p1, p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
