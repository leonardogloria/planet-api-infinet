package br.com.infinet.bootstrap;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.infinet.model.Perfil;
import br.com.infinet.model.User;
import br.com.infinet.repository.PerfilRepository;
import br.com.infinet.repository.UserRepository;
@Component
public class InsertUser {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PerfilRepository perfilRepository;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		User user = new User();
		user.setEmail("lsilva@credilink.com.br");
		user.setPass(new BCryptPasswordEncoder().encode("123456"));
		
		
		User user2 = new User();
		user2.setEmail("lsilva2@credilink.com.br");
		user2.setPass(new BCryptPasswordEncoder().encode("123456"));
		
		
		Perfil perfil = perfilRepository.findById(2L).get();
		HashSet<Perfil> hashSet = new HashSet<Perfil>();
		hashSet.add(perfil);
		user.setPerfis(hashSet);
		this.userRepository.save(user);
		
		Perfil perfil2 = perfilRepository.findById(3L).get();
		HashSet<Perfil> hashSet2 = new HashSet<Perfil>();
		hashSet2.add(perfil2);
		user2.setPerfis(hashSet2);
		this.userRepository.save(user2);
		
		
	}
}
