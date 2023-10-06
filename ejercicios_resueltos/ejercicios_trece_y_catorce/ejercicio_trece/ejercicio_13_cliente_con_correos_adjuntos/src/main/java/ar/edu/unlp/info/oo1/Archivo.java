package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

public class Archivo {
	
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * El nombre de un archivo va de 0 carac. a "infinitos" positivos.
	 */
	
	public double tamaño() {
		return this.getNombre().length();
	}
	
}
