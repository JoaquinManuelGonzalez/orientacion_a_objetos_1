package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends LlamadaTelefonica{

	private String paisOrigen;
	private String paisDestino;

	public LlamadaInternacional(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			double duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			String paisOrigen,
			String paisDestino) {
		super(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public double calcularMontoLlamada() {
		double monto;
		if (!(super.getHoraComienzo().isBefore(LocalTime.of(8, 0)) 
				|| 
			super.getHoraComienzo().isAfter(LocalTime.of(19, 59)))) {
			monto = (4 * super.getDuracionEnMinutos());
		} else {
			monto = (3 * super.getDuracionEnMinutos());
		}
		return monto;
	}
	
}
