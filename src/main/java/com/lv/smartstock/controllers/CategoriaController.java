package com.lv.smartstock.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lv.smartstock.dto.CategoriaDTO;
import com.lv.smartstock.entities.Categoria;
import com.lv.smartstock.services.CategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
@Api(value = "Categoria Controller")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@ApiOperation(value = "Busca uma categoria pelo ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Insere categoria.")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Atualiza categoria pelo ID.")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id) {
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value = "Deleta categoria pelo ID.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Busca todas categorias.")
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() throws ObjectNotFoundException {
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "Busca pela página.")
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) throws ObjectNotFoundException {
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
