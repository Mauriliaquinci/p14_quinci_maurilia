package prenotazioneesami;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.StringTokenizer;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */
/**
 * Nel Menù Principale è possibile accedere in due aree: 
 * >Studente ->Prenotazione esami
 * 			 ->Visualizza esami prenotati
 * >Docente  ->Visualizza prenotazioni-insegnamento
 */


public class EsamiUni  {
	
	static Sistema sistema = new Sistema();
	static ArrayList<Integer> conta_accesso= new ArrayList<Integer>();
	static boolean accesso_studente;
	static boolean accesso_docente;
	static int intero=0;
	static Scanner input= new Scanner(System.in);
	static Scanner i = new Scanner(System.in);
	static char studente_docente='x';
	
	public static void main(String[] args) throws IOException {
			
			ArrayList<CarrieraStudente> carr_studente= new ArrayList<CarrieraStudente>();
		    String line;
		    String codice, nome, cfu, appello;
		    
		    FileReader f;
			f=new FileReader("src/prenotazioneesami/carriereStudenti");
		    BufferedReader bufferInsegn;
		    bufferInsegn=new BufferedReader(f);
		    
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
		    	carr_studente.add(c);			       
		    }
		    
		    bufferInsegn.close();
		     
		    /*Richiamo la funzione dalla classe sistema per settare le carriere di ogni studente*/
		    sistema.setCarrStud(carr_studente); 
		    /*Richiamo la funzione utentiRegistrati per memorizzare la lista degli utenti registrati*/
		    sistema.utentiRegistrati();
		  
		    menuPrincipale();
		    System.out.println("");
		    System.out.println("----------------- BENVENUTO ---------------");
	}
	
	
	
	@SuppressWarnings({ "unused" })
	public static void menuPrincipale() throws IOException {

		System.out.println("");
	    System.out.println("---------------MENU PRINCIPALE---------------");
	    System.out.println();
	    System.out.println("  "+ "s/S - Studente");
	    System.out.println("  "+ "d/D - Docente");
	    System.out.println("  "+ "l/L - Logout");
		
		UtenteRegistrato uten = new UtenteRegistrato();
		
	
	    do {
	    	studente_docente = i.next().charAt(0);
	    	
	    	switch (studente_docente) {
			case 's': 
				/*Se l'accesso viene effettuato da uno studente dopo che è stato effettuato 
				 * da un docente eseguo il logout e accedo come studente*/
			    if (accesso_docente==true) {
			    	sistema.logout();
		    		accesso_docente=false;
		    	}
			    	
		    	sistema.login(true); 
		    	
		    	if (accesso_studente==false) {
		    		accesso_studente=true; 	
		    	}
		    	
		    	/*Controllo se il login è avvenuto con successo 
		    	 * in caso contrario ritorno al menuPrincipale*/
		    	if (sistema.login(accesso_studente)==1) {
		    		menuPrincipale(); 
		    	} else { 
		    		menuPrincipaleStudente();
		    	}
		    	break;
		   				
		    case 'S':
		    	if (accesso_docente==true) {
					sistema.logout();
					accesso_docente=false;
		    	}
		    	
		    	sistema.login(true);// accedo come studente
				
		    	if (accesso_studente==false) {
		    		accesso_studente=true; 	
		    	}
		    	
				if (sistema.login(accesso_studente)==1) {
					menuPrincipale();
				} else {
					menuPrincipaleStudente();
				}
				break;
					    				
		    case 'd': 
		    	/*Se l'accesso viene effettuato da un docente dopo che è stato effettuato 
				 * da uno studente eseguo il logout e accedo come docente*/
		    	if (accesso_studente==true) {
					sistema.logout();
					accesso_studente=false;
				}
		    	
		    	System.out.println();
		    	sistema.login(false); // accedo come docente
		    	if (accesso_docente==false) {
		    		accesso_docente=true;
		    	}
		    						
		    	if (sistema.login(accesso_docente)==1) {
		    		menuPrincipale();
		    	} else {
		    		menuPrincipaleDocente();
		    	}
		    	break;
		    				
		    case 'D':  
		    	if (accesso_studente==true) {
					sistema.logout();
					accesso_studente=false;
		    	}
		    
		    	System.out.println();
		    			
		    	sistema.login(false); // accedo come docente
		    	if (accesso_docente==false) {
		    		accesso_docente=true;
		    	}
		    	if (sistema.login(accesso_docente)==1) {
		    		menuPrincipale();
		    	} else {
		    		menuPrincipaleDocente();
				}
		    	break;	
		    			
		    case 'l': 	
		    	sistema.logout();
		    	menuPrincipale();
		    	break;
		    				
		    case 'L': 
		    	sistema.logout();
				menuPrincipale();
				break;
						
		    default: 	
		    	System.out.println();
				System.out.println("# Input non corretto #");
				menuPrincipale();
				break;
	    	}
	    	
	    } while (studente_docente!='x');
		
	}
	
	public static void menuPrincipaleStudente() throws IOException {
	
		
		System.out.println();
		System.out.println("---------->Effettua una scelta");
		System.out.println();
		System.out.println("  "+ "1 - Prenotazione Esami");
		System.out.println("  "+ "2 - Visualizza Esami prenotati");
		System.out.println("  "+ "0 - Ritorna al Menu Principale");

		
	
			do {
				
				try	{
				
					String c=input.nextLine();
				
					intero=Integer.parseInt(c);
				//intero= input.nextInt();
			
				switch (intero) {
				case 0:	
					System.out.println("");
					menuPrincipale();
					break;
		    	
				case 1: 
					System.out.println();
					sistema.prenotazione();			
					break;
					
				case 2:
					System.out.println();
					sistema.visualizzaPrenotazioni();
					break;
	    		
				case 3:	
					menuPrincipaleStudente();
					break;
	  
				default: 
					System.out.println();
					System.out.println("# Input non corretto #");
					menuPrincipaleStudente();
					break;
				}
				}catch (NumberFormatException e) {
					System.out.println("Input inserito non è un intero");
					menuPrincipaleStudente();
					
				}
			} while (intero!=0);
		
	}
	
	
	public static void menuPrincipaleDocente() throws IOException{
		
		System.out.println();
		System.out.println("---------->PROCEDI");
		System.out.println();
		System.out.println("  "+ "1 - Visualizza Prenotazioni-Insegnamento");
		System.out.println("  "+ "0 - Ritorna al Menu Principale");
		System.out.println();
		
		
		
		do{
			
			try	{		
				String c=input.nextLine();
			
				intero=Integer.parseInt(c);
				switch(intero){
				case 0:	
					System.out.println("");
					menuPrincipale();
					break;
	
				case 1: 
					sistema.visualizzaPrenotazioniInsegnamento();			
					break;
	    
				default:
					System.out.println();
					System.out.println("# Input non corretto #");
					
					menuPrincipaleDocente();
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("Input inserito non è un intero");
				menuPrincipaleDocente();
			}
				
			} while (intero!=0);
	
	}
	
	
		
}


