package ar.edu.unlp.info.oo1.ejercicio_7_method_lookup_con_empleados;

public class EmpleadoJerarquico extends Empleado{

	public EmpleadoJerarquico(String nombre) {
		super(nombre);
	}
	
	public double bonoPorCategoria() {
		return 8000;
	}
	
	public double montoBasico() {
		return 45000;
	}
	
	public double sueldoBasico() {
		return super.sueldoBasico() + this.bonoPorCategoria();
	}
}
