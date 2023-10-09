package implementacion_from_to;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementacion_from_sizeInDays.DateLapseAlternative;

class DateLapseTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSizeInDaysNoDifference() {
		LocalDate to = LocalDate.of(2023, 1, 1);
		LocalDate from = LocalDate.of(2023, 1, 1);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, 0);
		
		assertEquals(0, lapso.sizeInDays());
		assertEquals(0, lapso2.sizeInDays());
	}
	
	@Test
	void testSizeInDaysNegativeDifference() {
		LocalDate to = LocalDate.of(2023, 1, 1);
		LocalDate from = LocalDate.of(2023, 1, 2);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, -1);
		
		assertEquals(-1, lapso.sizeInDays());
		assertEquals(-1, lapso2.sizeInDays());
	}

	@Test
	void testIncludesDateSupLimit() {
		LocalDate from = LocalDate.of(2023, 2, 2);
		LocalDate to = LocalDate.of(2023, 2, 5);
		LocalDate other = LocalDate.of(2023, 2, 5);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, 3);
		
		assertTrue(lapso.includesDate(other));
		assertTrue(lapso2.includesDate(other));
	}
	
	@Test
	void testIncludesDateInfLimit() {
		LocalDate from = LocalDate.of(2023, 2, 2);
		LocalDate to = LocalDate.of(2023, 2, 5);
		LocalDate other = LocalDate.of(2023, 2, 2);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, 3);
		
		assertTrue(lapso.includesDate(other));
		assertTrue(lapso2.includesDate(other));
	}
	
	@Test
	void tesIncludesDateSupLimitPlusOne() {
		LocalDate from = LocalDate.of(2023, 2, 2);
		LocalDate to = LocalDate.of(2023, 2, 5);
		LocalDate other = LocalDate.of(2023, 2, 6);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, 3);
		
		assertFalse(lapso.includesDate(other));
		assertFalse(lapso2.includesDate(other));
	}
	
	@Test
	void testIncludesDateInfLimitMinusOne() {
		LocalDate from = LocalDate.of(2023, 2, 2);
		LocalDate to = LocalDate.of(2023, 2, 5);
		LocalDate other = LocalDate.of(2023, 2, 1);
		Date lapso = new DateLapse(from, to);
		Date lapso2 = new DateLapseAlternative(from, 3);
		
		assertFalse(lapso.includesDate(other));
		assertFalse(lapso2.includesDate(other));
	}

}
