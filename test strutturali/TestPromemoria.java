import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.Promemoria;

public class TestPromemoria {
	
	private String expectedResult;
	
	private static Promemoria promemoria = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		promemoria = new Promemoria(null, null, null);
		System.out.println("Crea Oggetto Promemoria");
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
	public void testCostruttoreData() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		assertEquals("21/06/2017", promemoria.getData());
	}
	
	@Test
	public void testCostruttoreAula() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		assertEquals("G2a", promemoria.getAula());
	}
	
	@Test
	public void testCostruttoreOrario() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		assertEquals("09:00", promemoria.getOrario());
	}
	
	@Test
	public void testSetGetData() {
		promemoria.setData("21/06/2017");
		expectedResult= "21/06/2017";
		assertEquals(this.expectedResult, promemoria.getData());
	}
	
	@Test
	public void testSetGetAula() {
		promemoria.setAula("G2a");
		expectedResult= "G2a";
		assertEquals(this.expectedResult, promemoria.getAula());
	}
	
	@Test
	public void testSetGetOrario() {
		promemoria.setOrario("09:00");
		expectedResult= "09:00";
		assertEquals(this.expectedResult, promemoria.getOrario());
	}
	
	@Test
	public void testStampaPromData() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		promemoria.stampaPromemoria(promemoria);
		assertEquals("21/06/2017", promemoria.getData());
	}
	
	@Test
	public void testStampaPromAula() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		promemoria.stampaPromemoria(promemoria);
		assertEquals("G2a", promemoria.getAula());		
	}
	
	@Test
	public void testStampaPromOrario() {
		promemoria = new Promemoria("21/06/2017", "G2a", "09:00");
		promemoria.stampaPromemoria(promemoria);
		assertEquals("09:00", promemoria.getOrario());
		
	}
}
