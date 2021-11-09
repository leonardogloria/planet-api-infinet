package br.com.infinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infinet.model.LoginDTO;
import br.com.infinet.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	@PostMapping
	public ResponseEntity doLogin(@RequestBody LoginDTO login) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				login.getEmail(), login.getPass());
		Authentication authentication = manager.authenticate(usernamePasswordAuthenticationToken);
		String token = tokenService.generateToken(authentication);
		return ResponseEntity.ok(token);

	}
}
