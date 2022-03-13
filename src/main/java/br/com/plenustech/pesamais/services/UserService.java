package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.User;
import br.com.plenustech.pesamais.repositories.UserRepository;
import br.com.plenustech.pesamais.services.exceptions.DataIntegrityException;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(
				"City "+ id +" not found. Type: "+ User.class.getName())
		);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User insert(User obj) {
		obj.setId_user(null);
		return repository.save(obj);
	}
	
	public User update(User obj) {
		findById(obj.getId_user());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("O registro não pode ser excluido, pois o mesmo possui relacionamento!");
		}
	}
	
}
