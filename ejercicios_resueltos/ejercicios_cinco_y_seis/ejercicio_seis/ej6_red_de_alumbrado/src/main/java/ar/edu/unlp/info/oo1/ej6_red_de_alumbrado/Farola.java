package ar.edu.unlp.info.oo1.ej6_red_de_alumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	
	private boolean state;
	private List<Farola> neighbors;
	
	public Farola() {
		this.state = false;
		neighbors = new ArrayList<>();
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors(){
		return this.neighbors;
	}
	
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.state;
	}
	
	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.isOn()) {
			this.state = false;
			this.getNeighbors().forEach(neighbor -> neighbor.turnOff());
			//turnOffNeighbors(this.getNeighbors());
		}
	}
	
	private void turnOffNeighbors(List<Farola> neighbors) {
		for (Farola farola : neighbors) {
			farola.turnOff();
		}
	}
	
	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.isOn()) {
			this.state = true;
			this.getNeighbors().forEach(neighbor -> neighbor.turnOn());
			//turnOnNeighbors(this.getNeighbors());
		}
	}
	
	private void turnOnNeighbors(List<Farola> neighbors) {
		for (Farola farola : neighbors) {
			farola.turnOn();
		}
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	de otraFarola, al igual que otraFarola también se convertirá en vecina del
	receptor del mensaje
	*/
	public void pairWithNeighbor(Farola unaFarola) {
		this.getNeighbors().add(unaFarola);
		unaFarola.getNeighbors().add(this);
	}
}
