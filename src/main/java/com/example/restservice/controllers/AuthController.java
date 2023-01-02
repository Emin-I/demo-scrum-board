package com.example.restservice.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.example.restservice.dtos.JwtRequest;
import com.example.restservice.dtos.User;
import com.example.restservice.services.TokenService;
import com.example.restservice.services.UserService;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/token")
	public String token(@RequestBody JwtRequest userRequest) {
		var logger = LoggerFactory.getLogger(AuthController.class);
		logger.info(
				"YES!!! YOU GOT TO THE AuthController::login for /token with username: " + userRequest.getUsername());

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "CHECK YOUR REQUEST!\n");
		}

		final UserDetails userDetails = userService.loadUserByUsername(userRequest.getUsername());

		var u = new User();
		u.setUsername(userDetails.getUsername());

		try {
			var t = tokenService.generateToken(u);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
