package com.lv.smartstock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lv.smartstock.dto.ProdutoDTO;
import com.lv.smartstock.entities.Produto;
import com.lv.smartstock.repositories.CategoriaRepository;
import com.lv.smartstock.repositories.ProdutoRepository;
import com.lv.smartstock.services.exceptions.DataIntegrityException;
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
	
	public Produto find(String id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public void delete(String id) {
		find(id);
		try {
			repo.deleteById(id);			
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um produto");
		}
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

//	public Page<Produto> search(String nome, List<String> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAllById(ids);
//		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
//	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPreco(), objDto.getCategoria_ids());
	}

	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}
	
	private void updateData(Produto newObj, Produto obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
			newObj.setCategoria_ids(obj.getCategoria_ids());
		}
	}
}
