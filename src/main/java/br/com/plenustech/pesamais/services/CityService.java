package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.repositories.CityRepository;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public City findById(Integer id) {
		Optional<City> city = repository.findById(id);
		return city.orElseThrow(() -> new ObjectNotFoundException(
				"City "+ id +" not found. Type: "+ City.class.getName())
		);
	}

	public List<City> findAll() {
		List<City> cities = repository.findAll();
		return cities;
	}
}
