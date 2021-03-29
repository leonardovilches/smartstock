package com.lv.smartstock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lv.smartstock.entities.Usuario;
import com.lv.smartstock.repositories.UsuarioRepository;
import com.lv.smartstock.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
//	@Autowired
//	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(user.getId(), user.getEmail(), user.getSenha());
	}

}
