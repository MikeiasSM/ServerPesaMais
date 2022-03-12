package br.com.plenustech.pesamais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public City findById(Integer id) {
		Optional<City> city = repository.findById(id);
		return city.orElse(null);
	}
}
