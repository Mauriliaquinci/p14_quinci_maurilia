package teststrutturale;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Esame;
import prenotazioneesami.Insegnamento;
import prenotazioneesami.Studente;

public class TestEsame {
	
	Studente s;
	private int expectedResult;
	private ArrayList<String> expectedResultTipo;
	private String expectedResultEsito;
	private Studente expectedResultStudente;
		
	private static Esame esame = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		esame = new Esame(0, null, null, null,null);
		System.out.println("Crea Esame");
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
	public void testCostruttoreEsameVoto() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		esame = new Esame(30, tipo, null, s,i);
		assertEquals(30, esame.getVoto());
	}
	
	@Test
	public void testCostruttoreEsameTipo() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		esame = new Esame(30, tipo, null, s,i);
		assertEquals(tipo, esame.getTipo());
	}
	
	@Test
	public void testCostruttoreEsameEsito() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		esame = new Esame(30, tipo, "superato", s,i);
		assertEquals("superato", esame.getEsitoVerbale());
	}
	
	@Test
	public void testCostruttoreEsameStudente() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		esame = new Esame(30, tipo, null, s,i);
		assertEquals(s, esame.getStudente());
	}
	
	@Test
	public void testCostruttoreEsameIns() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		Insegnamento i = new Insegnamento("42515", "Matematica", "9", "LT");
		esame = new Esame(30, tipo, null, s,i);
		assertEquals(i, esame.getInsegnamento());
	}
	
	@Test
	public void testVoto() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		esame.setVoto(30);
		expectedResult = 30;
		int result = esame.getVoto();
		assertEquals(this.expectedResult, result);
	}
	
	@Test
	public void testTipo() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("scritto");
		tipo.add("orale");
		esame.setTipo(tipo);
		expectedResultTipo = tipo;
		ArrayList<String> result = esame.getTipo();
		assertEquals(this.expectedResultTipo, result);
	}
	
	@Test
	public void testEsitoVerbale() {
		assertNotNull("Oggetto Esame non istanziato", esame);	
		esame.setEsitoVerbale("superato");
		expectedResultEsito = "superato";
		String result = esame.getEsitoVerbale();
		assertEquals(this.expectedResultEsito, result);
	}
	
	@Test
	public void testStudente() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, true);
		esame.setStudente(s);
		expectedResultStudente = s;
		Studente result = esame.getStudente();
		assertEquals(this.expectedResultStudente, result);
		
	}
	
	@Test
	public void testInsegnamento() {
		Insegnamento insegnamento = new Insegnamento("80154", "Matematica", "9", "LT");
		esame.setInsegnamento(insegnamento);
		assertEquals(insegnamento, esame.getInsegnamento());
		
	}
	
	
	
	@Test
	public void testAccettaVoto() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, true);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(30);
		assertTrue("Voto maggiore di 18, accettato", result );
		
	}
	
	@Test
	public void testNonAccettaVoto() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(17);
		assertFalse("Voto minore di 18", result );
		
	}
	
	@Test
	public void testAccettaVotoFalse() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, true);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(17);
		assertFalse("Voto minore di 18, accettato", result );
		
	}
	
	@Test
	public void testAccettaVotoFalse2() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(30);
		assertFalse("Voto maggiore di18, accettato",result );
		
	}

	@Test
	public void testVerbalizzaEsameSup() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, true);
		esame.setStudente(s);
		esame.isAccettaVoto(30);
		esame.verbalizzaEsame();	
		String expectedResult = "superato";
		assertEquals(expectedResult, esame.getEsitoVerbale());
	}
	
	@Test
	public void testVerbalizzaEsameRit() {
		Studente s = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com", "mario125", true, false, false, false);
		esame.setStudente(s);
		esame.isAccettaVoto(30);
		esame.verbalizzaEsame();	
		String expectedResult = "ritirato";
		assertEquals(expectedResult, esame.getEsitoVerbale());
	}

	
	
	
	
	
	
	

}
