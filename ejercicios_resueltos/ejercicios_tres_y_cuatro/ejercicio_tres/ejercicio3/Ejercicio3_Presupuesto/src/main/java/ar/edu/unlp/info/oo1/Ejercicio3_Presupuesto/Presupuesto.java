package ar.edu.unlp.info.oo1.Ejercicio3_Presupuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.setCliente(cliente);
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCliente() {
		return cliente;
	}

	private void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void agregarItem (Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal () {
		double suma = this.getItems().stream()
				.mapToDouble(Item -> Item.costo())
				.sum();
		return suma;
	}
	
}
