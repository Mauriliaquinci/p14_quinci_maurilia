import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prenotazioneesami.CarrieraStudente;
import prenotazioneesami.Insegnamento;
import prenotazioneesami.Prenotazione;
import prenotazioneesami.Promemoria;
import prenotazioneesami.Sistema;
import prenotazioneesami.Studente;

public class PrenotazioneEsameTest {
	
	Studente s = new Studente();
	Insegnamento ins = new Insegnamento();
	Promemoria prome = new Promemoria(null,null,null);
	
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	ArrayList<CarrieraStudente> carriere = new ArrayList<CarrieraStudente>();
	
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
		
			FileReader file1;
			file1=new FileReader("src/prenotazioneesami/carriereStudenti");
		    BufferedReader bufferInsegn;
		    bufferInsegn=new BufferedReader(file1);
		    String line, codice, nome, cfu, appello;
		    line=bufferInsegn.readLine();
		   	/*Lettura file Insegnamenti cosi organizzato:
		   	 * matricola
		   	 * n numero insegnamenti prenotabili
		   	 * n righe che descrivono un insegnamento composte da:
		   	 * 	Codice Nome CFU Appello1 Appello2 Appello3
		   	 * */	   
		    while(line!=null) {
		    	
		    	ArrayList<Insegnamento> materie= new ArrayList<Insegnamento>();
		    	Studente st_iesimo = new Studente();
		    	CarrieraStudente c = new CarrieraStudente();
		    	
		    	st_iesimo.setMatricola(line); 
		    	line=bufferInsegn.readLine(); 
		    	int num= Integer.parseInt(line);
		    	line=bufferInsegn.readLine();
		    	
		    	for (int i=0; i<num; i++) {
		    		ArrayList<String> appel = new ArrayList<String>();
		    		Insegnamento ins = new Insegnamento(null,null,null,null, null, null, null);
		    		StringTokenizer st = new StringTokenizer(line); //divido in token la riga
		    		
		    		while (st.hasMoreTokens()) {
		    			codice=st.nextToken();
		    			ins.setCodice(codice);
		    			nome=st.nextToken();
		    			ins.setNome(nome);
		    			cfu=st.nextToken();
		    			ins.setCfu(cfu);
		    			
		    			for (int h=0; h<3; h++) {
		    				appello=st.nextToken();
		    				appel.add(appello);
		    			}
		    			
		    			ins.setAppello(appel);
		    			materie.add(ins);
		    		}
		    		line=bufferInsegn.readLine(); 
		    	}	
		    	c.setListaInsegnamento(materie);    
		    	c.setStudente(st_iesimo);
		    	carriere.add(c);			       
		    }
		    
		    bufferInsegn.close();
		     
		    /*Richiamo la funzione dalla classe sistema per settare le carriere di ogni studente*/
		    sistema.setCarrStud(carriere); 
		
		
	}
		

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testStudenteInsegnamAppelloOk() {
		s = new Studente("s3503777", null, null, 
						null, null, false, false, false, false);
		ins = new Insegnamento("45962", "Matematica", "9", "LT");
		String appello = "20/06/2016";
		prenotazioni.clear();
		sistema.setPrenotazioni(prenotazioni);
		int expectedResult = 0;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, appello));
	}
	
	
	@Test
	public void testCarrieraVuota() {
		carriere.clear();
		sistema.setCarrStud(carriere);
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
	}
	
	
	@Test
	public void testNonesisteCarrieraStudente() {
		s = new Studente("s4521877", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento(null,null,null,null);
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
	}
	
	
	@Test
	public void testListaInsegnamentoVuota() {
		sistema.getCarrStud().get(0).getListaInsegnamento().clear();
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
	}
	
	
	@Test
	public void testInsegnamentoNonPresente() {
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("80154", "Software Engineering", "9", "LM");
		
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
	}
	
	
	@Test
	public void testPrenotazioneGiaPresente() {
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("45962", "Matematica", "9", "LT");
		Prenotazione prenot = new Prenotazione(0,null,ins,s);
		prenotazioni.add(prenot);
		sistema.setPrenotazioni(prenotazioni);
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
	}
	
	
	@Test
	public void testPrenotazioneNonPresentePrenotVuota() {
		prenotazioni.clear();
		sistema.setPrenotazioni(prenotazioni);
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("52369", "Fisica", "6", "LT");
		String appello = "2/09/2017";
		int expectedResult = 0;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, appello));
	}

	@Test
	public void testPrenotazioneNonPresentePrenotPiena() {
		
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("52369", "Fisica", "6", "LT");
		String appello = "2/09/2017";
		int expectedResult = 0;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, appello));
	}
	
	@Test
	public void testAppelloNonValido() {
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("52369", "Fisica", "6", "LT");
		String appello = "14/06/2017";
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, appello));
	}
	
	@Test
	public void testMatricolaNoCodiceSi() {
		prenotazioni.clear();
		s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		ins = new Insegnamento("52369", "Fisica", "6", "LT");
		Prenotazione prenot = new Prenotazione(0,null,ins,s);
		prenotazioni.add(prenot);
		sistema.setPrenotazioni(prenotazioni);
		s = new Studente("s4236888", null, null, 
				null, null, false, false, false, false);
		int expectedResult = 1;
		assertEquals(expectedResult, sistema.PrenotazioneEsame(s, ins, null));
		
	}
	
	
	

}
