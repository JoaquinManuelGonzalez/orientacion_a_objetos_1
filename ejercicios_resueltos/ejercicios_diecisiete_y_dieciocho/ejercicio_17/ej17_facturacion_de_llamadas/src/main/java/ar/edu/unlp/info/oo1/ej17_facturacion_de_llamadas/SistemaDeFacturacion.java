package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeFacturacion {
	
	private List<String> numerosDisponibles;
	private List<Cliente> clientes;
	
	public SistemaDeFacturacion() {
		this.numerosDisponibles = new ArrayList<String>();
		this.clientes = new ArrayList<Cliente>();
	}

	public List<String> getNumerosDisponibles() {
		return numerosDisponibles;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void addNumeroTelefono (String numero) {
		this.numerosDisponibles.add(numero);
	}
	
	public void removeNumeroTelefono (String numero) {
		this.numerosDisponibles.remove(numero);
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public Cliente registrarPersonaFisica(String nombre,
			String apellido,
			String dni) {
		Cliente c = null;
		if (!this.getNumerosDisponibles().isEmpty()) {
			String numeroTelefono = this.getNumerosDisponibles().stream().findAny().orElse(null);
			c = new PersonaFisica(nombre,
					apellido, 
					numeroTelefono, 
					dni);
			this.addCliente(c);
			this.removeNumeroTelefono(numeroTelefono);
		}
		return c;
	}
	
	public Cliente registrarPersonaJuridica(String nombre,
			String apellido,
			String cuit,
			String tipo) {
		Cliente c = null;
		if (!this.getNumerosDisponibles().isEmpty()) {
			String numeroTelefono = this.getNumerosDisponibles().stream().findAny().orElse(null);
			c = new PersonaJuridica(nombre,
					apellido, 
					numeroTelefono, 
					cuit,
					tipo);
			this.addCliente(c);
			this.removeNumeroTelefono(numeroTelefono);
		}
		return c;
	}
	
	private Cliente conseguirCliente(String numeroTelefonoLlama) {
		return this.getClientes()
				.stream()
				.filter(cliente -> cliente.getNumeroDeTelefono().equals(numeroTelefonoLlama))
				.findFirst()
				.orElse(null);
	}
	
	public LlamadaTelefonica registrarLlamadaLocal(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe) {
		Cliente c = this.conseguirCliente(numeroTelefonoLlama);
		return c.registrarLlamadaLocal(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe);
	}
	
	public LlamadaTelefonica registrarLlamadaLocal(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			double distanciaEnKilometros) {
		Cliente c = this.conseguirCliente(numeroTelefonoLlama);
		return c.registrarLlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				duracionEnMinutos);
	}
	
	public LlamadaTelefonica registrarLlamadaInternacional(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			String paisOrigen,
			String paisDestino) {
		Cliente c = this.conseguirCliente(numeroTelefonoLlama);
		return c.registrarLlamadaInternacional(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
	}
	
	public void facturarLlamadaDeUnCliente(Cliente cliente,
			LocalDate fechaFacturacion,
			LocalDate fechaInicioPeriodo,
			LocalDate fechaFinPeriodo) {
		cliente.facturarLlamadaDeUnCliente(fechaFacturacion,
				fechaInicioPeriodo,
				fechaFinPeriodo);
	}
	
}
