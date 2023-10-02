package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

public abstract class Pieza {
	
	private String material;
	private String color;
	
	protected Pieza (String material, String color) {
		this.material = material;
		this.color = color;
	}
	
	protected String getMaterial() {
		return this.material;
	}
	
	protected String getColor() {
		return this.color;
	}
	
	protected abstract double getVolumen();
	
	protected abstract double getSuperficie();
}
