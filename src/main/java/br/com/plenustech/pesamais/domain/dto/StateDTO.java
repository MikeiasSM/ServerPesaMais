package br.com.plenustech.pesamais.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.plenustech.pesamais.domain.State;

public class StateDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_state;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String name;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String uf;

	public StateDTO() {
		
	}
	
	public StateDTO(State obj) {
		this.id_state = obj.getId_state();
		this.name = obj.getName();
		this.uf = obj.getUf();
	}

	public Integer getId_state() {
		return id_state;
	}

	public void setId_state(Integer id_state) {
		this.id_state = id_state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
