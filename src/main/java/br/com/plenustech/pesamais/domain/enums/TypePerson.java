package br.com.plenustech.pesamais.domain.enums;

public enum TypePerson {
	
	FISICA(1,"FISICA"),
	JURIDICA(2,"JURIDICA");

	private int cod;
	private String description;
	
	private TypePerson(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static TypePerson toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TypePerson x : TypePerson.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: "+cod);
	}
}
