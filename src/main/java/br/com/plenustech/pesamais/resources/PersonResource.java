package br.com.plenustech.pesamais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

	@Autowired
	private PersonService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> findById(@PathVariable Integer id){
		Person person = service.findById(id);
		return ResponseEntity.ok(person);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> findAll(){
		List<Person> persons = service.findAll();
		ResponseEntity.ok();
		return persons;
	}
	
}