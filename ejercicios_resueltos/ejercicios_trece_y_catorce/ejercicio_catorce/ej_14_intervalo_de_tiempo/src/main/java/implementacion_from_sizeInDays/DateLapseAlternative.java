package implementacion_from_sizeInDays;

import java.time.LocalDate;

import implementacion_from_to.Date;

public class DateLapseAlternative implements Date{
	
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapseAlternative(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.getFrom().plusDays(this.sizeInDays);
	}
	
	public int sizeInDays() {
		if (this.sizeInDays >= 0) {
			return this.sizeInDays;
		} else {
			return -1;
		}
	}
	
	public boolean includesDate(LocalDate other) {
		return !(other.isAfter(this.getTo()) || other.isBefore(this.getFrom()));
	}
	
}
