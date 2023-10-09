package implementacion_from_to;

import java.time.LocalDate;

public interface Date {
	
	public LocalDate getTo();
	
	public int sizeInDays();
	
	public boolean includesDate(LocalDate other); //es igual el metodo, podria ser una clase abstracta
}
