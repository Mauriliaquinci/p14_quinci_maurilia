package testfunzionale;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Sistema;
import prenotazioneesami.UtenteRegistrato;

public class LoginTest {
	
	ArrayList<UtenteRegistrato> ut = new ArrayList<UtenteRegistrato>();
	
	private static Sistema sistema = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sistema = new Sistema();
		System.out.println("Crea Oggetto Sistema");
		
	} 

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		UtenteRegistrato studente = new UtenteRegistrato("s3503777", "Maurilia", 
														"Quinci", "mau@gmail.com", 
														"3503", true);
		ut.add(studente);
		UtenteRegistrato docente = new UtenteRegistrato("d125", "Mario", "Rossi", 
														"mariorossi@gmail.com", 
														"mario123", false);
		ut.add(docente);
		sistema.setUtente(ut);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*Test dello scenario principale del caso d'uso Autenticazione
	 * in cui sia matricola che password sono corrette*/
	@Test
	public void testScenarioPrincipale() {
		assertEquals(0,sistema.verificaMatricola("s3503777", true));
		assertEquals(0, sistema.verificaPassword("s3503777", "3503", 0, true));	
	}
	
	/*Test dello scenario  alternativo del caso d'uso Autenticazione in cui la matricola è errata*/
	@Test
	public void testScenarioAlternativo3a() {
		assertEquals(-3,sistema.verificaMatricola("3503777", true));
		
	}
	
	/*Test dello scenario  alternativo del caso d'uso Autenticazione in cui la password è errata*/
	@Test
	public void testScenarioAlternativo5a() {
		assertEquals(-1, sistema.verificaPassword("s3503777", "35", 0, true));	
	}
	
	/*Test dello scenario  alternativo del caso d'uso Autenticazione in cui la password è errata
	 * e il tentativo di immissione password è maggiore di tre*/
	@Test
	public void testScenarioAlternativo5b() {
		assertEquals(-1, sistema.verificaPassword("s3503777", "35", 3, true));	
		assertEquals(0, sistema.verificaEmail("s3503777",true, "mau@gmail.com"));
	}
	
	/*Test dello scenario  alternativo del caso d'uso Autenticazione in cui
	 * l'email inserita dall'utente per inserire la nuova password è errata*/
	@Test
	public void testScenarioAlternativoEmailNonCorretta() {
		assertEquals(-1, sistema.verificaPassword("s3503777", "35", 3, true));	
		assertEquals(-1, sistema.verificaEmail("s3503777",true, "mmail.com"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
	

}
