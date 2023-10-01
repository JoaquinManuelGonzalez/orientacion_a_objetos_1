package ar.edu.unlp.info.oo1.ejercicio_11_el_inversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor (String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Inversion> getInversiones() {
		return new ArrayList<Inversion>(this.inversiones);
	}
	
	public void addInversion (Inversion inversion) {
		this.inversiones.add(inversion);
	}
	
	public double valorActual() {
		return this.getInversiones().stream()
				.mapToDouble(inversion -> inversion.valorActual())
				.sum();
	}
}
