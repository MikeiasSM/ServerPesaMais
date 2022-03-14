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

import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.domain.dto.StateDTO;
import br.com.plenustech.pesamais.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateResource {

	@Autowired
	private StateService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<State> find(@PathVariable Integer id){
		State state = service.findById(id);
		return ResponseEntity.ok(state);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody StateDTO objDTO){
		State obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_state()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody StateDTO objDTO, @PathVariable Integer id){
		State obj = service.fromDTO(objDTO);
		obj.setId_state(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StateDTO>> findAll() {		
		List<State> states = service.findAll();		
		List<StateDTO> statesDTO = states.stream().map(obj -> new StateDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(statesDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<StateDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {		
		Page<State> states = service.findPage(page, linesPerPage, orderBy, direction);		
		Page<StateDTO> statesDTO = states.map(obj -> new StateDTO(obj));
		return ResponseEntity.ok(statesDTO);
	}
	
}
