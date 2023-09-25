package ar.edu.unlp.info.oo1.Ejercicio3_Presupuesto;

public class Item {
	
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item (String detalle, int cantidad, double costoUnitario) {
		this.setDetalle(detalle);
		this.setCantidad(cantidad);
		this.setCostoUnitario(costoUnitario);
	}

	public String getDetalle() {
		return detalle;
	}

	private void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	private void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public double costo() {
		return (this.getCantidad() * this.getCostoUnitario());
	}
}
