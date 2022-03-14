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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ESTADO")
public class State implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_state;
	private String name;
	private String uf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private List<City> cities = new ArrayList<>();
	
	public State() {
		super();
	}
	
	public State(Integer id_state, String name, String uf) {
		super();
		this.id_state = id_state;
		this.name = name;
		this.uf = uf;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_state);
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
		return Objects.equals(id_state, other.id_state);
	}
	
}
