package br.com.infinet.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.infinet.model.Perfil;
import br.com.infinet.repository.PerfilRepository;
import br.com.infinet.repository.PlanetRepository;
@Component
public class InsertPerfil {
		@Autowired
		PerfilRepository perfilRepository;
		@EventListener
		public void appReady(ApplicationReadyEvent event) {
			this.perfilRepository.save(Perfil.builder().name("ROOT").build());
			this.perfilRepository.save(Perfil.builder().name("ADMIN").build());
			this.perfilRepository.save(Perfil.builder().name("USER").build());
		
		}
}
