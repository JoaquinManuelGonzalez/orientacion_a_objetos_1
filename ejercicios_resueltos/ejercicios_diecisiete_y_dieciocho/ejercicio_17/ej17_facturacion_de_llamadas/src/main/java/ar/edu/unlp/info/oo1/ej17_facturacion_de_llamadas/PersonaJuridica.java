package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import java.time.LocalDate;

public class PersonaJuridica extends Cliente{

	private String cuit;
	private String tipo;
	
	public PersonaJuridica(String nombre,
			String direccion,
			String cuit,
			String tipo,
			String numeroDeTelefono) {
		super(nombre,
				direccion,
				numeroDeTelefono);
		this.cuit = cuit;
		this.tipo = tipo;
	}

	public String getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
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
		monto = monto - super.calcularDescuento(0, monto);
		super.addFactura(new Factura(fechaFacturacion, fechaInicioPeriodo, fechaFinPeriodo, monto));
	}

}
