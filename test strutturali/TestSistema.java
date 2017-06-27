import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.CarrieraStudente;
import prenotazioneesami.Insegnamento;
import prenotazioneesami.Prenotazione;
import prenotazioneesami.Sistema;
import prenotazioneesami.Studente;
import prenotazioneesami.UtenteRegistrato;

public class TestSistema {
	
	private Studente s = new Studente();
	private Studente s2 = new Studente();
	private ArrayList<Insegnamento> ins = new ArrayList<Insegnamento>();
	private ArrayList<Insegnamento> ins2 = new ArrayList<Insegnamento>();
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	ArrayList<CarrieraStudente> carriera = new ArrayList<CarrieraStudente>();
	ArrayList<UtenteRegistrato> utente = new ArrayList<UtenteRegistrato>();
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
		 s = new Studente("s3503777", "Maurilia",
									"Quinci", "mau@gmail.com",
									"3503", true, false, false, false);
		s2 = new Studente("s4236888", "Mario",
									"Rossi", "rossi@gmail.com",
									"4236", true, false, false, false);
		Insegnamento i = new Insegnamento("45962", "Matematica", "9", "LT");
		for (int h=0; h<40; h++) {
			ins.add(i);
		}
		for (int h=0; h<20; h++) {
			ins2.add(i);
		}
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testSetGetPrenotazioni() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		Studente s = new Studente("s3503777", "Maurilia",
				"Quinci", "mau@gmail.com",
				"3503", true, false, false, false);
		Insegnamento i = new Insegnamento("45962", "Matematica", "9", "LT");
		Prenotazione p = new Prenotazione(0, null, i, s);
		prenotazioni.add(p);
		sistema.setPrenotazioni(prenotazioni);
		assertEquals(prenotazioni, sistema.getPrenotazioni());
	}
	
	@Test
	public void testSetGetCarriera() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		Studente s = new Studente("s3503777", "Maurilia",
									"Quinci", "mau@gmail.com",
									"3503", true, false, false, false);
		Insegnamento i = new Insegnamento("45962", "Matematica", "9", "LT");
		ArrayList<Insegnamento> ins = new ArrayList<Insegnamento>();
		ins.add(i);
		CarrieraStudente c = new CarrieraStudente(ins,s);
		carriera.add(c);
		sistema.setCarrStud(carriera);
		assertEquals(carriera, sistema.getCarrStud());
	}
	
	@Test
	public void testSetGetUtenti() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		UtenteRegistrato u = new UtenteRegistrato("d1250","Mario","Rossi",
												"mariorossi@gmail.com", "mario1254",
												false);
		utente.add(u);
		sistema.setUtente(utente);
		assertEquals(true, sistema.getUtente().equals(utente));
	}
	
	
	@Test
	public void testCancellaCarrieraPresente() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		CarrieraStudente c = new CarrieraStudente(ins,s);
		CarrieraStudente c2 = new CarrieraStudente(ins2,s2);
		carriera.add(c2);
		carriera.add(c);
		sistema.setCarrStud(carriera);
		assertEquals(1, sistema.cancellaCarriera(s, c));	
	}
	
	@Test
	public void testCancellaCarrieraPresenteStudenteNo() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		Studente s1 = new Studente("s3503777", "Maurilia",
									"Quinci", "mau@gmail.com",
									"3503", true, false, false, false);
		CarrieraStudente c = new CarrieraStudente(ins,s);
		CarrieraStudente c2 = new CarrieraStudente(ins2,s2);
		carriera.add(c2);
		carriera.add(c);
		sistema.setCarrStud(carriera);
		assertEquals(1, sistema.cancellaCarriera(s1, c));	
	}
	
	@Test
	public void testCancellaCarrieraNonPresenteStudenteSi() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		
		CarrieraStudente c = new CarrieraStudente(ins,s);
		CarrieraStudente c2 = new CarrieraStudente(ins2,s2);
		carriera.add(c2);
		carriera.add(c);
		sistema.setCarrStud(carriera);
		assertEquals(-1, sistema.cancellaCarriera(s, c2));	
	}
	
	@Test
	public void testCancellaCarrieraListaInsegnamentoNonPiena() {
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		
		CarrieraStudente c = new CarrieraStudente(ins,s);
		CarrieraStudente c2 = new CarrieraStudente(ins2,s2);
		carriera.add(c2);
		carriera.add(c);
		sistema.setCarrStud(carriera);
		assertEquals(-1, sistema.cancellaCarriera(s2, c2));	
	}

}
