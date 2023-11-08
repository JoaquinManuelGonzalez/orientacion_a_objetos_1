package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
	
	private LocalDate from;
	private LocalDate to;
	private DateLapse lapso;
	
	@BeforeEach
	void setUp() throws Exception {
		from = LocalDate.of(2023, 2, 2);
		to = LocalDate.of(2023, 2, 5);
		lapso = new DateLapse(from, to);
	}

	@Test
	void testSizeInDaysNoDifference() {
		LocalDate equalFromTo = LocalDate.of(2023, 2, 5);
		DateLapse lapsoIgual = new DateLapse(equalFromTo, to);
		
		assertEquals(0, lapsoIgual.sizeInDays());
	}
	
	@Test
	void testSizeInDaysNegativeDifference() {
		LocalDate to = LocalDate.of(2023, 2, 5);
		LocalDate fromPlusOne = LocalDate.of(2023, 2, 6);
		DateLapse lapsoNegativo = new DateLapse(fromPlusOne, to);
		
		assertEquals(-1, lapsoNegativo.sizeInDays());
	}

	@Test
	void testIncludesDateSupLimit() {
		LocalDate other = LocalDate.of(2023, 2, 5);
		
		assertTrue(lapso.includesDate(other));
	}
	
	@Test
	void testIncludesDateInfLimit() {
		LocalDate other = LocalDate.of(2023, 2, 2);
		
		assertTrue(lapso.includesDate(other));
	}
	
	@Test
	void tesIncludesDateSupLimitPlusOne() {
		LocalDate other = LocalDate.of(2023, 2, 6);
		
		assertFalse(lapso.includesDate(other));
	}
	
	@Test
	void testIncludesDateInfLimitMinusOne() {
		LocalDate other = LocalDate.of(2023, 2, 1);
		
		assertFalse(lapso.includesDate(other));
	}

	@Test
	void testOverlapsSupLimit() {
		LocalDate from2 = LocalDate.of(2023, 2, 5);
		LocalDate to2 = LocalDate.of(2023, 2, 10);
		DateLapse lapso2 = new DateLapse(from2, to2);
		
		assertTrue(lapso.overlaps(lapso2));
	}
	
	@Test
	void testOverlapsInfLimit() {
		LocalDate from2 = LocalDate.of(2023, 2, 1);
		LocalDate to2 = LocalDate.of(2023, 2, 2);
		DateLapse lapso2 = new DateLapse(from2, to2);
		
		assertTrue(lapso.overlaps(lapso2));
	}
	
	@Test
	void testOverlapsSupLimitPlusOne() {
		LocalDate from2 = LocalDate.of(2023, 2, 6);
		LocalDate to2 = LocalDate.of(2023, 2, 10);
		DateLapse lapso2 = new DateLapse(from2, to2);
		
		assertFalse(lapso.overlaps(lapso2));
	}
	
	@Test
	void testOverlapsInfLimitMinusOne() {
		LocalDate from2 = LocalDate.of(2023, 1, 31);
		LocalDate to2 = LocalDate.of(2023, 2, 1);
		DateLapse lapso2 = new DateLapse(from2, to2);
		
		assertFalse(lapso.overlaps(lapso2));
	}

	@Test
	void testDateBeforeLapse() {
		LocalDate other = LocalDate.of(2023, 2, 1);
		
		assertTrue(lapso.dateBeforeLapse(other));
	}
	
	@Test
	void testDateBeforeLapseEqualDate() {
		LocalDate other = LocalDate.of(2023, 2, 2);
		
		assertFalse(lapso.dateBeforeLapse(other));
	}

}