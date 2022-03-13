package br.com.plenustech.pesamais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

	@Autowired
	private CityService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<City> findById(@PathVariable Integer id){
		City city = service.findById(id);
		return ResponseEntity.ok(city);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<City> findAll(){
		List<City> cities = service.findAll();
		ResponseEntity.ok();
		return cities;
	}
	
}