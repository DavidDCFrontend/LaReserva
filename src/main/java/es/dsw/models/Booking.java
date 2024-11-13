package es.dsw.models;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	
	private int numAdults;
	private int numChildren;
	private String type;
	private String fEntrada;
	private String fSalida;
	List<String> errors = new ArrayList<>();
	
	public Booking() {
		
	}

	public int getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getfEntrada() {
		return fEntrada;
	}

	public void setfEntrada(String fEntrada) {
		this.fEntrada = fEntrada;
	}

	public String getfSalida() {
		return fSalida;
	}

	public void setfSalida(String fSalida) {
		this.fSalida = fSalida;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(String error) {
		this.errors.add(error);
	}
}
