package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto {
	
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto() {
		
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return (this.precioPorKilo * this.getPeso());
	}
}
