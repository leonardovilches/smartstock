package com.lv.smartstock.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lv.smartstock.dto.ProdutoDTO;
import com.lv.smartstock.entities.Produto;
import com.lv.smartstock.services.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDTO objDto) {
		Produto obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> find(@PathVariable String id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoDTO objDto, @PathVariable String id) {
		Produto obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() throws ObjectNotFoundException {
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDto = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
//	@GetMapping
//	public ResponseEntity<Page<ProdutoDTO>> findPage(
//			@RequestParam(value="nome", defaultValue="") String nome, 
//			@RequestParam(value="categorias", defaultValue="") String categorias, 
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		String nomeDecoded = URL.decodeParam(nome);
//		List<String> ids = URL.decodeIntList(categorias);
//		Page<Produto> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
//		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));  
//		return ResponseEntity.ok().body(listDto);
//	}
}
