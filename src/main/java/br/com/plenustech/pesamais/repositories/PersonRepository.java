package br.com.plenustech.pesamais.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plenustech.pesamais.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Transactional
	Person findByEmail(String email);
}
