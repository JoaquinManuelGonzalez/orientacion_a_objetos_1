package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	private String nombre;
	private String direccion;
	private String numeroDeTelefono;
	private List<LlamadaTelefonica> llamadas;
	private List<Factura> facturas;
	
	public Cliente (String nombre,
			String direccion,
			String numeroDeTelefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDeTelefono = numeroDeTelefono;
		this.llamadas = new ArrayList<LlamadaTelefonica>();
		this.facturas = new ArrayList<Factura>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public String getNumeroDeTelefono() {
		return numeroDeTelefono;
	}
	
	public List<LlamadaTelefonica> getLlamadas() {
		return llamadas;
	}
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	
	public void addLlamada(LlamadaTelefonica llamada) {
		this.llamadas.add(llamada);
	}
	
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public LlamadaTelefonica registrarLlamadaLocal(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe) {
		LlamadaTelefonica l = new LlamadaLocal(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe);
		this.addLlamada(l);
		return l;
	}
	
	public LlamadaTelefonica registrarLlamadaInterurbana(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			double distanciaEnKilometros) {
		LlamadaTelefonica l = new LlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				duracionEnMinutos);
		this.addLlamada(l);
		return l;
	}

	public LlamadaTelefonica registrarLlamadaInternacional(LocalDate fechaComienzo,
			LocalTime horaComienzo,
			int duracionEnMinutos,
			String numeroTelefonoLlama,
			String numeroTelefonoRecibe,
			String paisOrigen,
			String paisDestino) {
		LlamadaTelefonica l = new LlamadaInternacional(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
		this.addLlamada(l);
		return l;
	}
	
	public abstract void facturarLlamadaDeUnCliente(LocalDate fechaFacturacion,
			LocalDate fechaInicioPeriodo,
			LocalDate fechaFinPeriodo);
	
	public double calcularDescuento(double descuento, double monto) {
		return ((descuento * monto) / 100);
	}
	
}
