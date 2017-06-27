import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.CarrieraStudente;
import prenotazioneesami.Esame;
import prenotazioneesami.Insegnamento;
import prenotazioneesami.Prenotazione;
import prenotazioneesami.Promemoria;
import prenotazioneesami.Studente;

public class TestStudente {
	
	private ArrayList<Prenotazione> expectedResultp;
	ArrayList<Prenotazione> prenotazioni= new ArrayList<Prenotazione>();
	CarrieraStudente carriera = new CarrieraStudente();
	ArrayList<Esame> esami = new ArrayList<Esame>();
	CarrieraStudente c = new CarrieraStudente();
	
	private static Studente studente = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studente = new Studente();
		System.out.println("Crea Studente");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
									"mario1254", true, false, false, false);
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		Prenotazione p = new Prenotazione(10, promo, i, studente);
		prenotazioni.add(p);
		ArrayList<Insegnamento> ins = new ArrayList<Insegnamento>();
		ins.add(i);
		c = new CarrieraStudente(ins,studente);
		Esame e = new Esame(30, null, "superato", studente, i);
		esami.add(e);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCostruttoreMatricola() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,studente.getMatricola().equals("s4236888"));	
	}
	
	@Test
	public void testCostruttoreNome() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,studente.getNome().equals("Mario"));	
	}
	
	@Test
	public void testCostruttoreCognome() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,studente.getCognome().equals("Rossi"));	
	}
	
	@Test
	public void testCostruttoreEmail() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,studente.getEmail().equals("mariorossi@gmail.com"));	
	}
	
	@Test
	public void testCostruttorePass() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,studente.getPassword().equals("mario1254"));	
	}
	
	@Test
	public void testCostruttoreStudente() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertTrue("studente",studente.getS_D());	
	}
	
	@Test
	public void testCostruttoreValutazione() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertFalse("valutazione",studente.isValutazione());	
	}
	
	@Test
	public void testCostruttoreTassa() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertFalse("tassa",studente.isPagamentoTassa());	
	}
	
	@Test
	public void testCostruttoreAccettaVoto() {
		assertNotNull("Oggetto Docente non istanziato",studente);
		studente = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertFalse("studente",studente.isAccettaVotoEsame());	
	}
	
	
	@Test
	public void testValutazione() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setValutazione(true);
		assertTrue("Valutazione ok",studente.isValutazione());
	}
	
	@Test
	public void testPagamentoTasse() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setPagamentoTassa(false);
		assertFalse("No pagamento tassa",studente.isPagamentoTassa());
	}
	
	@Test
	public void testAccettaVoto() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setAccettaVotoEsame(true);
		assertTrue("Accetta voto",studente.isAccettaVotoEsame());
	}
	
	@Test
	public void testSetGetPrenotazioni() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setPrenotazione(prenotazioni);
		expectedResultp = prenotazioni;
		assertEquals(this.expectedResultp,studente.getPrenotazione());
	}
	
	@Test
	public void testCarriera() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setCarriera(c);
		CarrieraStudente expectedResultC  = c;
		assertEquals(expectedResultC, studente.getCarriera());
	}
	
	@Test
	public void testEsame() {
		assertNotNull("Oggetto Studente non istanziato", studente);
		studente.setEsame(esami);
		ArrayList<Esame> expectedResultE = esami;
		assertEquals(expectedResultE, studente.getEsame());
	}
	
}
