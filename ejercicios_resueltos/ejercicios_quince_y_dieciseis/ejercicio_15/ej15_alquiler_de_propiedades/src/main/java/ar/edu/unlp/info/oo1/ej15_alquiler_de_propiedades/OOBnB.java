package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OOBnB {
	
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public OOBnB () {
		this.usuarios = new ArrayList<>();
		this.propiedades = new ArrayList<>();
	}
	
	public void addUsuario (Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void addPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public List<Propiedad> getPropiedades() {
		return new ArrayList<Propiedad>(this.propiedades);
	}
	
	public Usuario registrarUsuario (String nombre,
			String direccion,
			String dni) {
		Usuario nuevoUsuario = new Usuario(nombre, dni, direccion);
		this.addUsuario(nuevoUsuario);
		return nuevoUsuario;
	}
	
	public Propiedad registrarPropiedad (String nombre,
			String descripcion,
			double precioPorNoche,
			String direccion,
			Usuario propietario) {
		Propiedad nuevaPropiedad = new Propiedad (nombre, 
				descripcion, 
				direccion, 
				precioPorNoche, 
				propietario);
		this.addPropiedad(nuevaPropiedad);
		return nuevaPropiedad;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles (DateLapse periodo) {
		return this.getPropiedades()
				.stream()
				.filter(propiedad -> propiedad.buscarDisponibilidad(periodo))
				.collect(Collectors.toList());
	}
	
	public Reserva hacerReserva (Propiedad propiedad, 
			DateLapse periodo, 
			Usuario inquilino) {
		Reserva nuevaReserva = null;
		if (propiedad.buscarDisponibilidad(periodo)) {
			nuevaReserva = new Reserva(propiedad, periodo, inquilino);
			inquilino.addReserva(nuevaReserva);
			propiedad.addReserva(nuevaReserva);
		}
		return nuevaReserva;
	}
	
	public double calcularPrecioDeReserva (Reserva reserva) {
		return reserva.precioReserva();
	}
	
	public void eliminarReserva (Reserva reserva) {
		if (reserva.chequearFechaPosterior()) {
			reserva.getInquilino().removeReserva(reserva);
			reserva.getPropiedadReservada().removeReserva(reserva);
		}
	}
	
	public List<Reserva> obtenerReservasDeUnUsuario (Usuario usuario) {
		return usuario.getReservas();
	}
	
	public double calcularIngresosDeUnPropietario (Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresosEnUnPeriodo(periodo);
	}
	
}
