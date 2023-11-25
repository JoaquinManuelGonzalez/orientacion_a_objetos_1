package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaLocalTest {
	
	private LocalDate fechaComienzo;
	private LocalTime horaComienzo;
	private double duracionEnMinutos;
	private String numeroTelefonoLlama;
	private String numeroTelefonoRecibe;
	private LlamadaTelefonica llamada;

	@BeforeEach
	void setUp() throws Exception {
		fechaComienzo = LocalDate.of(2023, 11, 9);
		horaComienzo = LocalTime.of(19, 0);
		duracionEnMinutos = 1;
		numeroTelefonoLlama = "123";
		numeroTelefonoLlama = "456";
		
		llamada = new LlamadaLocal(fechaComienzo, horaComienzo, duracionEnMinutos, numeroTelefonoLlama, numeroTelefonoRecibe);
	}

	@Test
	void testCalcularMontoLlamada() {
		assertEquals(1, llamada.calcularMontoLlamada());
	}

}
