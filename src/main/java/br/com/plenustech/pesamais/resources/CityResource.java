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

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.domain.dto.CityDTO;
import br.com.plenustech.pesamais.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

	@Autowired
	private CityService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> findById(@PathVariable Integer id){
		City city = service.findById(id);
		return ResponseEntity.ok(city);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CityDTO objDTO){
		City obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_city()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CityDTO objDTO, @PathVariable Integer id){
		City obj = service.fromDTO(objDTO);
		obj.setId_city(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> findAll() {		
		List<City> cities = service.findAll();		
		List<CityDTO> citiesDTO = cities.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(citiesDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CityDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {		
		Page<City> cities = service.findPage(page, linesPerPage, orderBy, direction);		
		Page<CityDTO> citiesDTO = cities.map(obj -> new CityDTO(obj));
		return ResponseEntity.ok(citiesDTO);
	}
	
}