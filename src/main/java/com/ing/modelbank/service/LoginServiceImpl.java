package com.ing.modelbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.controller.LoginController;
import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String login(LoginDto loginDto) {
		Customer customer = customerRepository.findByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());
		if (customer != null) {
			return "logged in successfully..";
		} else {

			return "invalid credentials";
		}

	}

} 
