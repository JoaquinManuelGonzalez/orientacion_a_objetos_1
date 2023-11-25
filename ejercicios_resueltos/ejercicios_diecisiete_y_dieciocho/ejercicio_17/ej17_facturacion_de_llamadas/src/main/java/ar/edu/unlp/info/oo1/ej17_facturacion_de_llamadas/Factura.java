package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;

public class Factura {
	
	private LocalDate fechaFacturacion;
	private LocalDate fechaInicioPeriodo;
	private LocalDate fechaFinPeriodo;
	private double montoTotal;
	
	public Factura (LocalDate fechaFacturacion,
			LocalDate fechaInicioPeriodo,
			LocalDate fechaFinPeriodo,
			double montoTotal) {
		this.fechaFacturacion = fechaFacturacion;
		this.fechaInicioPeriodo = fechaInicioPeriodo;
		this.fechaFinPeriodo = fechaFinPeriodo;
		this.montoTotal = montoTotal;
	}

	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public LocalDate getFechaInicioPeriodo() {
		return fechaInicioPeriodo;
	}
	
	public LocalDate getFechaFinPeriodo() {
		return fechaFinPeriodo;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

}
