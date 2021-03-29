package com.lv.smartstock.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lv.smartstock.entities.Categoria;
import com.lv.smartstock.entities.Cidade;
import com.lv.smartstock.entities.Cliente;
import com.lv.smartstock.entities.Endereco;
import com.lv.smartstock.entities.Estado;
import com.lv.smartstock.entities.Produto;
import com.lv.smartstock.entities.Usuario;
import com.lv.smartstock.entities.enums.Perfil;
import com.lv.smartstock.repositories.CategoriaRepository;
import com.lv.smartstock.repositories.CidadeRepository;
import com.lv.smartstock.repositories.ClienteRepository;
import com.lv.smartstock.repositories.EnderecoRepository;
import com.lv.smartstock.repositories.EstadoRepository;
import com.lv.smartstock.repositories.ProdutoRepository;
import com.lv.smartstock.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateTestDatabase() {
//		Categoria cat1 = new Categoria(null, "Juju");
//		Categoria cat2 = new Categoria(null, "Bolo");
//		Categoria cat3 = new Categoria(null, "Bolo de pote");
//		Categoria cat4 = new Categoria(null, "Donuts");
//		Categoria cat5 = new Categoria(null, "Barra de chocolate");
//		Categoria cat6 = new Categoria(null, "Sorvete");
//		Categoria cat7 = new Categoria(null, "Lasanha");
//		Categoria cat8 = new Categoria(null, "Pizza");
//		
//		Produto p1 = new Produto(null, "Chocolate", 5.0);
//		Produto p2 = new Produto(null, "Ninho com nutella", 5.0);
//		Produto p3 = new Produto(null, "Negresco", 5.0);
//		
//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat2.getProdutos().addAll(Arrays.asList(p1, p3));
//		
//		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
//		p2.getCategorias().addAll(Arrays.asList(cat1));
//		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));		
//		
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
//		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
//		
//		Estado est1 = new Estado(null, "Minas Gerais");
//		Estado est2 = new Estado(null, "São Paulo");
//		
//		Cidade cid1 = new Cidade(null, "Fronteira", est1);
//		Cidade cid2 = new Cidade(null, "São José do Rio Preto", est2);
//		Cidade cid3 = new Cidade(null, "Mirassolândia", est2);
//		
//		est1.getCidades().addAll(Arrays.asList(cid1));
//		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
//		
//		estadoRepository.saveAll(Arrays.asList(est1, est2));
//		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
//		
//		Cliente cliente1 = new Cliente(null, "João José Alcebiades", "jjjunior@gmail.com", "36367733809", pe.encode("1234"));
//		cliente1.getTelefones().addAll(Arrays.asList("17-991531742", "17-992056841"));
//		cliente1.addPerfil(Perfil.ADMIN);
//		
//		Cliente cliente2 = new Cliente(null, "Leonardo Vilches", "leovilches08@gmail.com", "36367733809", pe.encode("1234"));
//		cliente2.getTelefones().addAll(Arrays.asList("17-991531742"));
//		
//		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim Maracanã", "353700940", cliente1, cid1);
//		Endereco end2 = new Endereco(null, "Rua Benjamin Constant", "3438", "Apto 74", "Centro", "353700940", cliente2, cid2);
//		
//		cliente1.getEnderecos().addAll(Arrays.asList(end1));
//		cliente2.getEnderecos().addAll(Arrays.asList(end2));
//		
//		
//		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
//		enderecoRepository.saveAll(Arrays.asList(end1, end2));
//		
//		Usuario usr1 = new Usuario(null, "João José Alcebiades Junior", "jjjunior@gmail.com", pe.encode("1234"));
//		Usuario usr2 = new Usuario(null, "Josi Alcebiades", "josialcebiades@gmail.com", pe.encode("1234"));
//		usuarioRepository.saveAll(Arrays.asList(usr1, usr2));
	}
}
