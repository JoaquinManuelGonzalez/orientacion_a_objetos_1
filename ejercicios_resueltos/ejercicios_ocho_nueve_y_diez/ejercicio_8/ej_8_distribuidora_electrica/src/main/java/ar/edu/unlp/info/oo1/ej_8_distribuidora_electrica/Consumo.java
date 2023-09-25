package ar.edu.unlp.info.oo1.ej_8_distribuidora_electrica;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public double getConsumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return (this.getConsumoEnergiaActiva() * precioKWh);
	}
	
	public double factorDePotencia() {
		double activaSqr = Math.pow(this.getConsumoEnergiaActiva(), 2);
		double reactivaSqr = Math.pow(this.getConsumoEnergiaReactiva(), 2);
		double sumaSqrt = Math.sqrt(activaSqr + reactivaSqr);
		return (this.consumoEnergiaActiva / sumaSqrt);
	}
}
