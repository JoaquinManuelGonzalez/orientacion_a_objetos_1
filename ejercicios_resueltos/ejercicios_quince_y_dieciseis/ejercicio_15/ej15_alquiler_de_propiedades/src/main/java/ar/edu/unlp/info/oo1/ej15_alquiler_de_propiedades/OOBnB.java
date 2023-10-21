package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import java.util.ArrayList;
import java.util.List;

public class OOBnB {
	
	private List<Usuario> usuarios;
	
	public OOBnB () {
		this.usuarios = new ArrayList<>();
	}
	
	public void addUsuario (Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Usuario> getUsuarios () {
		return new ArrayList<Usuario>(this.usuarios);
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
		Propiedad nuevaPropiedad = propietario.crearReserva(nombre, descripcion, direccion, precioPorNoche);
		return nuevaPropiedad;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles (DateLapse periodo) {
		return this.getUsuarios()
				.stream()
				.flatMap(usuario -> usuario.buscarPropiedadesDisponibles(periodo).stream())
				.toList();
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
	
	public void eliminarReserva (Reserva reserva) {
		if (reserva.chequearFechaPosterior()) {
			reserva.getInquilino().removeReserva(reserva);
			reserva.getPropiedadReservada().removeReserva(reserva);
		}
	}
	
	public double calcularPrecioDeReserva (Reserva reserva) {
		return reserva.calcularPrecioDeReserva();
	}
	
	public List<Reserva> obtenerReservasDeUnUsuario (Usuario usuario) {
		return usuario.getReservas();
	}
	
	public double calcularIngresosDeUnPropietario (Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresosEnUnPeriodo(periodo);
	}
	
}
