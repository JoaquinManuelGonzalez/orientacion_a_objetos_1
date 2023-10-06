package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	
	private Carpeta carpetaConEmails;
	private Carpeta carpetaSinEmails;
	private Email emailUno;
	private Email emailDos;

	@BeforeEach
	void setUp() throws Exception {
		carpetaConEmails = new Carpeta("Directorio");
		carpetaSinEmails = new Carpeta("Directorio dos");
		emailUno = new Email("Creacion de mail", "Soy un mail normal");
		emailDos = new Email("Creacion de mail", "Soy un mail normal");
		carpetaConEmails.addEmail(emailUno);
		carpetaConEmails.addEmail(emailDos);
		emailDos.addArchivo(new Archivo("arch"));
	}

	@Test
	void testBuscar() {
		assertSame(emailUno, carpetaConEmails.buscar("mail"));
	}
	
	@Test
	void testBuscarNoExiste() {
		assertNull(carpetaSinEmails.buscar("mail"));
	}

	@Test
	void testEspacioOcupado() {
		assertEquals(72, carpetaConEmails.espacioOcupado());
	}

}
