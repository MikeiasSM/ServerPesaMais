package br.com.plenustech.pesamais.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_city;
	private String name;
	@ManyToOne
	@JoinColumn(name="id_state", nullable = false)
	private State state;
	
	public City() {
		
	}

	public City(Integer id_city, String name, State state) {
		super();
		this.id_city = id_city;
		this.name = name;
		this.state = state;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(id_city, other.id_city);
	}

}
