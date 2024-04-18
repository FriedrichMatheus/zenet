package br.com.zenet.zenet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenet.zenet.dto.AuthRequest;
import br.com.zenet.zenet.dto.AuthResponse;
import br.com.zenet.zenet.entity.UserEntity;
import br.com.zenet.zenet.exception.LoginException;
import br.com.zenet.zenet.exception.NotFoundException;
import br.com.zenet.zenet.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	private UserService userService;
	
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<AuthResponse> logIn(@RequestBody AuthRequest authRequest) throws LoginException {
		UserEntity userEntity;
		
		try {
			userEntity = userService.getUserByLogin(authRequest.getLogin());
		} catch (NotFoundException e) {
			throw new LoginException("Login e/ou senha inválidos!");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
		
		boolean passwordIsMatch = encoder.matches(authRequest.getPassword(), userEntity.getPassword());
		if(!passwordIsMatch) throw new LoginException("Login e/ou senha inválidos!");
		
		return null;
	}
	
}
