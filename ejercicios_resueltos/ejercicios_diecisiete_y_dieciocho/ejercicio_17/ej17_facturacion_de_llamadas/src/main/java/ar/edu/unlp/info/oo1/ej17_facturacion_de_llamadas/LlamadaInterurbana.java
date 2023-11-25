package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends LlamadaTelefonica{
	
	private double distanciaEnKilometros;

	public LlamadaInterurbana(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			double duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			double distanciaEnKilometros) {
		super(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe);
		this.distanciaEnKilometros = distanciaEnKilometros;
	}

	public double getDistanciaEnKilometros() {
		return this.distanciaEnKilometros;
	}

	public double calcularMontoLlamada() {
		double monto;
		if (this.getDistanciaEnKilometros() < 100) {
			monto = 5 + (2 *super.getDuracionEnMinutos());
		} else if (this.getDistanciaEnKilometros() <= 500) {
			monto = 5 + (2.5 * super.getDuracionEnMinutos());
		} else {
			monto = 5 + (3 * super.getDuracionEnMinutos());
		}
		return monto;
	}
	
}
