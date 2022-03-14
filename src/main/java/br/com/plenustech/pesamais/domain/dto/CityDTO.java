package br.com.plenustech.pesamais.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.plenustech.pesamais.domain.City;

public class CityDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id_city;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 1, max = 40, message = "A campo deve conter entre 1 e 40 caracteres")
	private String name;
	private Integer id_state;

	public CityDTO() {

	}

	public CityDTO(City obj) {
		this.id_city = obj.getId_city();
		this.name = obj.getName();
		this.id_state = obj.getState().getId_state();
	}

	public Integer getId_city() {
		return id_city;
	}

	public void setId_city(Integer id_city) {
		this.id_city = id_city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_state() {
		return id_state;
	}

	public void setId_state(Integer id_state) {
		this.id_state = id_state;
	}
	
	
}
