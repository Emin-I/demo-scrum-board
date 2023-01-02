package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restservice.auth.TokenManager;
import com.example.restservice.dtos.User;
import com.example.restservice.mappers.UserMapper;

@Service
public class TokenService {
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private UserMapper userMapper;

	public String generateToken(User u) throws Exception {

		return tokenManager.generateToken(userMapper.mapFromDto(u));
	}

}
