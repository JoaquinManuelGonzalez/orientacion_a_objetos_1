package ar.edu.unlp.info.oo1.ej16_politicas_de_cancelacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	private Propiedad propiedadPrecioUno;
	private Propiedad propiedadEstricta;
	private Propiedad propiedadModerada;
	private Propiedad propiedadFlexible;
	private Reserva reservaNochesUnoPrecioUno;
	private Reserva reservaNochesCeroPrecioUno;
	private Reserva reservaEstricta;
	private Reserva reservaModerada;
	private Reserva reservaFlexible;
	private Usuario usuarioUno;
	private Usuario usuarioDos;
	private DateLapse lapsoCero;
	private DateLapse lapsoUno;
	private PoliticaDeCancelacion politicaEstricta;
	private PoliticaDeCancelacion politicaModerada;
	private PoliticaDeCancelacion politicaFlexible;
	
	@BeforeEach
	void setUp() throws Exception {
		usuarioUno = new Usuario ("j", "123", "calle 1");
		usuarioDos = new Usuario("k", "1234", "calle 2");
		lapsoCero = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 2));
		lapsoUno = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 3));
		politicaEstricta = new PoliticaDeCancelacionEstricta();
		politicaModerada = new PoliticaDeCancelacionModerada();
		politicaFlexible = new PoliticaDeCancelacionFlexible();
		propiedadEstricta = new Propiedad("p",
				"prop", 
				"calle 1", 
				1.0,
				politicaEstricta);
		propiedadModerada = new Propiedad("p",
				"prop", 
				"calle 1", 
				1.0,
				politicaModerada);
		propiedadFlexible = new Propiedad("p",
				"prop", 
				"calle 1", 
				1.0,
				politicaFlexible);
		propiedadPrecioUno = new Propiedad ("p", 
				"prop 2", 
				"calle 2", 
				1.0,
				politicaEstricta);
		reservaNochesCeroPrecioUno = new Reserva (propiedadPrecioUno, lapsoCero, usuarioUno);
		reservaNochesUnoPrecioUno = new Reserva (propiedadPrecioUno, lapsoUno, usuarioDos);
		reservaEstricta = new Reserva (propiedadEstricta, lapsoUno, usuarioDos);
		reservaModerada = new Reserva (propiedadModerada, lapsoUno, usuarioDos);
		reservaFlexible = new Reserva (propiedadFlexible, lapsoUno, usuarioDos);
	}

	@Test
	void testCalcularPrecioReservaPrecioUnoNocheUno() {
		assertEquals(1, reservaNochesUnoPrecioUno.calcularPrecioDeReserva());
	}
	
	@Test
	void testCalcularPrecioReservaPrecioCeroNocheCero() {
		assertEquals(0, reservaNochesCeroPrecioUno.calcularPrecioDeReserva());
	}
	
	@Test
	void testCalcularMontoAReembolsarEstricto() {
		assertEquals(0, reservaEstricta.calcularMontoAReembolsar(politicaEstricta, LocalDate.of(2023, 2, 1)));
	}
	
	@Test
	void testCalcularMontoAReembolsarModerado() {
		//CON 7 DIAS DE ANTELACION
		assertEquals(1, reservaModerada.calcularMontoAReembolsar(politicaModerada, LocalDate.of(2023, 1, 26)));
		
		//CON 6 DIAS DE ANTELACION
		assertEquals(0.5, reservaModerada.calcularMontoAReembolsar(politicaModerada, LocalDate.of(2023, 1, 27)));
		
		//CON 2 DIAS DE ANTELACION
		assertEquals(0.5, reservaModerada.calcularMontoAReembolsar(politicaModerada, LocalDate.of(2023, 1, 31)));
		
		//CON 1 DIA DE ANTELACION
		assertEquals(0, reservaModerada.calcularMontoAReembolsar(politicaModerada, LocalDate.of(2023, 2, 1)));
	}
	
	@Test
	void testCalcularMontoAReembolsarFlexible() {
		assertEquals(1, reservaFlexible.calcularMontoAReembolsar(politicaFlexible, LocalDate.of(2023, 2, 1)));
	}

}
