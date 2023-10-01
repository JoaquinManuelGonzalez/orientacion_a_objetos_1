package ar.edu.unlp.info.oo1.ejercicio_11_el_inversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlazoFijoTest {

	private PlazoFijo plazo;	
	
	@BeforeEach
	void setUp() throws Exception {
		plazo = new PlazoFijo(LocalDate.now().minusDays(24), 3000, 1);
	}

	@Test
	void testPlazoFijo() {
		assertEquals(LocalDate.now().minusDays(24), plazo.getFechaDeConstitucion());
		assertEquals(3000, plazo.getMontoDepositado());
		assertEquals(1, plazo.getPorcentajeDeInteresDiario());
	}
	
	@Test
	void testValorActual() {
		assertEquals(3720, plazo.valorActual());
	}

}
