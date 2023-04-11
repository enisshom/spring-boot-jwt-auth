package com.jwt.springboot.jwtauth.auth;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.springboot.jwtauth.config.JwtService;
import com.jwt.springboot.jwtauth.user.Role;
import com.jwt.springboot.jwtauth.user.User;
import com.jwt.springboot.jwtauth.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
	
	private final UserRepository repository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;


	public AuthenticationResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
		var user = User
				.builder()
				.firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(request.getPassword())
		        .role(Role.USER)
		        .build();
		var savedUser = repository.save(user);
		var jwtToken = jwtService.generatetoken(new HashMap<>(),user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
				
		
	}

	

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		 authenticationManager.authenticate(
				 new UsernamePasswordAuthenticationToken(
						 request.getEmail(),
						 request.getPassword()
						 ));
		 
		 var user = repository.findByEmail(request.getEmail())
				 .orElseThrow();
		 var jwtToken = jwtService.generatetoken(new HashMap<>(),user);
		 return AuthenticationResponse.builder()
				 .token(jwtToken)
				 .build();
		
	}

}
