package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.Address;
import br.com.plenustech.pesamais.repositories.AddressRepository;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address findById(Integer id) {
		Optional<Address> address = repository.findById(id);
		return address.orElseThrow(() -> new ObjectNotFoundException(
				"Address "+ id +" not found. Type: "+ Address.class.getName())
		);
	}

	public List<Address> findAll() {
		List<Address> addresses = repository.findAll();
		return addresses;
	}
}
