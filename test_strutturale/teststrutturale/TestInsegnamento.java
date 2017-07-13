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
import prenotazioneesami.Prenotazione;

public class TestInsegnamento {
	
	private String expectedResult;
	private Esame expectedResultEsame;
	private ArrayList<Prenotazione> expectedResultPrenot;
	
	private static Insegnamento insegnamento = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		insegnamento = new Insegnamento();
		System.out.println("Crea oggetto insegnamento");
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
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals("80154",insegnamento.getCodice());
	}
	
	@Test
	public void testCostruttoreNome() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals("Matematica",insegnamento.getNome());
	}
	
	@Test
	public void testCostruttoreCfu() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals("9",insegnamento.getCfu());
	}
	
	@Test
	public void testCostruttoreClasse() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals("LT",insegnamento.getClasse());
	}
	
	@Test
	public void testCostruttoreAppello() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals(appello,insegnamento.getAppello());
	}
	
	@Test
	public void testCostruttoreEsame() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals(esame,insegnamento.getEsame());
	}
	
	@Test
	public void testCostruttorePrenotazione() {
		assertNotNull("Oggetto Insegnamento non creato", insegnamento);
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		Esame esame = new Esame(0, null, "superato", null,ins);
		Prenotazione p = new Prenotazione(10, null, insegnamento, null);
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		prenotazione.add(p);
		insegnamento = new Insegnamento("80154", "Matematica", "9", "LT",appello, esame, prenotazione);
		assertEquals(prenotazione,insegnamento.getPrenotazione());
	}
	
	
	@Test
	public void testSetCodice() {
		expectedResult= "80154";
		insegnamento.setCodice("80154");
		String result = insegnamento.getCodice();
		assertEquals(true, result.equals(expectedResult));
	}

	
	@Test
	public void testSetGetNome() {
		expectedResult= "Matematica";
		insegnamento.setNome("Matematica");
		String result = insegnamento.getNome();
		assertEquals(true, result.equals(expectedResult));
	}
	
	@Test
	public void testSetGetCfu() {
		expectedResult= "9";
		insegnamento.setCfu("9");	
		String result = insegnamento.getCfu();
		assertEquals(true, result.equals(expectedResult));
	}
	
	@Test
	public void testSetGetClasse() {
		expectedResult= "LT";
		insegnamento.setClasse("LT");	
		String result = insegnamento.getClasse();
		assertEquals(true, result.equals(expectedResult));
	}
	
	@Test
	public void testSetGetEsame() {
		Insegnamento ins = new Insegnamento("80154", "Matematica", "9", "LT");
		Esame exame = new Esame(0, null, "superato", null,ins);
		expectedResultEsame= exame;
		insegnamento.setEsame(exame);	
		Esame result = insegnamento.getEsame();
		assertEquals(true, result.equals(expectedResultEsame));
	}
	
	@Test
	public void testSetGetPrenotaazione() {
		Prenotazione p = new Prenotazione(10, null, null, null);
		ArrayList<Prenotazione>  lista_p= new ArrayList<Prenotazione>();
		lista_p.add(p);
		expectedResultPrenot=  lista_p;
		insegnamento.setPrenotazione(lista_p);	
		ArrayList<Prenotazione> result = insegnamento.getPrenotazione();
		assertEquals(true, result.equals(expectedResultPrenot));
	}
	
	@Test
	public void testSetGetAppello() {
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		insegnamento.setAppello(appello);
		ArrayList<String> expectedResultAppello = appello;
		ArrayList<String> result = insegnamento.getAppello();
		assertEquals(true, result.equals(expectedResultAppello ));
	}
	
	@Test
	public void testAddAppelloEmpty() {
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		insegnamento.setAppello(appello);
		int expectedResultAppello = 0;
		int result = insegnamento.addAppello("05/05/2017");
		assertEquals(expectedResultAppello, result);
	}
	
	@Test
	public void testAddAppelloFull() {
		ArrayList<String> appello = new ArrayList<String>();
		appello.add("21/06/2017");
		appello.add("22/06/2017");
		appello.add("23/06/2017");
		insegnamento.setAppello(appello);
		int expectedResultAppello = 1;
		int result = insegnamento.addAppello("05/05/2017");
		assertEquals(expectedResultAppello, result);
	}
	
	
	

}
