package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	
	private Propiedad propiedadConReservas;
	private Propiedad propiedadSinReservas;
	private Reserva reserva;
	private Usuario usuarioUno;
	private DateLapse lapsoUno;
	private DateLapse lapsoDos;
	private DateLapse lapsoTres;
	private DateLapse lapsoCuatro;
	private DateLapse lapsoCinco;

	@BeforeEach
	void setUp() throws Exception {
		lapsoUno = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 5, 5));
		lapsoDos = new DateLapse (LocalDate.of(2023, 5, 5), LocalDate.of(2023, 6, 6));
		lapsoTres = new DateLapse (LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 2));
		lapsoCuatro = new DateLapse (LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
		lapsoCinco = new DateLapse (LocalDate.of(2023, 5, 6), LocalDate.of(2023, 6, 6));
		
		usuarioUno = new Usuario ("j", "123", "calle 1");
		
		propiedadConReservas = new Propiedad ("p1", 
				"prop 1", 
				"calle 1", 
				10.0);
		propiedadSinReservas = new Propiedad ("p2", 
				"prop 2", 
				"calle 2", 
				20.0);
		
		reserva = new Reserva (propiedadConReservas, lapsoUno, usuarioUno);
		
		propiedadConReservas.addReserva(reserva);
	}

	@Test
	void testBuscarDisponibilidadOverlapSupLimit() {
		assertFalse(propiedadConReservas.buscarDisponibilidad(lapsoDos));
	}
	
	@Test
	void testBuscarDisponibilidadOverlapInfLimit() {
		assertFalse(propiedadConReservas.buscarDisponibilidad(lapsoTres));
	}
	
	@Test
	void testBuscarDisponibilidadNoOverlapInf() {
		assertTrue(propiedadConReservas.buscarDisponibilidad(lapsoCuatro));
	}
	
	@Test
	void testBuscarDisponibilidadNoOverlapSup() {
		assertTrue(propiedadConReservas.buscarDisponibilidad(lapsoCinco));
	}
	
	@Test
	void testBuscarDisponibilidadSinReservas() {
		assertTrue(propiedadSinReservas.buscarDisponibilidad(lapsoUno));
	}

	@Test
	void testCalcularIngresosEnUnPeriodoDentroSupLimit() {
		assertEquals(920, propiedadConReservas.calcularIngresosEnUnPeriodo(lapsoDos));
	}
	
	@Test
	void testCalcularIngresosEnUnPeriodoDentroInfLimit() {
		assertEquals(920, propiedadConReservas.calcularIngresosEnUnPeriodo(lapsoTres));
	}
	
	@Test
	void testCalcularIngresosEnUnPeriodoFueraSupLimit() {
		assertEquals(0, propiedadConReservas.calcularIngresosEnUnPeriodo(lapsoCinco));
	}
	
	@Test
	void testCalcularIngresosEnUnPeriodoFueraInfLimit() {
		assertEquals(0, propiedadConReservas.calcularIngresosEnUnPeriodo(lapsoCuatro));
	}
	
	@Test
	void testCalcularIngresosPropiedadSinReservas() {
		assertEquals(0, propiedadSinReservas.calcularIngresosEnUnPeriodo(lapsoUno));
	}

}
