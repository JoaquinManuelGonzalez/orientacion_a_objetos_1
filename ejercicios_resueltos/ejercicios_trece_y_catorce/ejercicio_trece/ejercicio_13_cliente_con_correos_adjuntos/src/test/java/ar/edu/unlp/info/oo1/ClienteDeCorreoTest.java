package ar.edu.unlp.info.oo1.ejercicio_13_cliente_con_correos_adjuntos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
	
	private ClienteDeCorreo cliente;
	private ClienteDeCorreo clienteSinEmails;
	private Carpeta carpeta;
	private Email email;
	private Email email2;

	@BeforeEach
	void setUp() throws Exception {
		cliente = new ClienteDeCorreo();
		clienteSinEmails = new ClienteDeCorreo();
		carpeta = new Carpeta("Direc");
		email = new Email ("Soy Un Mail","Hola");
		email2 = new Email ("Soy otro mail","Chau");
		
		cliente.addCarpeta(carpeta);
		cliente.recibir(email);
		cliente.recibir(email2);
	}

	@Test
	void testBuscar() {
		assertSame(email, cliente.buscar("Hola"));
	}
	
	@Test
	void testBuscarNoExiste() {
		assertNull(cliente.buscar("testing"));
	}

	@Test
	void testEspacioOcupado() {
		assertEquals(32, cliente.espacioOcupado());
	}
	
	@Test
	void testEspacioOcupadoSinEmails() {
		assertEquals(0, clienteSinEmails.espacioOcupado());
	}

}
