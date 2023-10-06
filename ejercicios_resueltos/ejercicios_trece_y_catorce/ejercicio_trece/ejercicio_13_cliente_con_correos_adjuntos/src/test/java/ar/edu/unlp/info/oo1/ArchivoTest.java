package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {

	private Archivo archivoSinTitulo;
	
	@BeforeEach
	void setUp() throws Exception {
		archivoSinTitulo = new Archivo("");
	}

	@Test
	void testTamaño() {
		assertEquals(0, archivoSinTitulo.tamaño());
	}

}
