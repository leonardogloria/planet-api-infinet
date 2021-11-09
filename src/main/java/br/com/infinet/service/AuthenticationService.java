package br.com.infinet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.infinet.model.User;
import br.com.infinet.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = repository.findByEmail(username);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new UsernameNotFoundException("User Not Found");
		
	}

}
