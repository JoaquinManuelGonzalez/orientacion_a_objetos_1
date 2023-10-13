package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	
	private String direccion;
	private String descripcion;
	private String nombre;
	private double precioPorNoche;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad (String nombre, 
			String descripcion, 
			String direccion, 
			double precioPorNoche,
			Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioPorNoche = precioPorNoche;
		this.propietario = propietario;
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

	public Usuario getPropietario() {
		return propietario;
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
				.mapToDouble(reserva -> reserva.precioReserva())
				.sum();
	}
	
}
