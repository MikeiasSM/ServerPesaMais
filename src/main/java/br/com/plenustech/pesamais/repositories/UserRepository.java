package br.com.plenustech.pesamais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plenustech.pesamais.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
