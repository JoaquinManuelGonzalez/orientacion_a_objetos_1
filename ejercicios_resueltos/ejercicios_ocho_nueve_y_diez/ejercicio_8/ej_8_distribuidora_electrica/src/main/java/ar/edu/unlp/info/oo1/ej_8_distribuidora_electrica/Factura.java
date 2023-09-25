package ar.edu.unlp.info.oo1.ej_8_distribuidora_electrica;

import java.time.LocalDate;

public class Factura {
	
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
	}
	
	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public double montoTotal() {
		double descuentoCalculado = ((this.getMontoEnergiaActiva() * this.getDescuento()) / 100);
		return (this.montoEnergiaActiva - descuentoCalculado);
	}
}
