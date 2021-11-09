package br.com.infinet.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.infinet.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class TokenService {

	private String secret = "verystrongsecret"; 

	public String generateToken(Authentication auth) {
		User user = (User) auth.getPrincipal();
		Date now = new Date();
		Date exp = new Date((now.getTime() + (6000 * 60 * 60)));

		return Jwts.builder().setIssuer("www.acme.com.br").setSubject(user.getId().toString())
				.claim("user", user.getEmail()).setIssuedAt(new Date()).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, secret).compact();

	}
	public Long getIdFromToken(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.valueOf(body.getSubject());
	}
	public String getUserNameFromToken(String token) {
		 return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("user");
	}
	public Boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
