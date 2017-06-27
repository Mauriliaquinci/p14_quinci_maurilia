import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.CarrieraStudente;
import prenotazioneesami.Insegnamento;
import prenotazioneesami.Studente;

public class TestCarrieraStudente {
	
	private int n_insegnamenti;
	Studente s;
	ArrayList<Insegnamento> i = new ArrayList<Insegnamento>();
	ArrayList<Insegnamento> i2 = new ArrayList<Insegnamento>();
	private ArrayList<Insegnamento> expectedResult;
	private Studente expectedResultStudente;
	private int expectedResultIns;
	
	private static CarrieraStudente carriera = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		carriera= new CarrieraStudente();
		System.out.println("Crea Carriera Studente");
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCostruttoreStudente() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("80154", "Software Engineering", "9", "LM");
		s= new Studente("s4236888", "Maurilia", "Quinci", "mau@gmail.com", "4236", true, false, false, false);
		i.add(ins);
		carriera = new CarrieraStudente(i,s);	
		assertEquals(s,carriera.getStudente());	
	}
	
	@Test
	public void testCostruttoreInsegnam() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("80154", "Software Engineering", "9", "LM");
		s= new Studente("s4236888", "Maurilia", "Quinci", "mau@gmail.com", "4236", true, false, false, false);
		i.add(ins);
		carriera = new CarrieraStudente(i,s);	
		assertEquals(i,carriera.getListaInsegnamento());	
	}
		
	@Test
	public void testSetGetInsegnamento() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("41254", "Matematica", "9", "LT");
		i.add(ins);
		carriera.setListaInsegnamento(i);	
		ArrayList<Insegnamento> result = carriera.getListaInsegnamento();
		expectedResult= i;
		assertEquals(this.expectedResult,result);
	}
	
	@Test
	public void testSetGetStuente() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		s= new Studente("s4236888", "Maurilia", "Quinci", "mau@gmail.com", "4236", true, false, false, false);
		carriera.setStudente(s);
		Studente result1 = carriera.getStudente();
		expectedResultStudente= s;
		assertEquals(this.expectedResultStudente,result1);
	}
	
	@Test
	public void testAddIns1() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("41254", "Matematica", "9", "LT");
		i.add(ins);
		expectedResult= i;
		carriera.setListaInsegnamento(i2);
		carriera.aggiungiInsegnamento(ins);
		assertEquals(this.expectedResult, carriera.getListaInsegnamento());
	}
	
	@Test
	public void testAddIns2() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("41254", "Matematica", "9", "LT");
		i.add(ins); 
		carriera.setListaInsegnamento(i);
		Insegnamento ins2 = new Insegnamento ("80154", "SE", "9", "LM");
		carriera.aggiungiInsegnamento(ins2);
		i.add(ins2);
		expectedResult= i;
		assertEquals(this.expectedResult, carriera.getListaInsegnamento());
	}
	
	@Test
	public void testNumIns() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		Insegnamento ins = new Insegnamento ("41254", "Matematica", "9", "LT");
		i.add(ins);
		carriera.setListaInsegnamento(i);
		n_insegnamenti= i.size();
		int result= carriera.getNumInsCarriera();
		expectedResultIns = n_insegnamenti;
		assertEquals(this.expectedResultIns, result);
	}
	
	@Test
	public void testNumMaxIns() {
		assertNotNull("Oggetto Carriera non istanziato",carriera);
		expectedResultIns= 40;
		int result = carriera.numMaxInsegnamento();
		assertEquals(this.expectedResultIns, result);
	}
	
}
