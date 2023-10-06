package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("Inbox");
		this.carpetas = new ArrayList<>();
		this.addCarpeta(this.getInbox());
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
	
	public List<Carpeta> getCarpetas() {
		return new ArrayList<>(this.carpetas);
	}
	
	public void addCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public void recibir(Email email) {
		this.getInbox().addEmail(email);
	}
	
	public void mover (Email email, Carpeta origen, Carpeta destino) {
		origen.removeEmail(email);
		destino.addEmail(email);
	}
	
	public Email buscar(String texto) {
		return this.getCarpetas()
				.stream()
				.map(carpeta -> carpeta.buscar(texto))
				.filter(email -> email != null)
				.findFirst()
				.orElse(null);
	}
	
	public int espacioOcupado() {
		return this.getCarpetas()
				.stream()
				.mapToInt(carpeta -> carpeta.espacioOcupado())
				.sum();
	}
	
}
