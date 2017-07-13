package teststrutturale;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Sistema;
import prenotazioneesami.UtenteRegistrato;

public class AutenticazioneTest {
	
	ArrayList<UtenteRegistrato> ut = new ArrayList<UtenteRegistrato>();
	
	private int expectedResult;
	private static Sistema sistema = null;
	private static UtenteRegistrato utente = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sistema = new Sistema();
		System.out.println("Crea Oggetto Sistema");
		utente = new UtenteRegistrato();
		System.out.println("Crea Oggetto Utente");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
			FileReader file;
			file=new FileReader("src/prenotazioneesami/utentiRegistrati");
			BufferedReader bufferUtenti;
			bufferUtenti=new BufferedReader(file);
			String line; 
			line=bufferUtenti.readLine();
		    
		  /*Il file utentiRegistrati è così organizzato:
		     * matricola studente/docente
		     * nome
		     * cognome
		     * email
		     * password*/
			while (line!=null) {
				UtenteRegistrato utenti = new UtenteRegistrato();
				utenti.setMatricola(line);
		   	
				if (utenti.getMatricola().length()>4) {
					utenti.setS_D(true);//setto a true lo studente
				} else {
					utenti.setS_D(false);
				}
				
				line=bufferUtenti.readLine();
				utenti.setNome(line);
		    	
				line=bufferUtenti.readLine();
				utenti.setCognome(line);
		    	
				line=bufferUtenti.readLine();
				utenti.setEmail(line);
		    	
				line=bufferUtenti.readLine();
				utenti.setPassword(line);
		    	
				ut.add(utenti); 
		    	
				line=bufferUtenti.readLine();   
			}
		    
			bufferUtenti.close();
			sistema.setUtente(ut);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMatricolaOkLunghezzaOkStudente() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		utente = new UtenteRegistrato("s3503777", "Maurilia",
									"Quinci", "mau@gmail.com",
									"3503", true);
		expectedResult=0;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
	@Test
	public void testMatricolaOkLunghezaOkDocente() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@g.it","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=2;
		
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
	@Test
	public void testMatricolaErrataStudente() {
		utente = new UtenteRegistrato("3503777", "Maurilia",
									"Quinci", "mau@gmail.com",
									"3503", true);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-3;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
	@Test
	public void testMatricolErrataLunghezzaOk() {
		utente = new UtenteRegistrato("d789", "Angelo","Morro", "am@t","1", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-3;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(),
											utente.getS_D()));	
	}
	
	@Test
	public void testMatricolaErrataDocente() {
		utente = new UtenteRegistrato("125", "Angelo","Morro", "am@g.it","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-3;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
		
	@Test
	public void testDocenteNonStudente() {
		utente = new UtenteRegistrato("d125", "Maurilia",
										"Quinci", "mau@gmail.com",
										"3503", true);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-2;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
	@Test
	public void testStudenteNonDocente() {
		utente = new UtenteRegistrato("s3503777", "Mario",
										"Rossi", "rossi@gmail.com",
										"125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaMatricola(utente.getMatricola(), utente.getS_D()));	
	}
	
	
	
	@Test
	public void testMatricolCorrettaPasswordCorretta() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@g.it","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=2;
		assertEquals(this.expectedResult, 
				sistema.verificaPassword(utente.getMatricola(), 
											utente.getPassword(), 0,
											utente.getS_D()));	
	}
	
	@Test
	public void testMatricolCorrettaPasswordCorrettatentativo4() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@g.it","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaPassword(utente.getMatricola(), 
											utente.getPassword(), 3,
											utente.getS_D()));	
	}
	@Test
	public void testMatricolCorrettaPasswordErrataTentativo1() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@g.it","1455", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaPassword(utente.getMatricola(), 
											utente.getPassword(), 0,
											utente.getS_D()));	
	}
	
	@Test
	public void testMatricolCorrettaPasswordErrataTentativo4() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@t","1", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaPassword(utente.getMatricola(), utente.getPassword(), 3, utente.getS_D()));	
	}
	
	@Test
	public void testMatricolErrata() {
		utente = new UtenteRegistrato("d5487", "Angelo","Morro", "am@t","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaPassword(utente.getMatricola(), utente.getPassword(), 3, utente.getS_D()));	
	}
	
	
	
	@Test
	public void testEmailCorretta() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "am@g.it","155", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=2;
		assertEquals(this.expectedResult, 
				sistema.verificaEmail(utente.getMatricola(),
										utente.getS_D(), utente.getEmail()));
	}
	
	@Test
	public void testEmailErrata() {
		utente = new UtenteRegistrato("d125", "Angelo","Morro", "amit","125", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaEmail(utente.getMatricola(), 
										utente.getS_D(), utente.getEmail()));
	}
	
	@Test
	public void testPasswordErrataTentativo4EmailErrata() {
		utente = new UtenteRegistrato("s451255", "Angelo","Morro", "am@t","187", false);
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		expectedResult=-1;
		assertEquals(this.expectedResult, 
				sistema.verificaEmail(utente.getMatricola(),
										utente.getS_D(), utente.getEmail()));	
	}
	
	
	
	
	
	
	
	
	
	
	

}
