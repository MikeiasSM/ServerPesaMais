package br.com.plenustech.pesamais.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.services.validation.PersonUpdate;

@PersonUpdate
public class PersonDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_person;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 80, message = "A campo deve conter entre 5 e 80 caracteres")
	private String name_reason;
	@Length(max = 80, message = "A campo deve conter no máximo 80 caracteres")
	private String surname_fantasy;
	@Length(max = 15, message = "A campo deve conter no máximo 15 caracteres")
	private String cpf_cnpj;
	@Length(max = 15, message = "A campo deve conter no máximo 15 caracteres")
	private String rg_inscr;
	private String fone1;
	private String fone2;
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String contact1;
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String contact2;
	@Email(message = "E-mail inválido")
	private String email;
	@Length(max = 250, message = "A campo deve conter no máximo 250 caracteres")
	private String note;
	private Integer type_person; 
	private Boolean flag_register_cliente;
	private Boolean flag_register_fornecedor;
	private Boolean flag_register_colaborador;
	private Boolean flag_active;
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(Person obj) {
		super();
		this.id_person = obj.getId_person();
		this.name_reason = obj.getName_reason();
		this.surname_fantasy = obj.getSurname_fantasy();
		this.cpf_cnpj = obj.getCpf_cnpj();
		this.rg_inscr = obj.getRg_inscr();
		this.fone1 = obj.getFone1();
		this.fone2 = obj.getFone2();
		this.contact1 = obj.getContact1();
		this.contact2 = obj.getContact2();
		this.email = obj.getEmail();
		this.note = obj.getNote();
		this.type_person = obj.getTypePerson().getCod();
		this.flag_register_cliente = obj.getFlag_register_cliente();
		this.flag_register_fornecedor = obj.getFlag_register_fornecedor();
		this.flag_register_colaborador = obj.getFlag_register_colaborador();
		this.flag_active = obj.getFlag_active();
	}

	public Integer getId_person() {
		return id_person;
	}

	public void setId_person(Integer id_person) {
		this.id_person = id_person;
	}

	public String getName_reason() {
		return name_reason;
	}

	public void setName_reason(String name_reason) {
		this.name_reason = name_reason;
	}

	public String getSurname_fantasy() {
		return surname_fantasy;
	}

	public void setSurname_fantasy(String surname_fantasy) {
		this.surname_fantasy = surname_fantasy;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getRg_inscr() {
		return rg_inscr;
	}

	public void setRg_inscr(String rg_inscr) {
		this.rg_inscr = rg_inscr;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getType_person() {
		return type_person;
	}

	public void setType_person(Integer type_person) {
		this.type_person = type_person;
	}

	public Boolean getFlag_register_cliente() {
		return flag_register_cliente;
	}

	public void setFlag_register_cliente(Boolean flag_register_cliente) {
		this.flag_register_cliente = flag_register_cliente;
	}

	public Boolean getFlag_register_fornecedor() {
		return flag_register_fornecedor;
	}

	public void setFlag_register_fornecedor(Boolean flag_register_fornecedor) {
		this.flag_register_fornecedor = flag_register_fornecedor;
	}

	public Boolean getFlag_register_colaborador() {
		return flag_register_colaborador;
	}

	public void setFlag_register_colaborador(Boolean flag_register_colaborador) {
		this.flag_register_colaborador = flag_register_colaborador;
	}

	public Boolean getFlag_active() {
		return flag_active;
	}

	public void setFlag_active(Boolean flag_active) {
		this.flag_active = flag_active;
	}
	
}
