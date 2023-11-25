package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInternacionalTest {
	
	private LocalDate fechaComienzo;
	private LocalTime horaComienzoDiurnoInf;
	private LocalTime horaComienzoDiurnoSup;
	private LocalTime horaComienzoNocturnoInf;
	private LocalTime horaComienzoNocturnoSup;
	private double duracionEnMinutos;
	private String numeroTelefonoLlama;
	private String numeroTelefonoRecibe;
	private String paisOrigen;
	private String paisDestino;
	private LlamadaTelefonica llamadaDiurnaSup;
	private LlamadaTelefonica llamadaDiurnaInf;
	private LlamadaTelefonica llamadaNocturnaSup;
	private LlamadaTelefonica llamadaNocturnaInf;

	@BeforeEach
	void setUp() throws Exception {
		fechaComienzo = LocalDate.of(2023, 11, 9);
		horaComienzoDiurnoInf = LocalTime.of(8, 0);
		horaComienzoDiurnoSup = LocalTime.of(19, 59);
		horaComienzoNocturnoInf = LocalTime.of(20, 0);
		horaComienzoNocturnoSup = LocalTime.of(7, 59);
		duracionEnMinutos = 1;
		numeroTelefonoLlama = "123";
		numeroTelefonoLlama = "456";
		paisOrigen = "Argentina";
		paisDestino = "Argentina";
		
		llamadaDiurnaInf = new LlamadaInternacional(fechaComienzo,
				horaComienzoDiurnoInf,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
		
		llamadaDiurnaSup = new LlamadaInternacional(fechaComienzo,
				horaComienzoDiurnoSup,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
		
		llamadaNocturnaInf = new LlamadaInternacional(fechaComienzo,
				horaComienzoNocturnoInf,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
		
		llamadaNocturnaSup = new LlamadaInternacional(fechaComienzo,
				horaComienzoNocturnoSup,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				paisOrigen,
				paisDestino);
	}

	@Test
	void testCalcularMontoLlamadaDiurno() {
		//LIMITE SUP
		assertEquals(4, llamadaDiurnaSup.calcularMontoLlamada());
		
		//LIMITE INF
		assertEquals(4, llamadaDiurnaInf.calcularMontoLlamada());
	}
	
	@Test
	void testCalcularMontoLlamadaNocturno() {
		//LIMITE SUP
		assertEquals(3, llamadaNocturnaSup.calcularMontoLlamada());
		
		//LIMITE INF
		assertEquals(3, llamadaNocturnaInf.calcularMontoLlamada());
	}

}
