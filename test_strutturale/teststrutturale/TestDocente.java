package teststrutturale;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Docente;
import prenotazioneesami.Insegnamento;

public class TestDocente {
	
	ArrayList<Insegnamento> i = new ArrayList<Insegnamento>();
	private ArrayList<Insegnamento> expectedResult;
	private static Docente d=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		d = new Docente();
		System.out.println("Crea Docente");
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
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertEquals(true,d.getMatricola().equals("d125"));	
	}
	
	@Test
	public void testCostruttoreNome() {
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertEquals(true,d.getNome().equals("Mario"));	
	}
	
	@Test
	public void testCostruttoreCognome() {
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertEquals(true,d.getCognome().equals("Rossi"));	
	}
	
	@Test
	public void testCostruttoreEmail() {
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertEquals(true,d.getEmail().equals("mariorossi@gmail.com"));	
	}
	
	@Test
	public void testCostruttorePass() {
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertEquals(true,d.getPassword().equals("mario1254"));	
	}
	
	@Test
	public void testCostruttoreDocente() {
		assertNotNull("Oggetto Docente non istanziato",d);
		d = new Docente("d125", "Mario", "Rossi", "mariorossi@gmail.com", "mario1254", false);
		assertFalse("docente",d.getS_D());	
	}
	
	
	@Test
	public void tetSetGetInsegnamenti() {
		assertNotNull("Oggetto Docente non istanziato",d);
		Insegnamento ins = new Insegnamento ("80154", "Software Engineering", "9", "LM");
		i.add(ins);
		d.setInsegnamenti(i);
		expectedResult= i;
		ArrayList<Insegnamento> result = d.getInsegnamenti();
		assertEquals(this.expectedResult, result);
		
	}

}
