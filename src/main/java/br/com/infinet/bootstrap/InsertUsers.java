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
public class InsertUsers {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		this.perfilRepository.save(Perfil.builder().name("user").build());
		this.perfilRepository.save(Perfil.builder().name("adm").build());
		this.perfilRepository.save(Perfil.builder().name("root").build());
		
		
		User user = new User();
		user.setEmail("lsilva@credilink.com.br");
		user.setPass(new BCryptPasswordEncoder().encode("123456"));
		HashSet<Perfil> hashSet = new HashSet<Perfil>(); 
		hashSet.add(perfilRepository.findById(3L).get());
		user.setPerfis(hashSet);
		this.userRepository.save(user);
		
	}
}
