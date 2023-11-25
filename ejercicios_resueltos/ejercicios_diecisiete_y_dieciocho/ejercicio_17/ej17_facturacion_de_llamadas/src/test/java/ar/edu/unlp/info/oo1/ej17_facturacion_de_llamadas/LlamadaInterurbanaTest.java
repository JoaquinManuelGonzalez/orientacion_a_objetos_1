package ar.edu.unlp.info.oo1.ej17_facturacion_de_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInterurbanaTest {
	
	private LocalDate fechaComienzo;
	private LocalTime horaComienzo;
	private double duracionEnMinutos;
	private String numeroTelefonoLlama;
	private String numeroTelefonoRecibe;
	private double distanciaEnKilometros99;
	private double distanciaEnKilometros100;
	private double distanciaEnKilometros500;
	private double distanciaEnKilometros501;
	private LlamadaTelefonica llamada99;
	private LlamadaTelefonica llamada100;
	private LlamadaTelefonica llamada500;
	private LlamadaTelefonica llamada501;

	@BeforeEach
	void setUp() throws Exception {
		fechaComienzo = LocalDate.of(2023, 11, 9);
		horaComienzo = LocalTime.of(19, 0);
		duracionEnMinutos = 1;
		numeroTelefonoLlama = "123";
		numeroTelefonoLlama = "456";
		distanciaEnKilometros99 = 99;
		distanciaEnKilometros100 = 100;
		distanciaEnKilometros500 = 500;
		distanciaEnKilometros501 = 501;
		
		llamada99 = new LlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				distanciaEnKilometros99);
		
		llamada100 = new LlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				distanciaEnKilometros100);
		
		llamada500 = new LlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				distanciaEnKilometros500);
		
		llamada501 = new LlamadaInterurbana(fechaComienzo,
				horaComienzo,
				duracionEnMinutos,
				numeroTelefonoLlama,
				numeroTelefonoRecibe,
				distanciaEnKilometros501);
	}

	@Test
	void testCalcularMontoLlamada() {
		//MENOR QUE 100
		assertEquals(7, llamada99.calcularMontoLlamada());
		
		//100
		assertEquals(7.5, llamada100.calcularMontoLlamada());
		
		//500
		assertEquals(7.5, llamada500.calcularMontoLlamada());
		
		//MAYOR QUE 500
		assertEquals(8, llamada501.calcularMontoLlamada());
	}

}
