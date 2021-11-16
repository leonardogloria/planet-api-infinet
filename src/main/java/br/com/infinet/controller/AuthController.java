package br.com.infinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infinet.model.LoginDTO;
import br.com.infinet.model.TokenDTO;
import br.com.infinet.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	TokenService tokenService;
	
	@Autowired
	AuthenticationManager manager;
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody LoginDTO loginDTO) {
		
		UsernamePasswordAuthenticationToken auth 
		= new UsernamePasswordAuthenticationToken(loginDTO.getUser(), loginDTO.getPass());
		
		Authentication authenticate = manager.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

		String token = this.tokenService.generateToken(authenticate);
		return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());
		
	}

}
