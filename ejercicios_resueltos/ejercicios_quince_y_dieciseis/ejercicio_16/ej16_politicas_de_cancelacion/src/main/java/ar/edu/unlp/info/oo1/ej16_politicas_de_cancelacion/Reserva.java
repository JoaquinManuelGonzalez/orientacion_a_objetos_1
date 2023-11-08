package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

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
	
	private int calcularCantidadDeNoches(DateLapse periodo) {
		return periodo.sizeInDays();
	}
	
	public double calcularPrecioDeReserva () {
		return (this.propiedadReservada.getPrecioPorNoche() * this.getCantidadDeNoches());
	}
	
	public boolean chequearFechaPosterior () {
		return this.getDateLapse().dateBeforeLapse(LocalDate.now());
	}
	
	public boolean estaOverlap (DateLapse periodo) {
		return this.getDateLapse().overlaps(periodo);
	}
	
	public double calcularMontoAReembolsar(PoliticaDeCancelacion politica, LocalDate fechaTentativa) {
		return politica.calcularMontoAReembolsar(fechaTentativa, this.getDateLapse().getFrom(), this.calcularPrecioDeReserva());
	}
	
}
