package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.time.LocalDate;

public class PoliticaDeCancelacionEstricta implements PoliticaDeCancelacion{

	@Override
	public double calcularMontoAReembolsar(LocalDate fechaTentativa, LocalDate fechaInicioReserva,
			double montoReserva) {
		return 0;
	}

}
