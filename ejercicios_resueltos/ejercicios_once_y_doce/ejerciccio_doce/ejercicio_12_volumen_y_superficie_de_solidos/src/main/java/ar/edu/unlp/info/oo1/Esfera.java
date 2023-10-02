package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

public class Esfera extends Pieza{
	

	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}
	
	public int getRadio() {
		return this.radio;
	}
	
	@Override
	protected double getVolumen() {
		return ((4 * Math.PI * (Math.pow(this.getRadio(), 3))) / 3);
	}

	@Override
	protected double getSuperficie() {
		return (4 * Math.PI * Math.pow(this.getRadio(), 2));
	}

}
