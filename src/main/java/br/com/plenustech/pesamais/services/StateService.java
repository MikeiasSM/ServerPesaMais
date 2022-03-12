package br.com.plenustech.pesamais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	
	public State findById(Integer id) {
		Optional<State> state = repository.findById(id);
		return state.orElse(null);		
	}
}
