package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import java.util.List;
import java.util.ArrayList;

public class Email {
	
	private List<Archivo> adjuntos;
	private String titulo;
	private String cuerpo;

	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos() {
		return new ArrayList<>(this.adjuntos);
	}
	
	public void addArchivo(Archivo arch) {
		this.adjuntos.add(arch);
	}
	
	public boolean buscar(String texto) {
		return (this.getTitulo().contains(texto)) || (this.getCuerpo().contains(texto));
	}
	
	/*
	 * el tamaño del titulo de un email puede ir de 0 a infinitos positivos
	 */
	
	public int tamañoTitulo() {
		return this.getTitulo().length();
	}
	
	/*
	 * el tamaño del cuerpo de un email puede ir de 0 a infinitos positivos
	 */
	
	public int tamañoCuerpo() {
		return this.getCuerpo().length();
	}
	
	public int espacioOcupado() {
		return (
				(this.tamañoTitulo())
				+ 
				(this.tamañoCuerpo())
				+ 
				(this.adjuntos()
						.stream()
						.mapToInt(adjunto -> (int)adjunto.tamaño())
						.sum())
				);
	}
	
}
