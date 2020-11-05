package com.lv.smartstock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lv.smartstock.dto.ProdutoDTO;
import com.lv.smartstock.entities.Categoria;
import com.lv.smartstock.entities.Produto;
import com.lv.smartstock.repositories.CategoriaRepository;
import com.lv.smartstock.repositories.ProdutoRepository;
import com.lv.smartstock.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPreco());
	}
}
