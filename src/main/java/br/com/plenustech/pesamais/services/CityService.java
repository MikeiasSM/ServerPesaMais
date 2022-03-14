package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.domain.dto.CityDTO;
import br.com.plenustech.pesamais.repositories.CityRepository;
import br.com.plenustech.pesamais.services.exceptions.DataIntegrityException;
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
		return repository.findAll();
	}
	
	public Page<City> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public City insert(City obj) {
		obj.setId_city(null);
		return repository.save(obj);
	}
	
	public City update(City obj) {
		City newObj = findById(obj.getId_city());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
		
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("O registro não pode ser excluido, pois o mesmo possui relacionamento!");
		}
	}
	
	public City fromDTO(CityDTO cityDTO) {
		State state = new State(cityDTO.getId_state(), null, null);
		return new City(cityDTO.getId_city(), cityDTO.getName(), state);
	}
	
	private void updateData(City newObj, City obj) {
		newObj.setId_city(obj.getId_city());
		newObj.setName(obj.getName());
		newObj.setState(obj.getState());
	}
}
