package br.com.plenustech.pesamais.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.domain.dto.PersonDTO;
import br.com.plenustech.pesamais.repositories.PersonRepository;
import br.com.plenustech.pesamais.resources.exceptions.FieldMessage;

public class PersonUpdateValidator implements ConstraintValidator<PersonUpdate, PersonDTO> {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private PersonRepository personrepo;
	
	@Override
	public void initialize(PersonUpdate ann) {
	}

	@Override
	public boolean isValid(PersonDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uId = Integer.parseInt(map.get("id"));
		List<FieldMessage> list = new ArrayList<>();

		Person aux = personrepo.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId_person().equals(uId)) {
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
