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
	
	public static void agregarInversiones(Inversor joaco, 
			InversionEnAcciones inversion, 
			PlazoFijo plazo) {
		joaco.addInversion(inversion);
		joaco.addInversion(plazo);
	}

	@Test
	void testInversor() {
		assertEquals("joaco", joaco.getNombre());
		assertEquals("joseLui", inverSinAcciones.getNombre());
		assertNotNull(inverSinAcciones.getInversiones());
		assertNotNull(joaco.getInversiones());
	}
	
	@Test
	void testAgregar() {
		agregarInversiones(joaco, inversion, plazo);
		assertEquals(2, joaco.getInversiones().size());
	}
	
	@Test
	void testValorActual() {
		agregarInversiones(joaco, inversion, plazo);
		assertEquals(4220, joaco.valorActual());
		assertEquals(0, inverSinAcciones.valorActual());
	}
}
