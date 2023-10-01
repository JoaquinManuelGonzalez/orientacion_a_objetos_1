package ar.edu.unlp.info.oo1.ejercicio_11_el_inversor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnAccionesTest {
	
	private InversionEnAcciones inversion;

	@BeforeEach
	void setUp() throws Exception {
		inversion = new InversionEnAcciones("accion", 5, 100.0);
	}

	@Test
	void testAcciones() {
		assertEquals(5, inversion.getCantidad());
		assertEquals("accion", inversion.getNombre());
		assertEquals(100.0, inversion.getValorUnitario());
	}
	
	@Test
	void testValorActual() {
		assertEquals(500.0, inversion.valorActual());
	}

}
