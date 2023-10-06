package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	
	private Email emailSinTituloNiCuerpo;

	@BeforeEach
	void setUp() throws Exception {
		emailSinTituloNiCuerpo = new Email("", "");
	}
	
	@Test
	void tamañoTitulo() {
		assertEquals(0, emailSinTituloNiCuerpo.tamañoTitulo());
	}
	
	@Test
	void tamañoCuerpo() {
		assertEquals(0, emailSinTituloNiCuerpo.tamañoCuerpo());
	}

	@Test
	void testBuscar() {
		Email emailContiene = new Email("Creacion de mail", "Soy un mail normal");
		
		assertTrue(emailContiene.buscar("mail"));
	}
	
	@Test
	void testBuscarPorUno() {
		Email emailNoContienePorUno = new Email("Creacion de mai", "Soy un mai normal");
		
		assertFalse(emailNoContienePorUno.buscar("mail"));
	}
	
	@Test
	void testBuscarNoContiene() {
		Email emailNoContiene = new Email("Creacion", "Soy un correo");
		
		assertFalse(emailNoContiene.buscar("mail"));
	}
	
	@Test
	void testEspacioOcupado() {
		Email emailConDosAdj = new Email("Adjuntos", "Dos");
		
		emailConDosAdj.addArchivo(new Archivo("UNO"));
		emailConDosAdj.addArchivo(new Archivo("DOS"));
		
		assertEquals(17, emailConDosAdj.espacioOcupado());
	}
	
	@Test
	void testEspacioOcupadoUnAdjunto() {
		Email emailConUnAdj = new Email("Adjuntos", "Uno");
		
		emailConUnAdj.addArchivo(new Archivo("UNO"));
		
		assertEquals(14, emailConUnAdj.espacioOcupado());
	}
	
	@Test
	void testEspacioOcupadoCeroAdjunto() {
		Email emailConCeroAdj = new Email("Adjuntos", "Cero");
		
		assertEquals(12, emailConCeroAdj.espacioOcupado());
	}

}
