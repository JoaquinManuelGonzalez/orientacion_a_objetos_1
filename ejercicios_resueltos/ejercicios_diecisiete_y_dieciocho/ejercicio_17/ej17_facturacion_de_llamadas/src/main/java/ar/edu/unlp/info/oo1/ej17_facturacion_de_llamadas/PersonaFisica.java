package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;

public class PersonaFisica extends Cliente{
	
	private String dni;
	
	public PersonaFisica(String nombre,
			String direccion,
			String dni,
			String numeroDeTelefono) {
		super(nombre,
				direccion,
				numeroDeTelefono);
		this.dni = dni;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void facturarLlamadaDeUnCliente(LocalDate fechaFacturacion,
			LocalDate fechaInicioPeriodo,
			LocalDate fechaFinPeriodo) {
		double monto = super.getLlamadas()
				.stream()
				.filter(llamada -> !llamada.getFechaComienzo().isBefore(fechaInicioPeriodo) 
						|| 
						!llamada.getFechaComienzo().isAfter(fechaFinPeriodo))
				.mapToDouble(llamada -> llamada.calcularMontoLlamada())
				.sum();
		monto = monto - super.calcularDescuento(10, monto);
		super.addFactura(new Factura(fechaFacturacion, fechaInicioPeriodo, fechaFinPeriodo, monto));
	}
	
}
