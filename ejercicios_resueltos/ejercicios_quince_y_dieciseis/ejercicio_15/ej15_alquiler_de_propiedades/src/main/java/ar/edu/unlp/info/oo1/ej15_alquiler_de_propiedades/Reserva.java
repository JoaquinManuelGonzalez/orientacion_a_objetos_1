package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import java.time.LocalDate;

public class Reserva {
	
	private int cantidadDeNoches;
	private Usuario inquilino;
	private Propiedad propiedadReservada;
	private DateLapse dateLapse;
	
	public Reserva (Propiedad propiedadReservada, 
			DateLapse periodo,
			Usuario inquilino) {
		this.propiedadReservada = propiedadReservada;
		this.dateLapse = periodo;
		this.inquilino = inquilino;
		this.cantidadDeNoches = this.calcularCantidadDeNoches(periodo);
	}
	
	public int getCantidadDeNoches () {
		return this.cantidadDeNoches;
	}
	
	public DateLapse getDateLapse () {
		return this.dateLapse;
	}
	
	public Usuario getInquilino () {
		return this.inquilino;
	}
	
	public Propiedad getPropiedadReservada () {
		return this.propiedadReservada;
	}
	
	public int calcularCantidadDeNoches(DateLapse periodo) {
		return periodo.sizeInDays();
	}
	
	public double precioReserva () {
		return (this.propiedadReservada.getPrecioPorNoche() * this.getCantidadDeNoches());
	}
	
	public boolean chequearFechaPosterior () {
		return this.getDateLapse().dateBeforeLapse(LocalDate.now());
	}
	
	public boolean estaOverlap (DateLapse periodo) {
		return (periodo.overlaps(this.getDateLapse()))
				|| 
				(this.getDateLapse().overlaps(periodo));
	}
	
}
