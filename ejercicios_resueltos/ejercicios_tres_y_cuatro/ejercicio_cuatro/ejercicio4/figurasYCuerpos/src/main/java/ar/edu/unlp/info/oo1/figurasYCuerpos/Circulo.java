package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Circulo implements Funciones {
	private double radio;
	private double diametro;
	
	public Circulo() {
		this.radio = 0;
		this.diametro = 0;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public void setDiametro(double valor) {
		this.diametro = valor;
		this.radio = (valor / 2);
	}
	
	public double getDiametro() {
		return (this.getRadio() * 2);
	}

	@Override
	public double getArea() {
		return (Math.PI * (Math.pow(this.getRadio(), 2)));
	}

	@Override
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}
}
