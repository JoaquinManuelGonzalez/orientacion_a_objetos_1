package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class LlamadaTelefonica {

	private LocalDate fechaComienzo;
	private LocalTime horaComienzo;
	private double duracionEnMinutos;
	private String numeroTelefonoLlama;
	private String numeroTelefonoRecibe;
	
	public LlamadaTelefonica (LocalDate fechaComienzo,
			LocalTime horaComienzo,
			double duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe) {
		this.fechaComienzo = fechaComienzo;
		this.horaComienzo = horaComienzo;
		this.duracionEnMinutos = duracionEnMinutos;
		this.numeroTelefonoLlama = numeroTelefonoLlama;
		this.numeroTelefonoRecibe = numeroTelefonoRecibe;
	}

	public LocalDate getFechaComienzo() {
		return fechaComienzo;
	}

	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}

	public double getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	public String getNumeroTelefonoLlama() {
		return numeroTelefonoLlama;
	}

	public String getNumeroTelefonoRecibe() {
		return numeroTelefonoRecibe;
	}
	
	public abstract double calcularMontoLlamada();
}
