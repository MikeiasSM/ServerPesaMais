package br.com.plenustech.pesamais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.User;
import br.com.plenustech.pesamais.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.orElse(null);
	}
}
