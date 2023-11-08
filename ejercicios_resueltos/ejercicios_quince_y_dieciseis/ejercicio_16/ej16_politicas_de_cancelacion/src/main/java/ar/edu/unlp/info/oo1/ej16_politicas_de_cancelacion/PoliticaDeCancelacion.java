package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.time.LocalDate;

public interface PoliticaDeCancelacion {

	public double calcularMontoAReembolsar (LocalDate fechaTentativa,
			LocalDate fechaInicioReserva,
			double montoReserva);
}
