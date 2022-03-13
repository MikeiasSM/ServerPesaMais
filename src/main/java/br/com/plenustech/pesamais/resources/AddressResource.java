package br.com.plenustech.pesamais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.plenustech.pesamais.domain.Address;
import br.com.plenustech.pesamais.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {

	@Autowired
	private AddressService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Address> findById(@PathVariable Integer id){
		Address address = service.findById(id);
		return ResponseEntity.ok(address);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Address> findAll(){
		List<Address> addresses = service.findAll();
		ResponseEntity.ok();
		return addresses;
	}
	
}