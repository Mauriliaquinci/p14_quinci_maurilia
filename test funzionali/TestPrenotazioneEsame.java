package testfunzionale;
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
import prenotazioneesami.Sistema;
import prenotazioneesami.Studente;

public class TestPrenotazioneEsame {
	
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

	/*Test dello scenario principale in cui uno studente effettua una prenotazione 
	 * esame*/
	
	@Test
	public void testScenarioPrincipale() {
		Studente s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		Insegnamento ins = new Insegnamento("45962", "Matematica", "9", "LT");
		String appello = "20/06/2016";
		prenotazioni.clear();
		sistema.setPrenotazioni(prenotazioni);
		assertEquals(0, sistema.PrenotazioneEsame(s, ins, appello));	
	}
	
	/*Test dello scenario alternativo in cui uno studente non trova l'esame a cui prenotarsi
	 * Nella descrizione dello scenario alternativo ho pensato che potrebbe esserci un
	 * problema a livello di sistema, cioè, uno studente vuole prenotarsi ad un esame 
	 * presente nella propria carriera ma non visibile nella sezione "prenotazione esame".
	 * Per simulare questo scenario alternativo considero il caso in cui uno studente vuole prenotare un
	 * insegnamento non presente nella propria carriera*/
	@Test
	public void test() {
		Studente s = new Studente("s3503777", null, null, 
				null, null, false, false, false, false);
		Insegnamento ins = new Insegnamento("12546", "RetiDiCalcolatori", "9", "LT");
		String appello="15/06/2017";
		assertEquals(1, sistema.PrenotazioneEsame(s, ins, appello));
	}

}
