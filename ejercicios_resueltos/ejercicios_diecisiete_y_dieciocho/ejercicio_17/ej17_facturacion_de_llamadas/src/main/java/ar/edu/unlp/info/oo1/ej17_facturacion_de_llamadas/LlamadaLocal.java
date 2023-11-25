package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaLocal extends LlamadaTelefonica{
	
	public LlamadaLocal(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			double duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe) {
		super(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoLlama);
	}

	public double calcularMontoLlamada() {
		return (1 * super.getDuracionEnMinutos());
	}
}
