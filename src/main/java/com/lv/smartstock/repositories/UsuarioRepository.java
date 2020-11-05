package com.lv.smartstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lv.smartstock.entities.Cliente;
import com.lv.smartstock.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
}
