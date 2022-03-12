package br.com.plenustech.pesamais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plenustech.pesamais.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
