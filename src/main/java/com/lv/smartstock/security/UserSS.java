package com.lv.smartstock.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lv.smartstock.entities.enums.Perfil;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSS implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
//	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.senha = senha;
//		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
//	}
	
	public UserSS(String id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
