package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.repositories.PersonRepository;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public Person findById(Integer id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ObjectNotFoundException(
				"Person "+ id +" not found. Type: "+ Person.class.getName())
		);
	}

	public List<Person> findAll() {
		List<Person> persons = repository.findAll();
		return persons;
	}
}
