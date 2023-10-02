package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EsferaTest {

	private Esfera e;
	
	@BeforeEach
	void setUp() throws Exception {
		e = new Esfera("Hierro", "Rojo", 5);
	}

	@Test
	void testEsfera() {
		assertEquals("Hierro", e.getMaterial());
		assertEquals("Rojo", e.getColor());
		assertEquals(5, e.getRadio());
	}
	
	@Test
	void testVolumen() {
		assertEquals(524, Math.round(e.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(314, Math.round(e.getSuperficie()));
	}

}
