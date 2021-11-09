package br.com.infinet.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.infinet.model.Planet;
import br.com.infinet.repository.PlanetRepository;

@Component
public class InsertPlanets {
	@Autowired
	PlanetRepository planetRepository;
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		this.planetRepository.save(Planet.builder().name("Alderaan").terrain("Mountain").build());
		this.planetRepository.save(Planet.builder().name("Tatooine").terrain("Desert").build());
		this.planetRepository.save(Planet.builder().name("Dagobah").terrain("Swamp").build());
	}
}
