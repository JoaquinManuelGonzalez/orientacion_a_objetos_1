package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OOBnBTest {
	
	private Propiedad propiedad;

	private Usuario usuarioUno;
	private DateLapse lapsoUno;
	private DateLapse lapsoDos;
	private PoliticaDeCancelacion politica;
	private OOBnB sistemaConPropiedades;
	private OOBnB sistemaSinPropiedades;

	@BeforeEach
	void setUp() throws Exception {
		sistemaConPropiedades = new OOBnB();
		sistemaSinPropiedades = new OOBnB();
		
		politica = new PoliticaDeCancelacionEstricta();
		usuarioUno = sistemaConPropiedades.registrarUsuario("j", "calle 1", "123");
		propiedad = sistemaConPropiedades.registrarPropiedad("p1", "prop 1", 10.0, "calle 1", usuarioUno, politica);
		lapsoUno = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 5, 5));
		lapsoDos = new DateLapse (LocalDate.of(2023, 5, 6), LocalDate.of(2023, 6, 6));
		sistemaConPropiedades.hacerReserva(propiedad, lapsoUno, usuarioUno);
	}

	@Test
	void testBuscarPropiedadesDisponibles() {
		//sist con propiedades pero no disponible
		assertEquals(0, sistemaConPropiedades.buscarPropiedadesDisponibles(lapsoUno).size());
		
		//sist con propiedades disponible
		assertEquals(1, sistemaConPropiedades.buscarPropiedadesDisponibles(lapsoDos).size());
		
		//sist sin propiedades
		assertEquals(0, sistemaSinPropiedades.buscarPropiedadesDisponibles(lapsoUno).size());
	}

}
