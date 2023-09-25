package ar.edu.unlp.info.oo1.ej_8_distribuidora_electrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new ArrayList<>();
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void precioKWh(double precio) {
		this.precioKWh = precio;
	}
	
	public double getPrecioKWh() {
		return this.precioKWh;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public double consumoTotalActiva() {
		return this.getUsuarios().stream()
				.mapToDouble(usuario -> usuario.ultimoConsumoActiva())
				.sum();
	}
	
	public List<Factura> facturar() {
		return this.getUsuarios().stream()
				.map(usuario -> usuario.facturarEnBaseA(this.getPrecioKWh()))
				.collect(Collectors.toList());
	}
}
