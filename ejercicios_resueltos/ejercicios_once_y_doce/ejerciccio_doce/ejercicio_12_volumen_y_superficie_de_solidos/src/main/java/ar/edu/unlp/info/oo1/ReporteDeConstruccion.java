package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}
	
	public List<Pieza> getPiezas() {
		return new ArrayList<>(this.piezas);
	}
	
	public void addPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public double volumenDeMaterial(String material) {
		return this.getPiezas()
				.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.mapToDouble(pieza -> pieza.getVolumen())
				.sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.getPiezas()
				.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(pieza -> pieza.getSuperficie())
				.sum();
	}
}
