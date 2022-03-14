package br.com.plenustech.pesamais.domain.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.plenustech.pesamais.services.validation.PersonInsert;

@PersonInsert
public class PersonWithAddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//PERSON
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
	@Column(unique=true)
	private String email;
	
	@Length(max = 250, message = "A campo deve conter no máximo 250 caracteres")
	private String note;
	private Integer type_person; 
	private Boolean flag_register_cliente;
	private Boolean flag_register_fornecedor;
	private Boolean flag_register_colaborador;
	private Boolean flag_active;
	
	//ADDRESS
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String description;
	private Integer type_address;
	
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String public_place;
	
	@Length(max = 5, message = "A campo deve conter no máximo 5 caracteres")
	private String number;
	private String district;
	
	@Length(max = 40, message = "A campo deve conter no máximo 40 caracteres")
	private String complement;
	
	@Length(max = 8, message = "A campo deve conter no máximo 8 caracteres")
	private String cep;

	//CIDADE
	private Integer id_city;
	
	public PersonWithAddressDTO() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType_address() {
		return type_address;
	}

	public void setType_address(Integer type_address) {
		this.type_address = type_address;
	}

	public String getPublic_place() {
		return public_place;
	}

	public void setPublic_place(String public_place) {
		this.public_place = public_place;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId_city() {
		return id_city;
	}

	public void setId_city(Integer id_city) {
		this.id_city = id_city;
	}
	
}
