package br.com.plenustech.pesamais.domain.dto;

import br.com.plenustech.pesamais.domain.User;

public class UserDTO {

	private Integer id_user;
	private String name;
	private String email;
	private Boolean active;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		this.id_user = obj.getId_user();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.active = obj.getActive();
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
