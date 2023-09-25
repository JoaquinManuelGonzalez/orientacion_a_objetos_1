package ar.edu.unlp.info.oo1.ejercicio_9_cuenta_con_ganchos;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return (this.getSaldo() - monto >= 0);
	}
	
	@Override
	public void depositar(double monto) {
		super.depositar(monto - (monto * 1.02));
	}
	
	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto * 1.02);
	}
	
	@Override
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(monto * 1.02, cuentaDestino);
	}
}
