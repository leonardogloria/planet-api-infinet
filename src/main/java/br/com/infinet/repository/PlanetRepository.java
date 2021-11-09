package br.com.infinet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infinet.model.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

}
