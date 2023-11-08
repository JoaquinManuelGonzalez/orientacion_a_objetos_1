package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	
	private String direccion;
	private String descripcion;
	private String nombre;
	private PoliticaDeCancelacion politica;
	private double precioPorNoche;
	private List<Reserva> reservas;
	
	public Propiedad (String nombre, 
			String descripcion, 
			String direccion, 
			double precioPorNoche,
			PoliticaDeCancelacion politicaDeCancelacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioPorNoche = precioPorNoche;
		this.politica = politicaDeCancelacion;
		this.reservas = new ArrayList<>();
	}
	
	public double getPrecioPorNoche () {
		return this.precioPorNoche;
	}
	
	public List<Reserva> getReservas () {
		return new ArrayList<Reserva>(this.reservas);
	}
	
	public String getDireccion() {
		return direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public PoliticaDeCancelacion getPolitica() {
		return this.politica;
	}
	
	public void addReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void removeReserva (Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public boolean buscarDisponibilidad (DateLapse periodo) {
		return this.getReservas()
				.stream()
				.noneMatch(reserva -> reserva.estaOverlap(periodo));
	}
	
	public double calcularIngresosEnUnPeriodo (DateLapse periodo) {
		return this.getReservas()
				.stream()
				.filter(reserva -> reserva.estaOverlap(periodo))
				.mapToDouble(reserva -> reserva.calcularPrecioDeReserva())
				.sum();
	}
	
	public double calcularMontoAReembolsar (Reserva reserva, LocalDate fechaTentativa) {
		return reserva.calcularMontoAReembolsar(this.getPolitica(), fechaTentativa);
	}
	
}
