package ar.edu.unlp.info.oo1.ej15_alquiler_de_propiedades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	
	private Usuario usuarioConPropiedadConReservas;
	private Usuario usuarioConPropiedadSinReservas;
	private Usuario usuarioSinPropiedad;
	private Propiedad propiedadConReservas;
	private Propiedad propiedadSinReservas;
	private Reserva reserva;
	private DateLapse lapsoUno;
	private DateLapse lapsoDos;
	private DateLapse lapsoTres;
	private DateLapse lapsoCuatro;
	private DateLapse lapsoCinco;
	

	@BeforeEach
	void setUp() throws Exception {
		usuarioConPropiedadConReservas = new Usuario ("j", "123", "calle 1");
		usuarioConPropiedadSinReservas = new Usuario ("f", "1234", "calle 11");
		usuarioSinPropiedad = new Usuario ("l", "12345", "calle 111");
		
		propiedadConReservas = new Propiedad ("p1", 
				"prop 1", 
				"calle 1", 
				10.0, 
				usuarioConPropiedadConReservas);
		propiedadSinReservas = new Propiedad ("p2", 
				"prop 2", 
				"calle 2", 
				20.0, 
				usuarioConPropiedadSinReservas);
		
		lapsoUno = new DateLapse (LocalDate.of(2023, 2, 2), LocalDate.of(2023, 5, 5));
		lapsoDos = new DateLapse (LocalDate.of(2023, 5, 5), LocalDate.of(2023, 6, 6));
		lapsoTres = new DateLapse (LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 2));
		lapsoCuatro = new DateLapse (LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
		lapsoCinco = new DateLapse (LocalDate.of(2023, 5, 6), LocalDate.of(2023, 6, 6));
		
		reserva = new Reserva (propiedadConReservas, lapsoUno, usuarioConPropiedadConReservas);
		
		propiedadConReservas.addReserva(reserva);
		
		usuarioConPropiedadConReservas.addPropiedad(propiedadConReservas);
		usuarioConPropiedadSinReservas.addPropiedad(propiedadSinReservas);
	}

	@Test
	void testCalcularIngresosEnUnPeriodoUserConPropYReserva() {
		//overlap sup limit
		assertEquals(920, usuarioConPropiedadConReservas.calcularIngresosEnUnPeriodo(lapsoDos));
		
		//overlap inf limit
		assertEquals(920, usuarioConPropiedadConReservas.calcularIngresosEnUnPeriodo(lapsoTres));
		
		//no overlap inf limit
		assertEquals(0, usuarioConPropiedadConReservas.calcularIngresosEnUnPeriodo(lapsoCuatro));
		
		//no overlap sup limit
		assertEquals(0, usuarioConPropiedadConReservas.calcularIngresosEnUnPeriodo(lapsoCinco));
	}
	
	@Test
	void testCalcularIngresosEnUnPeriodoUserConPropSinReserva() {
		//overlap sup limit
		assertEquals(0, usuarioConPropiedadSinReservas.calcularIngresosEnUnPeriodo(lapsoDos));
		
		//overlap inf limit
		assertEquals(0, usuarioConPropiedadSinReservas.calcularIngresosEnUnPeriodo(lapsoTres));
		
		//no overlap inf limit
		assertEquals(0, usuarioConPropiedadSinReservas.calcularIngresosEnUnPeriodo(lapsoCuatro));
		
		//no overlap sup limit
		assertEquals(0, usuarioConPropiedadSinReservas.calcularIngresosEnUnPeriodo(lapsoCinco));
	}
	
	@Test
	void testCalcularIngresosEnUnPeriodoUserSinProp() {
		//overlap sup limit
		assertEquals(0, usuarioSinPropiedad.calcularIngresosEnUnPeriodo(lapsoDos));
		
		//overlap inf limit
		assertEquals(0, usuarioSinPropiedad.calcularIngresosEnUnPeriodo(lapsoTres));
		
		//no overlap inf limit
		assertEquals(0, usuarioSinPropiedad.calcularIngresosEnUnPeriodo(lapsoCuatro));
		
		//no overlap sup limit
		assertEquals(0, usuarioSinPropiedad.calcularIngresosEnUnPeriodo(lapsoCinco));
	}

}