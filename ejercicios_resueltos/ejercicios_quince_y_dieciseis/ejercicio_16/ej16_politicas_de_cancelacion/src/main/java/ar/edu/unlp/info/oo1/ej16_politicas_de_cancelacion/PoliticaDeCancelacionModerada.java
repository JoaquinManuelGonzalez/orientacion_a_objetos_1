package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaDeCancelacionModerada implements PoliticaDeCancelacion{

	@Override
	public double calcularMontoAReembolsar(LocalDate fechaTentativa, LocalDate fechaInicioReserva,
			double montoReserva) {
		double montoAReembolsar = 0;
		if (fechaTentativa.isBefore(fechaInicioReserva)) {
			int diferencia = (int) ChronoUnit.DAYS.between(fechaTentativa, fechaInicioReserva);
			if (diferencia >= 7) {
				montoAReembolsar = montoReserva;
			} else if (diferencia >= 2) {
				montoAReembolsar = (montoReserva / 2);
			}
		}
		return montoAReembolsar;
	}

}
