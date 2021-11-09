package br.com.infinet.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infinet.model.Planet;
import br.com.infinet.repository.PlanetRepository;

@RestController
@RequestMapping("/api/planet")
public class PlanetController {
	@Autowired
	PlanetRepository planetRepository;

	@GetMapping
	public ResponseEntity getAll() {
		Iterable<Planet> findAll = this.planetRepository.findAll();
		return ResponseEntity.ok(findAll);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		this.planetRepository.deleteById(id);
		return  ResponseEntity.accepted().build();
	}
}
