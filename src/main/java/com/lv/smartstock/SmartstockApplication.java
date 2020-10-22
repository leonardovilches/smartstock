package com.lv.smartstock;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lv.smartstock.entity.Categoria;
import com.lv.smartstock.entity.Cidade;
import com.lv.smartstock.entity.Cliente;
import com.lv.smartstock.entity.Endereco;
import com.lv.smartstock.entity.Estado;
import com.lv.smartstock.entity.Produto;
import com.lv.smartstock.repository.CategoriaRepository;
import com.lv.smartstock.repository.CidadeRepository;
import com.lv.smartstock.repository.ClienteRepository;
import com.lv.smartstock.repository.EnderecoRepository;
import com.lv.smartstock.repository.EstadoRepository;
import com.lv.smartstock.repository.ProdutoRepository;

@SpringBootApplication
public class SmartstockApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Fronteira", est1);
		Cidade cid2 = new Cidade(null, "São José do Rio Preto", est2);
		Cidade cid3 = new Cidade(null, "Mirassolândia", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36367733809");
		cliente1.getTelefones().addAll(Arrays.asList("17-991531742", "17-992056841"));
		
		Cliente cliente2 = new Cliente(null, "Leonardo Vilches", "leovilches08@gmail.com", "36367733809");
		cliente2.getTelefones().addAll(Arrays.asList("17-991531742"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim Maracanã", "353700940", cliente1, cid1);
		Endereco end2 = new Endereco(null, "Rua Benjamin Constant", "3438", "Apto 74", "Centro", "353700940", cliente2, cid2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(end1));
		cliente2.getEnderecos().addAll(Arrays.asList(end2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
	}

}
