package implementacion_from_to;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements Date{
	
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
	
}
