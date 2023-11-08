package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombreDeUsuario;
	private String dni;
	private String direccion;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;
	
	public Usuario (String nombreDeUsuario,
			String dni,
			String direccion) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.dni = dni;
		this.direccion = direccion;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public Propiedad crearReserva (String nombre,
			String descripcion,
			String direccion,
			double precioPorNoche,
			PoliticaDeCancelacion politicaDeCancelacion) {
		Propiedad nuevaPropiedad = new Propiedad (nombre, 
				descripcion, 
				direccion, 
				precioPorNoche,
				politicaDeCancelacion);
		this.addPropiedad(nuevaPropiedad);
		return nuevaPropiedad;
	}
	
	public List<Reserva> getReservas () {
		return new ArrayList<Reserva>(this.reservas);
	}
	
	public List<Propiedad> getPropiedades () {
		return new ArrayList<Propiedad>(this.propiedades);
	}
	
	public void addReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void removeReserva (Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public void addPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void removePropiedad (Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles (DateLapse periodo) {
		return this.getPropiedades()
				.stream()
				.filter(propiedad -> propiedad.buscarDisponibilidad(periodo))
				.toList();
	}
	
	public double calcularIngresosEnUnPeriodo (DateLapse periodo) {
		return this.getPropiedades()
				.stream()
				.mapToDouble(propiedad -> propiedad.calcularIngresosEnUnPeriodo(periodo))
				.sum();
	}
	
}
