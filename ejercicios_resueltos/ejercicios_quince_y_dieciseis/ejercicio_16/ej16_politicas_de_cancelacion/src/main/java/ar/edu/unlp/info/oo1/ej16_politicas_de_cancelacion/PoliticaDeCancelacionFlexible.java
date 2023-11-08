package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.time.LocalDate;

public class PoliticaDeCancelacionFlexible implements PoliticaDeCancelacion{

	@Override
	public double calcularMontoAReembolsar(LocalDate fechaTentativa, LocalDate fechaInicioReserva,
			double montoReserva) {
		return montoReserva;
	}

}
