package ar.edu.unlp.info.oo1.ejercicio_11_el_inversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversorTest {
	
	private Inversor inverSinAcciones;
	private Inversor joaco;
	private InversionEnAcciones inversion;
	private PlazoFijo plazo;

	@BeforeEach
	void setUp() throws Exception {
		joaco = new Inversor("joaco");
		inverSinAcciones = new Inversor("joseLui");
		plazo = new PlazoFijo(LocalDate.now().minusDays(24), 3000, 1);
		inversion = new InversionEnAcciones("accion", 5, 100.0);	
	}

	@Test
	void testInversor() {
		assertEquals("joaco", joaco.getNombre());
		assertEquals("joseLui", inverSinAcciones.getNombre());
		assertNotNull(inverSinAcciones.getInversiones());
		assertNotNull(joaco.getInversiones());
	}
	
	void testAgregar() {
		joaco.addInversion(inversion);
		joaco.addInversion(plazo);
		assertEquals(2, joaco.getInversiones().size());
	}
	
	void testValorActual() {
		assertEquals(8720, joaco.valorActual());
		assertEquals(0, inverSinAcciones.valorActual());
	}
}
