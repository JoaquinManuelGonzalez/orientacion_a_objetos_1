package ar.edu.unlp.info.oo1.ej_5_genealogia_salvaje;

import java.time.LocalDate;

public class Mamifero {
	
	private String identificador;
	private String especie;
	private LocalDate fechaDeNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
		this.setFechaDeNacimiento(LocalDate.now());
	}
	
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return this.especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Mamifero getPadre() {
		return this.padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		Mamifero abuelo_materno = null;
		if (this.getMadre() != null) {
			abuelo_materno = this.getMadre().getPadre();
		}
		return abuelo_materno;
	}
	
	public Mamifero getAbuelaMaterna() {
		Mamifero abuela_materna = null;
		if (this.getMadre() != null) {
			abuela_materna = this.getMadre().getMadre();
		}
		return abuela_materna;
	}
	
	public Mamifero getAbueloPaterno() {
		Mamifero abuelo_paterno = null;
		if (this.getMadre() != null) {
			abuelo_paterno = this.getPadre().getPadre();
		}
		return abuelo_paterno;
	}
	
	public Mamifero getAbuelaPaterna() {
		Mamifero abuela_paterna = null;
		if (this.getMadre() != null) {
			abuela_paterna = this.getPadre().getMadre();
		}
		return abuela_paterna;
	}
	
	public boolean tieneComoAncestroA(Mamifero ancestro) {
		boolean tieneAncestro = false;
		if ((this.getMadre() == ancestro) || (this.getPadre() == ancestro)) {
			tieneAncestro = true;
		} else {
			if (this.getMadre() != null) {
				tieneAncestro = this.getMadre().tieneComoAncestroA(ancestro);
			}
			if ((!tieneAncestro) && (this.getPadre() != null)) {
				tieneAncestro = this.getPadre().tieneComoAncestroA(ancestro);
			}
		}
		return tieneAncestro;
	}
}
