package br.com.plenustech.pesamais.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.plenustech.pesamais.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_user;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 40, message = "A campo deve conter entre 5 e 40 caracteres")
	private String name;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 1, max = 40, message = "A campo deve conter entre 1 e 40 caracteres")
	private String password;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String email;
	private Boolean active;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		this.id_user = obj.getId_user();
		this.name = obj.getName();
		this.password = obj.getPassword();
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
