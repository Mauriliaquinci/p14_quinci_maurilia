package testfunzionale;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Esame;
import prenotazioneesami.Studente;

public class TestAccettaRifiutaVoto {
	
	Studente s;		
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

	/*Scenario principale in cui uno studente accetta il voto.*/
	@Test
	public void testAccettaVoto() {
		Studente s = new Studente("s4236888", "Mario", "Rossi",
								"mariorossi@gmail.com", "mario125",
								true, false, false, true);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(30);
		assertTrue("Voto maggiore di 18, accettato", result );
	}
	
	/*Scenario principale in cui uno studente rifiuta il voto.*/
	@Test
	public void testRifiutaVoto() {
		Studente s = new Studente("s4236888", "Mario", "Rossi",
								"mariorossi@gmail.com", "mario125",
								true, false, false, false);
		esame.setStudente(s);
		boolean result = esame.isAccettaVoto(30);
		assertFalse("Voto maggiore di 18, accettato", result);
	}

}
