package br.com.plenustech.pesamais.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_person;
	private String name_reason;
	private String surname_fantasy;
	private String cpf_cnpj;
	private String rg_inscr;
	private String fone1;
	private String fone2;
	private String contact1;
	private String contact2;
	private String email;
	private String note;
	private Boolean flag_person_fisica;
	private Boolean flag_person_juridica;
	private Boolean flag_register_cliente;
	private Boolean flag_register_fornecedor;
	private Boolean flag_register_colaborador;
	private Boolean flag_active;
	@JsonManagedReference
	@OneToMany(mappedBy = "person")
	private List<Address> addresses = new ArrayList<>();

	public Person () {
		
	}
	
	public Person(Integer id_person, String name_reason, String surname_fantasy, String cpf_cnpj, String rg_inscr, String fone1, String fone2, String contact1, 
				  String contact2, String email, String note, Boolean flag_person_fisica, Boolean flag_person_juridica, Boolean flag_register_cliente, Boolean flag_register_fornecedor, 
				  Boolean flag_register_colaborador, Boolean flag_active) {
		this.id_person = id_person;
		this.name_reason = name_reason;
		this.surname_fantasy = surname_fantasy;
		this.cpf_cnpj = cpf_cnpj;
		this.rg_inscr = rg_inscr;
		this.fone1 = fone1;
		this.fone2 = fone2;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.email = email;
		this.note = note;
		this.flag_person_fisica = flag_person_fisica;
		this.flag_person_juridica = flag_person_juridica;
		this.flag_register_cliente = flag_register_cliente;
		this.flag_register_fornecedor = flag_register_fornecedor;
		this.flag_register_colaborador = flag_register_colaborador;
		this.flag_active = flag_active;
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

	public Boolean getFlag_person_fisica() {
		return flag_person_fisica;
	}

	public void setFlag_person_fisica(Boolean flag_person_fisica) {
		this.flag_person_fisica = flag_person_fisica;
	}

	public Boolean getFlag_person_juridica() {
		return flag_person_juridica;
	}

	public void setFlag_person_juridica(Boolean flag_person_juridica) {
		this.flag_person_juridica = flag_person_juridica;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_person);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id_person, other.id_person);
	}
	
}
