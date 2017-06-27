import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Insegnamento;
import prenotazioneesami.Prenotazione;
import prenotazioneesami.Promemoria;
import prenotazioneesami.Studente;

public class TestPrenotazione {
	
	Promemoria promemoria = new Promemoria(null, null, null);
	Studente studente = new Studente ();
	Insegnamento insegnamento = new Insegnamento();
	Prenotazione prenot = new Prenotazione();
	private int expectedResult;
	
	private static Prenotazione prenotazione = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prenotazione = new Prenotazione();
		System.out.println("Crea Oggetto Prenotazione");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public void testCostruttoreCodice() {
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		Studente s = new Studente("s4236888", "Mario", "Rossi", 
				"mariorossi@gmail.com", "mario1254", false, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		prenotazione = new Prenotazione(10,promo, i, s);
		assertEquals(10, prenotazione.getCodPrenotazione());
	}
	
	@Test 
	public void testCostruttorepromemoria() {
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		Studente s = new Studente("s4236888", "Mario", "Rossi", 
				"mariorossi@gmail.com", "mario1254", false, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		prenotazione = new Prenotazione(10,promo, i, s);
		assertEquals(promo, prenotazione.getPromemoria());
	}
	
	@Test 
	public void testCostruttoreStudente() {
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		Studente s = new Studente("s4236888", "Mario", "Rossi", 
				"mariorossi@gmail.com", "mario1254", false, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		prenotazione = new Prenotazione(10,promo, i, s);
		assertEquals(s, prenotazione.getStudenti());
	}
	
	@Test 
	public void testCostruttoreInsegnamento() {
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		Studente s = new Studente("s4236888", "Mario", "Rossi", 
				"mariorossi@gmail.com", "mario1254", false, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		prenotazione = new Prenotazione(10,promo, i, s);
		assertEquals(i, prenotazione.getInsegnamento());
	}
	
	@Test
	public void testSetGetCodice() {
		prenotazione.setCodPrenotazione(10);
		expectedResult= 10;
		assertEquals(this.expectedResult, prenotazione.getCodPrenotazione());
	}
	
	@Test
	public void testSetGetPromo() {
		Promemoria promo = new Promemoria("21/06/2017", "G2a", "09:00");
		prenotazione.setPromemoria(promo);
		Promemoria expectedResultp= promo;
		assertEquals(expectedResultp, prenotazione.getPromemoria());
	}
	
	@Test
	public void testSetGetStudente() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", 
			"mariorossi@gmail.com", "mario1254", false, false, false, false);
		prenotazione.setStudenti(s);
		Studente expectedResults = s;
		assertEquals(expectedResults, prenotazione.getStudenti());
	}
	
	@Test
	public void testSetGetInsegnamento() {
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		prenotazione.setInsegnamento(i);
		Insegnamento expectedResults = i;
		assertEquals(expectedResults, prenotazione.getInsegnamento());
	}
	
}
