package com.lv.smartstock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lv.smartstock.dto.UsuarioDTO;
import com.lv.smartstock.entities.Usuario;
import com.lv.smartstock.repositories.UsuarioRepository;
import com.lv.smartstock.services.exceptions.DataIntegrityException;
import com.lv.smartstock.services.exceptions.ObjectNotFoundException;


@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(String id) throws ObjectNotFoundException {
		Optional<Usuario> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}

	public void delete(String id) {
		find(id);
		try {
			repo.deleteById(id);			
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), pe.encode(objDto.getSenha()));
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());			
		}
		if (obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());			
		}
	}
}
