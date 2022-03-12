package br.com.plenustech.pesamais.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estate;
	private String name;
	private String uf;
	
	public State() {
		super();
	}
	
	public State(Integer id_estate, String name, String uf) {
		super();
		this.id_estate = id_estate;
		this.name = name;
		this.uf = uf;
	}
	
	public Integer getId_estate() {
		return id_estate;
	}
	
	public void setId_estate(Integer id_estate) {
		this.id_estate = id_estate;
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

	@Override
	public int hashCode() {
		return Objects.hash(id_estate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(id_estate, other.id_estate);
	}
	
}
