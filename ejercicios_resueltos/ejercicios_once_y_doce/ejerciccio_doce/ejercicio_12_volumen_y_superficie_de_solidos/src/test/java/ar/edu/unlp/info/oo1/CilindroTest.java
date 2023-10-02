package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CilindroTest {

	private Cilindro c;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Cilindro("Hierro", "Rojo", 5, 5);
	}

	@Test
	void testCilindro() {
		assertEquals("Hierro", c.getMaterial());
		assertEquals("Rojo", c.getColor());
		assertEquals(5, c.getRadio());
		assertEquals(5, c.getAltura());
	}
	
	@Test
	void testVolumen() {
		assertEquals(393, Math.round(c.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(314, Math.round(c.getSuperficie()));
	}

}
