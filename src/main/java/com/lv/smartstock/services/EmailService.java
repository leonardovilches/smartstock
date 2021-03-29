package com.lv.smartstock.services;

import org.springframework.mail.SimpleMailMessage;

import com.lv.smartstock.entities.Usuario;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
}
