package br.com.plenustech.pesamais.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.domain.dto.PersonDTO;
import br.com.plenustech.pesamais.domain.dto.PersonWithAddressDTO;
import br.com.plenustech.pesamais.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

	@Autowired
	private PersonService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> findById(@PathVariable Integer id){
		Person person = service.findById(id);
		return ResponseEntity.ok(person);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PersonWithAddressDTO objDTO){
		Person obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_person()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PersonDTO objDTO, @PathVariable Integer id){
		Person obj = service.fromDTO(objDTO);
		obj.setId_person(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> findAll() {		
		List<Person> users = service.findAll();		
		List<PersonDTO> usersDTO = users.stream().map(obj -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(usersDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PersonDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {		
		Page<Person> users = service.findPage(page, linesPerPage, orderBy, direction);		
		Page<PersonDTO> usersDTO = users.map(obj -> new PersonDTO(obj));
		return ResponseEntity.ok(usersDTO);
	}	
	
}