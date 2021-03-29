package com.lv.smartstock.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lv.smartstock.entities.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	@Transactional(readOnly = true)
	Usuario findByEmail(String email);
}
