package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuadrado implements Funciones {
	private double lado;
	
	public Cuadrado() {
		this.lado = 0;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}

	@Override
	public double getArea() {
		return (Math.pow(lado, 2));
	}

	@Override
	public double getPerimetro() {
		return (this.getLado() * 4);
	}
	
}
