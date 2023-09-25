package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuerpo3D {
	private double altura;
	private Funciones caraBasal;
	
	public Cuerpo3D() {
		this.altura = 0;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal (Funciones caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public Funciones getCaraBasal() {
		return this.caraBasal;
	}
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * this.getAltura());
	}
	
	public double getSuperficieExterior() {
		return ((2 * this.getCaraBasal().getArea()) + (this.caraBasal.getPerimetro() * this.getAltura()));
	}
}
