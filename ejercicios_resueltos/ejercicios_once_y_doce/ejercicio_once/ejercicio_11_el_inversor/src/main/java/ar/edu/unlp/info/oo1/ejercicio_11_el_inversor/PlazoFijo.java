package ar.edu.unlp.info.oo1.ejercicio_11_el_inversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo (LocalDate fechaDeConstitucion, 
			double montoDepositado, 
			double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public LocalDate getFechaDeConstitucion() {
		return this.fechaDeConstitucion;
	}
	
	public double getMontoDepositado() {
		return this.montoDepositado;
	}
	
	public double getPorcentajeDeInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}

	public double valorActual() {
		double diferencia = this.calcularDiferencia(LocalDate.now());
		double porcentaje = this.calcularPorcentaje();
		return (this.getMontoDepositado() + (porcentaje * diferencia));
	}
	
	private double calcularDiferencia(LocalDate fechaActual) {
		return ChronoUnit.DAYS.between(this.getFechaDeConstitucion(), fechaActual);
	}
	
	private double calcularPorcentaje() {
		return ((this.getMontoDepositado() * this.getPorcentajeDeInteresDiario()) / 100);
	}
}
