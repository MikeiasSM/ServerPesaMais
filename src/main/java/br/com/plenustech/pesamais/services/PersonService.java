package br.com.plenustech.pesamais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.plenustech.pesamais.domain.Address;
import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.domain.dto.PersonDTO;
import br.com.plenustech.pesamais.domain.dto.PersonWithAddressDTO;
import br.com.plenustech.pesamais.domain.enums.TypeAddress;
import br.com.plenustech.pesamais.domain.enums.TypePerson;
import br.com.plenustech.pesamais.repositories.AddressRepository;
import br.com.plenustech.pesamais.repositories.PersonRepository;
import br.com.plenustech.pesamais.services.exceptions.DataIntegrityException;
import br.com.plenustech.pesamais.services.exceptions.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	@Autowired
	private AddressRepository addressrepo;
	
	public Person findById(Integer id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ObjectNotFoundException(
				"Person "+ id +" not found. Type: "+ Person.class.getName())
		);
	}

	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Page<Person> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Person insert(Person obj) {
		obj.setId_person(null);
		repository.save(obj);
		addressrepo.saveAll(obj.getAddresses());
		return obj;
	}
	
	public Person update(Person obj) {
		Person newObj = findById(obj.getId_person());
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
	
	public Person fromDTO(PersonDTO personDTO) {
		return new Person(
				personDTO.getId_person(), personDTO.getName_reason(), personDTO.getSurname_fantasy(), personDTO.getCpf_cnpj(), personDTO.getRg_inscr(),
				personDTO.getFone1(), personDTO.getFone2(), personDTO.getContact1(), personDTO.getContact2(), personDTO.getEmail(), personDTO.getNote(), TypePerson.toEnum(personDTO.getType_person()), 
				personDTO.getFlag_register_cliente(), personDTO.getFlag_register_fornecedor(), personDTO.getFlag_register_colaborador(), personDTO.getFlag_active()
		);
	}
	
	public Person fromDTO(PersonWithAddressDTO personDTO) {
		Person person = new Person(
				personDTO.getId_person(), personDTO.getName_reason(), personDTO.getSurname_fantasy(), personDTO.getCpf_cnpj(), personDTO.getRg_inscr(),
				personDTO.getFone1(), personDTO.getFone2(), personDTO.getContact1(), personDTO.getContact2(), personDTO.getEmail(), personDTO.getNote(), TypePerson.toEnum(personDTO.getType_person()), 
				personDTO.getFlag_register_cliente(), personDTO.getFlag_register_fornecedor(), personDTO.getFlag_register_colaborador(), personDTO.getFlag_active()
		);
		
		City city = new City(personDTO.getId_city(), null, null);
		
		Address address = new Address(null, personDTO.getDescription(), TypeAddress.toEnum(personDTO.getType_address()), personDTO.getPublic_place(), personDTO.getNumber(), 
				personDTO.getDistrict(), personDTO.getComplement(), personDTO.getCep(), city, person);
		
		person.getAddresses().add(address);
		
		return person;
	}
	
	private void updateData(Person newObj, Person obj) {
		newObj.setId_person(obj.getId_person());
		newObj.setName_reason(obj.getName_reason());
		newObj.setSurname_fantasy(obj.getSurname_fantasy());
		newObj.setCpf_cnpj(obj.getCpf_cnpj());
		newObj.setRg_inscr(obj.getRg_inscr());
		newObj.setFone1(obj.getFone1());
		newObj.setFone2(obj.getFone2());
		newObj.setContact1(obj.getContact1());
		newObj.setContact2(obj.getContact2());
		newObj.setEmail(obj.getEmail());
		newObj.setNote(obj.getNote());
		newObj.setTypePerson(obj.getTypePerson());
		newObj.setFlag_register_cliente(obj.getFlag_register_cliente());
		newObj.setFlag_register_fornecedor(obj.getFlag_register_fornecedor());
		newObj.setFlag_register_colaborador(obj.getFlag_register_colaborador());
		newObj.setFlag_active(obj.getFlag_active());
	}
}
