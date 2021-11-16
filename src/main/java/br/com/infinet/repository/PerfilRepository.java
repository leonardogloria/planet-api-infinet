package br.com.infinet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infinet.model.Perfil;
@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long> {}
