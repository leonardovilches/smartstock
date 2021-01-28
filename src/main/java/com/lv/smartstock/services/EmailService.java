package com.lv.smartstock.services;

import org.springframework.mail.SimpleMailMessage;

import com.lv.smartstock.entities.Cliente;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
