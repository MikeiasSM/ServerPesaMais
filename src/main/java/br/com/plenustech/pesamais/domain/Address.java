package br.com.plenustech.pesamais.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plenustech.pesamais.domain.enums.TypeAddress;

@Entity
@Table(name = "ENDERECO")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_address;
	private String description;
	private Integer type_address;
	private String public_place;
	private String number;
	private String district;
	private String complement;
	private String cep;
	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_person")
	private Person person;
	
	public Address() {
		
	}

	public Address(Integer id_address, String description, TypeAddress type_address, String public_place, String number,
			       String district, String complement, String cep, City city, Person person) {
		super();
		this.id_address = id_address;
		this.description = description;
		this.type_address = type_address.getCod();
		this.public_place = public_place;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.cep = cep;
		this.city = city;
		this.person = person;
	}

	public Integer getId_address() {
		return id_address;
	}

	public void setId_address(Integer id_address) {
		this.id_address = id_address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeAddress getType_address() {
		return TypeAddress.toEnum(type_address);
	}

	public void setType_address(TypeAddress type_address) {
		this.type_address = type_address.getCod();
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_address);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id_address, other.id_address);
	}
		
}
