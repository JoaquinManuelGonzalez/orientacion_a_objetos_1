package ar.edu.unlp.info.oo1.ej_8_distribuidora_electrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		facturas = new ArrayList<>();
		consumos = new ArrayList<>();
	}
	
	public Usuario() {
		facturas = new ArrayList<>();
	}
	
	public List<Consumo> getConsumos(){
		return new ArrayList<>(this.consumos);
	}
	
	public List<Factura> getFacturas(){
		return new ArrayList<Factura>(this.facturas);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDomicilio() {
		return this.domicilio;
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public double ultimoConsumoActiva() {
		Consumo ultimoConsumo = this.ultimoConsumo();
		double consumoActivo = 0.0;
		if (ultimoConsumo != null) {
			consumoActivo = ultimoConsumo.getConsumoEnergiaActiva();
		}
		return consumoActivo;
	}
	
	public Consumo ultimoConsumo() {
		return this.getConsumos().stream()
				.max((consumo1, consumo2) -> consumo1.getFecha().compareTo(consumo2.getFecha()))
				.orElse(null);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Factura factura = null;
		Consumo ultimoConsumo = this.ultimoConsumo();
		if (ultimoConsumo != null) {
			if (ultimoConsumo.factorDePotencia() > 0.8) {
				factura = new Factura(ultimoConsumo.costoEnBaseA(precioKWh), 10, this);
			} else {
				factura = new Factura(ultimoConsumo.costoEnBaseA(precioKWh), 0, this);
			}
		} else {
			factura = new Factura(0, 0, this);
		}
		this.agregarFactura(factura);
		return factura;
	}
}
