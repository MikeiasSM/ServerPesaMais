package br.com.plenustech.pesamais.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.domain.dto.PersonWithAddressDTO;
import br.com.plenustech.pesamais.domain.enums.TypePerson;
import br.com.plenustech.pesamais.repositories.PersonRepository;
import br.com.plenustech.pesamais.resources.exceptions.FieldMessage;
import br.com.plenustech.pesamais.services.validation.utils.BR;

public class PersonInsertValidator implements ConstraintValidator<PersonInsert, PersonWithAddressDTO> {

	@Autowired
	private PersonRepository personrepo;
	
	@Override
	public void initialize(PersonInsert ann) {
	}

	@Override
	public boolean isValid(PersonWithAddressDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getType_person().equals(TypePerson.FISICA.getCod()) && !BR.isValidCPF(objDto.getCpf_cnpj())) {
			list.add(new FieldMessage("cpf_cnpj", "CPF Inválido"));
		}
		
		if(objDto.getType_person().equals(TypePerson.JURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpf_cnpj())) {
			list.add(new FieldMessage("cpf_cnpj", "CNPJ Inválido"));
		}
		
		Person aux = personrepo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "E-mail já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
