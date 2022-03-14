package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.domain.dto.StateDTO;
import br.com.plenustech.pesamais.repositories.StateRepository;
import br.com.plenustech.pesamais.services.exceptions.DataIntegrityException;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	
	public State findById(Integer id) {
		Optional<State> state = repository.findById(id);
		return state.orElseThrow(() -> new ObjectNotFoundException(
				"State "+ id +" not found. Type: "+ State.class.getName())
		);		
	}
	
	public List<State> findAll() {
		return repository.findAll();
	}
	
	public Page<State> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public State insert(State obj) {
		obj.setId_state(null);
		return repository.save(obj);
	}
	
	public State update(State obj) {
		State newObj = findById(obj.getId_state());
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
	
	public State fromDTO(StateDTO stateDTO) {
		return new State(stateDTO.getId_state(), stateDTO.getName(), stateDTO.getUf());
	}
	
	private void updateData(State newObj, State obj) {
		newObj.setId_state(obj.getId_state());
		newObj.setName(obj.getName());
		newObj.setUf(obj.getUf());
	}
}
