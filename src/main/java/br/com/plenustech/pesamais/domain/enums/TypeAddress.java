package br.com.plenustech.pesamais.domain.enums;

public enum TypeAddress {
	
	RURAL(1,"RURAL"),
	COMERCIAL(2,"COMERCIAL"),
	RESIDENCIAL(3,"RESIDENCIAL"),
	OUTROS(4,"OUTROS");

	private int cod;
	private String description;
	
	private TypeAddress(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static TypeAddress toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TypeAddress x : TypeAddress.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: "+cod);
	}
}
