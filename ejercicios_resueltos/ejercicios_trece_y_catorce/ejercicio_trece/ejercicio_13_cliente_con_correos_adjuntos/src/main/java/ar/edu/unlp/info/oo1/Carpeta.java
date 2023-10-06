package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Email> getEmails() {
		return new ArrayList<>(this.emails);
	}
	
	public void addEmail(Email email) {
		this.emails.add(email);
	}
	
	public void removeEmail(Email email) {
		this.emails.remove(email);
	}
	
	public Email buscar(String texto) {
		return this.getEmails()
				.stream()
				.filter(email -> email.buscar(texto))
				.findFirst()
				.orElse(null);
	}
	
	public int espacioOcupado() {
		return this.getEmails()
				.stream()
				.mapToInt(email -> email.espacioOcupado())
				.sum();
	}
	
}
