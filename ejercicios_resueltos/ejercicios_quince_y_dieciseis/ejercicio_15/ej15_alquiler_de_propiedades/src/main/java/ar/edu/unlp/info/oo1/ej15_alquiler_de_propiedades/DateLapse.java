package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public int sizeInDays() {
		int diferencia;
		if (!this.getFrom().isAfter(this.getTo())) {
			diferencia = (int) ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
		} else {
			diferencia = -1;
		}
		return diferencia;
	}
	
	public boolean includesDate(LocalDate other) {
		return !(other.isAfter(this.getTo()) || other.isBefore(this.getFrom()));
	}
	
	public boolean overlaps (DateLapse anotherDateLapse) {
		return ((this.includesDate(anotherDateLapse.getFrom())) 
				|| 
				(this.includesDate(anotherDateLapse.getTo())))
				||
				((anotherDateLapse.includesDate(this.getFrom())) 
						|| 
				(anotherDateLapse.includesDate(this.getTo())));
	}
	
	public boolean dateBeforeLapse (LocalDate other) {
		return other.isBefore(this.getFrom());
	}
	
}
