package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrismaRectangularTest {

	private PrismaRectangular p;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new PrismaRectangular("Hierro", "Rojo", 7, 6, 5);
	}

	@Test
	void testPrismaRectangular() {
		assertEquals("Hierro", p.getMaterial());
		assertEquals("Rojo", p.getColor());
		assertEquals(7, p.getLadoMayor());
		assertEquals(6, p.getLadoMenor());
		assertEquals(5, p.getAltura());
	}
	
	@Test
	void testVolumen() {
		assertEquals(210, Math.round(p.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(214, Math.round(p.getSuperficie()));
	}

}
