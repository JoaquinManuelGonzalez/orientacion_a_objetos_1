package ar.edu.unlp.info.oo1.ejercicio_12_volumen_y_superficie_de_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeConstruccionTest {

	private ReporteDeConstruccion report;
	private ReporteDeConstruccion reportVacio;
	private Cilindro c;
	private Cilindro cNoCumple;
	private Esfera e;
	private Esfera eNoCumple;
	private PrismaRectangular p;
	private PrismaRectangular pNoCumple;
	
	@BeforeEach
	void setUp() throws Exception {
		report = new ReporteDeConstruccion();
		reportVacio = new ReporteDeConstruccion();
		c = new Cilindro("Hierro", "Rojo", 5, 5);
		cNoCumple = new Cilindro("Acero", "Verde", 7, 1);
		e = new Esfera("Hierro", "Rojo", 5);
		eNoCumple = new Esfera("Aluminio", "Naranja", 3);
		p = new PrismaRectangular("Hierro", "Rojo", 7, 6, 5);
		pNoCumple = new PrismaRectangular("Cobre", "Negro", 4, 3, 2);
	}

	@Test
	void testReporteDeConstruccion() {
		assertNotNull(report.getPiezas());
		assertNotNull(reportVacio.getPiezas());
	}

	@Test
	void testAddPieza() {
		report.addPieza(e);
		report.addPieza(p);
		report.addPieza(c);
		report.addPieza(cNoCumple);
		report.addPieza(eNoCumple);
		report.addPieza(pNoCumple);
		assertEquals(6, report.getPiezas().size());
		assertEquals(0, reportVacio.getPiezas().size());
	}

	@Test
	void testVolumenDeMaterial() {
		assertEquals(1127, Math.round(report.volumenDeMaterial("Hierro")));
		assertEquals(0, Math.round(reportVacio.volumenDeMaterial("Hierro")));
	}

	@Test
	void testGetSuperficieDeColor() {
		assertEquals(842, Math.round(report.getSuperficieDeColor("Rojo")));
		assertEquals(0, Math.round(reportVacio.getSuperficieDeColor("Rojo")));
	}

}
