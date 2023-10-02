package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

public class PrismaRectangular extends Pieza{
	

	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, 
			String color,
			int ladoMayor,
			int ladoMenor,
			int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public int getLadoMayor() {
		return this.ladoMayor;
	}
	
	public int getLadoMenor() {
		return this.ladoMenor;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	@Override
	protected double getVolumen() {
		return (this.getLadoMayor() * this.getLadoMenor() * this.getAltura());
	}

	@Override
	protected double getSuperficie() {
		return (2 * 
				((this.getLadoMayor() * this.getLadoMenor()) 
						+ (this.getLadoMayor() * this.getAltura()) 
						+ (this.getLadoMenor() * this.getAltura())));
	}

}
