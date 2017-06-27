

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Studente;
import prenotazioneesami.UtenteRegistrato;

public class TestUtenteRegistrato {
	
	private String expectedResult;
	private static UtenteRegistrato utente_registrato = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		utente_registrato = new UtenteRegistrato();
		System.out.println("Crea Oggetto Utente Registrato");
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
	public void testCostruttoreMatricola() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,utente_registrato.getMatricola().equals("s4236888"));	
	}
	
	@Test
	public void testCostruttoreNome() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,utente_registrato.getNome().equals("Mario"));	
	}
	
	@Test
	public void testCostruttoreCognome() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,utente_registrato.getCognome().equals("Rossi"));	
	}
	
	@Test
	public void testCostruttoreEmail() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,utente_registrato.getEmail().equals("mariorossi@gmail.com"));	
	}
	
	@Test
	public void testCostruttorePass() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertEquals(true,utente_registrato.getPassword().equals("mario1254"));	
	}
	
	@Test
	public void testCostruttoreStudente() {
		assertNotNull("Oggetto Docente non istanziato",utente_registrato);
		utente_registrato = new Studente("s4236888", "Mario", "Rossi", "mariorossi@gmail.com",
				"mario1254", true, false, false, false);
		assertTrue("studente",utente_registrato.getS_D());	
	}
	
	@Test
	public void testSetGetMatricola() {
		utente_registrato.setMatricola("4236888");
		expectedResult = "4236888";
		assertEquals(this.expectedResult, utente_registrato.getMatricola());
	}
	
	@Test
	public void testSetGetNome() {
		utente_registrato.setNome("Mario");
		expectedResult = "Mario";
		assertEquals(this.expectedResult, utente_registrato.getNome());
	}
	
	@Test
	public void testSetGetCognome() {
		utente_registrato.setCognome("Rossi");
		expectedResult = "Rossi";
		assertEquals(this.expectedResult, utente_registrato.getCognome());
	}
	
	@Test
	public void testSetGetEmail() {
		utente_registrato.setEmail("mariorossi@gmail.com");
		expectedResult = "mariorossi@gmail.com";
		assertEquals(this.expectedResult, utente_registrato.getEmail());
	}
	
	@Test
	public void testSetGetPassword() {
		utente_registrato.setPassword("mario456");
		expectedResult = "mario456";
		assertEquals(this.expectedResult, utente_registrato.getPassword());
	}
	
	@Test
	public void testSetGetStud() {
		utente_registrato.setS_D(true);
		assertTrue("E' uno studente", utente_registrato.getS_D());
	}
	
	@Test
	public void testSetGetDocente() {
		utente_registrato.setS_D(true);
		assertTrue("E' un Docecnte", utente_registrato.getS_D());
	}
	
	

}
