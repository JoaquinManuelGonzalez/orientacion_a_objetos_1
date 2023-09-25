package ar.edu.unlp.info.oo1.ejercicio_9_cuenta_con_ganchos;

public class CuentaCorriente extends Cuenta{

	private double limiteDescubierto;
	
	public CuentaCorriente() {
		super();
		this.limiteDescubierto = 0;
	}
	
	public void setLimiteDescubierto(double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}
	
	public double getLimiteDescubierto() {
		return this.limiteDescubierto;
	}
	
	public double getDescubierto() {
		return this.limiteDescubierto;
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return ((super.getSaldo() - monto) >= (- this.getDescubierto()));
	}
}
