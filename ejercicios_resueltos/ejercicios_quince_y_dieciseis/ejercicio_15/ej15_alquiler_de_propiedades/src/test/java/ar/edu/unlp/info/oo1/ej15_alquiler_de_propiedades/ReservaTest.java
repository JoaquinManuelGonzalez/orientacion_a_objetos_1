package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	private Propiedad propiedadPrecioUno;
	private Reserva reservaNochesUnoPrecioUno;
	private Reserva reservaNochesCeroPrecioUno;
	private Usuario usuarioUno;
	private Usuario usuarioDos;
	private DateLapse lapsoCero;
	private DateLapse lapsoUno;
	
	@BeforeEach
	void setUp() throws Exception {
		usuarioUno = new Usuario ("j", "123", "calle 1");
		usuarioDos = new Usuario("k", "1234", "calle 2");
		lapsoCero = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 2));
		lapsoUno = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 3));
		propiedadPrecioUno = new Propiedad ("p", 
				"prop 2", 
				"calle 2", 
				1.0, 
				usuarioDos);
		reservaNochesCeroPrecioUno = new Reserva (propiedadPrecioUno, lapsoCero, usuarioUno);
		reservaNochesUnoPrecioUno = new Reserva (propiedadPrecioUno, lapsoUno, usuarioDos);
	}

	@Test
	void testPrecioReservaPrecioUnoNocheUno() {
		assertEquals(1, reservaNochesUnoPrecioUno.precioReserva());
	}
	
	@Test
	void testPrecioReservaPrecioCeroNocheCero() {
		assertEquals(0, reservaNochesCeroPrecioUno.precioReserva());
	}

}
