package prenotazioneesami;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */

/** Classe Sistema implementa le funzioni principali del progetto di gestione di esami online:
 * login, logout, prenotazione esami, visualizzazione esami prenotati, visualizzazione prenotazioni-insgenamento
 * 
 **/
public class Sistema {
	
	String login; 				//per memorizzare la matricola che ha effettuato il login
	String nome_st;				//memorizzo il nome studente che ha effettuato il login
	String cognome_st;			//memorizzo il cogonme studente che ha effettuato il login
	int matricola_errata;		//se =1 reinserisco la matricola
	boolean esci;				//se true si esce fuori dalla funzione login e si ritorna al menuPrincipale
	private ArrayList<Studente> studenti_prenotazioni;		//array Studente che memorizza le prenotazioni di uno 
															//studente; ogni prenotazione ha un codice
															// di prenotazione e associato l'insegnamento 
	private ArrayList<Docente> docente_insegnamenti;		//array Docente in cui memorizzo la matricola di un docente
															// e la lista dei sui insegnamenti
 	
	/** Association **/
	private ArrayList<Prenotazione> prenotazioni;			//prenotazioni effettuate da tutti gli studenti
	private ArrayList<CarrieraStudente> carr_stud; 			// in carr_stud memorizzo le materie prenotabili per ogni studente
	private ArrayList<UtenteRegistrato> u;					//array di utenti registrati letti da file
	
	/** Costruttore
	 */
	public Sistema() {
		super();
		prenotazioni= new ArrayList<Prenotazione>();
		carr_stud= new ArrayList<CarrieraStudente>(0);
		u= new ArrayList<UtenteRegistrato>();
		login= null;
		nome_st=null;
		cognome_st=null;
		matricola_errata=0;
		esci=false;
		studenti_prenotazioni= new ArrayList<Studente>();
		docente_insegnamenti= new ArrayList<Docente>();
	}
	
	/** Operazione getPrenotazioni
	 * 
	 * @return
	 */
	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	/**Operazione setPrenotazioni
	 * 	
	 * @param prenotazioni
	 */
	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni=prenotazioni;
	}
	
	/**Operazione getCarrStud
	 * 
	 * @return carr_stud
	 */
	public ArrayList<CarrieraStudente> getCarrStud(){
		return carr_stud;
	}
	
	/**Operazione setCarrStud
	 * 
	 * @param carr_stud
	 */
	public void setCarrStud(ArrayList<CarrieraStudente> carr_stud) {
		this.carr_stud=carr_stud;
	}
	
	public ArrayList<UtenteRegistrato> getUtente() {
		return u;
	}
	
	public void setUtente(ArrayList<UtenteRegistrato> u) {
		
		this.u=u;
	}
	
	
	/*Quando uno studente avrà superato tutti gli esami e si sarà laureato
	 * la sua carriera verrà cancellata*/
	public ArrayList<CarrieraStudente> cancellaCarriera(){ 
		for (int g=0; g<carr_stud.size(); g++){
			if(carr_stud.get(g).getNumInsCarriera()==carr_stud.get(g).numMaxInsegnamento()) { 
				carr_stud.remove(g);
			}
		}
		return carr_stud;
	}
	 

	
	
	/**Lettura file Utenti Registrati**/	 
	public  void utentiRegistrati() throws IOException {
		
		String line;
		FileReader file;
		file=new FileReader("src/prenotazioneesami/utentiRegistrati");
	    BufferedReader bufferUtenti;
	    bufferUtenti=new BufferedReader(file);
	    
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
	    	
	    	u.add(utenti); 
	    	
	    	line=bufferUtenti.readLine();   
	    }
	    
	    bufferUtenti.close();
	}
	
	
	/**Lettura file Docente Insegnamento**/
	public  void docenteInsegnamento() throws IOException {
		
		String line;
		FileReader file;
		file=new FileReader("src/prenotazioneesami/docenteInsegnamento");
	    BufferedReader bufferDocenti;
	    bufferDocenti=new BufferedReader(file);
	    
	    line=bufferDocenti.readLine(); 
	   
	    /*Il file docenteInsegnamento è così organizzato
	     * matricola docente
	     * n numero insegnamenti per un docente
	     * n*2 righe così scritte:	codice insegnamento
	     * 							nome insegnamento */
	    while (line!=null) {
	    	Docente d = new Docente();
	    	d.setMatricola(line);
	    	
	    	line=bufferDocenti.readLine(); 
	    	int numero_ins= Integer.parseInt(line);
	    	
	    	ArrayList<Insegnamento> temp = new ArrayList<Insegnamento>();
	    	
	    	for (int i=0; i< numero_ins; i++) {
	    		 Insegnamento ins = new Insegnamento();
	    		 
	    		 line=bufferDocenti.readLine(); 
	    		 ins.setCodice(line);
	    		 
	    		 line=bufferDocenti.readLine();
	    		 ins.setNome(line);
	    		 
	    		 temp.add(ins);	  
	    	 }
	    	
	    	 d.setInsegnamenti(temp);
	    	 docente_insegnamenti.add(d);
 
	    	 line=bufferDocenti.readLine(); 	
	    }    
	    bufferDocenti.close();
	}
	
	
	
	/**LOGIN**/
	@SuppressWarnings("resource")
	public int login(boolean studente_docente) throws IOException {
		
		if (esci==true) {
			esci=false;
			logout();
			return 1; 					// esco dalla funzione se uno studente accede 
					  					//come docente e viceversa
		} else if (login==null) {	 	// se nessuno ha effettuato il login procedo con il login							
			if (matricola_errata==1) { 	// se la matricola è errata appare solo Matricola in display
				System.out.println();
				System.out.println(" > Matricola");
			} else {
				System.out.println("---------->Effettua il login"); 
				System.out.println();
				System.out.println(" > Matricola");
			}
			
			Scanner input = new Scanner(System.in);
			String select = input.next(); 
			boolean esiste = false; 	//esiste= true se la matricola inserita esiste nel file u(utenti registrati)
			int matricola_trovata=0; 	// tengo conto della posizione nel vettore
			int conta=0;			 	// tentativi di password
			boolean st_do=false; 		//accesso effettuato da un docente o da uno studente
			
			
			/* dopo aver immesso la matricola da tastiera verifico se l'accesso l'ha effettuato
			 * uno studente o un docente facendo un controllo sulla lunghezza della matricola e 
			 * nello stesso tempo verifico se esiste nel vettore u(utenti registrati)*/
			for (int i=0; i < u.size(); i++) {
				if (u.get(i).getMatricola().equals(select) && select.length()>4) {
					st_do= true; 		//è uno studente
					esiste = true;		
					matricola_trovata=i;
				} else if (u.get(i).getMatricola().equals(select) && select.length()<=4) {
					st_do= false;		// è un docente
					esiste = true;
					matricola_trovata=i;		
				}	
			}
			
			/* effettuo un controllo sulle due variabili(esiste e st_do) per poter uscire fuori dalla
			 * funzione di login nel caso in cui un docente tenta di accedere nell'area studente e 
			 * viceversa*/
			if (esiste==true && st_do!=studente_docente) {
				if (st_do==true) {
					System.out.println("Non sei un DOCENTE");
					System.out.println();
					esci=true;
					logout();	
					return 1;			
				} else {
					System.out.println("Non sei uno STUDENTE");
					System.out.println();
					esci=true;
					logout();
					return 1;
				}
			}
			
			if (esiste==true && st_do==studente_docente) {
				boolean ok= false;

				while (conta<3 && ok==false) {
					System.out.println(" > Password: Tentantivo n"+(conta+1));
					select=input.next();	
					
					if (u.get(matricola_trovata).getPassword().equals(select)) {
						System.out.println("  BENVENUTO "+ u.get(matricola_trovata).getNome().toUpperCase());
						matricola_errata=0;
						ok=true;
						System.out.println();
						login=u.get(matricola_trovata).getMatricola();
						nome_st=u.get(matricola_trovata).getNome();
						cognome_st=u.get(matricola_trovata).getCognome();
						esci=false;
					} else {
						conta++;
					}
				}
			} 
				
			if (esiste==false) {
				matricola_errata=1;
				login(studente_docente);
			}
				
			if (conta==3) {
				System.out.println("Password errata");
				System.out.println("Avvio procedimento Recupero Password");
				System.out.println();
				System.out.println(" > Inserisci l'email con il quale ti sei registrato");
				select= input.next();
				
				if (u.get(matricola_trovata).getEmail().equals(select)) {
					System.out.println(" > Inserisci nuova Password");
					select=input.next();
					u.get(matricola_trovata).setPassword(select);
					System.out.println("PASSWORD MODIFICATA CON SUCCESSO");
					esci=false;
					login(studente_docente);
				} else {
					System.out.println("");
					System.out.println(" Email non valida ! ----------->ERRORE");
					System.out.println("");
					esci=true;
				}
			}		
		}
		
		return 0;
	}
		
	
	
	/**LOGOUT**/
	public void logout() {
		
		login=null;
		nome_st=null;
		cognome_st=null;
		
	}
	
		
	/**  PRENOTAZIONE ESAME  **/
	/*Questa funzione permette ad uno studente di prenotare un esame dalla lista dei suoi esami
	 * prenotabili, memorizzati precedentemente nell array carr_stud.
	 * Ogni prenotazione viene memorizzata dentro l'array prenotazioni 
	 * affinchè un docente possa poi visualizzare la lista degli studenti
	 * che hanno prenotato un determinato insegnamento*/
	@SuppressWarnings("resource")
	public void prenotazione() throws IOException {
		
		int indice_studente = 0;
		int indice_studente_prenotazione=0;
		boolean esiste_studente_prenotazione=false;
		char y_n = 'n';
		
		for (int w=0; w<carr_stud.size(); w++) {
			if (carr_stud.get(w).getStudente().getMatricola().equals(login)) {
				indice_studente=w; //trovo la posizione dello studente  in carr_stud che ha effettuato l'accesso
			}
		}
		
		if (carr_stud.get(indice_studente).getListaInsegnamento().isEmpty()) { 	// se la lista delle materie prenotabili 
																				//dallo studente è vuota
			System.out.println();                                       		// ritorno al menu studente
			System.out.println("---------->NON ESISTONO ESAMI DA PRENOTARE");
			System.out.println();
			System.out.println();
			System.out.println("---------->EFFETTUA UNA SCELTA");
			System.out.println();
			System.out.println("  "+ "1 - Prenotazione esame");
			System.out.println("  "+ "2 - Visualizza esami prenotati");
			System.out.println("  "+ "0 - Ritorna al Menu Principale");
		} else {  
			
			Scanner scelta= new Scanner(System.in);
			Scanner scelta_appello= new Scanner(System.in);
			
			do {
				/*se la lista degli insegnamenti prenotabili è vuota allora setto y_n a 'n' per uscire dal while*/
				if (carr_stud.get(indice_studente).getListaInsegnamento().isEmpty()) { 
					System.out.println("Non ci sono altri esami da prenotare");
					y_n='n'; 
				} else {
					System.out.println();
					System.out.println("---------->ESAMI PRENOTABILI");
					System.out.println();
					/*stampo la lista degli insegnamenti prenotabili per lo studente 
					 * che ha effettuato l'accesso*/	
					for (int i=0; i<carr_stud.get(indice_studente).getListaInsegnamento().size(); i++) { 
					   	System.out.println("  "+ (i+1) + " - " +
					   		carr_stud.get(indice_studente).getListaInsegnamento().get(i).getNome());
					}
						
					String sc= scelta.nextLine(); // l'utente sceglie quale esame prenotare 
					
					try {
						int valore= Integer.parseInt(sc);
						
						while (valore==0 || 
								valore>carr_stud.get(indice_studente).getListaInsegnamento().size()) {
							System.out.println("Inserire un numero tra 1 e " + 
									carr_stud.get(indice_studente).getListaInsegnamento().size());
							sc= scelta.nextLine();
							valore=Integer.parseInt(sc);
						}
						
					//	if (valore>=1 || valore<=carr_stud.get(indice_studente).getListaInsegnamento().size()) {
							System.out.println(); 
							/*Visualizzo il nome degli insegnamenti prenotabili*/
							System.out.println("A quale appello di "+
								carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getNome().toUpperCase() + 
								" desideri prenotarti?");
							System.out.println();
							System.out.println(" > Appelli: ");
							/*Visualizzo gli appelli per ogni insegnamento*/
							for (int h=0; h<3; h++) {
								System.out.println("   "+ (h+1) +")  "+
									carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getAppello().get(h));
							}
						
						String c=scelta_appello.nextLine(); // scelgo un numero da 1 a 3 per l'appello
							
						
							int valoreletto=Integer.parseInt(c);
							
							while (valoreletto==0 || valoreletto>carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getAppello().size()) {
								System.out.println("Inserire un numero tra 1 e " + 
										carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getAppello().size());
									
								c=scelta_appello.nextLine();
								valoreletto=Integer.parseInt(c);
							}
								
							Random random= new Random();
							int casuale = random.nextInt(100);//genero un numero casuale per la prenotazione
							
							if (studenti_prenotazioni.size()!=0) {
								/*Scorro l'array per memorizzare la posizione dell'utente che ha 
								 * effettuato l'accesso e che è presente nell'array*/
								for (int h=0; h<studenti_prenotazioni.size(); h++) { 
									if (studenti_prenotazioni.get(h).getMatricola().equals(login)) {
										esiste_studente_prenotazione=true;
										indice_studente_prenotazione=h;
									}
								}
							}
							/*Se lo studente non ha ancora effettuato nessuna prenotazione
							 * creo allora un nuovo record nell array studenti_prenotazioni
							 * altrimenti aggiorno le informazioni nella posizione indice_studente_prenotazione */
							if (esiste_studente_prenotazione==false) { 
								Studente st= new Studente();
								Prenotazione pr= new Prenotazione();
								Insegnamento inse= new Insegnamento();
								ArrayList<Prenotazione> temporaneo= new ArrayList<Prenotazione>();
	
								st.setMatricola(login);
								st.setNome(nome_st);
								st.setCognome(cognome_st); //salvo in st di tipo studente nome cognome matricola
								pr.setStudenti(st);
								pr.setCodPrenotazione(casuale);
								inse.setNome(carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getNome());					
								ArrayList<String> temp_appello= new ArrayList<String>(); // array temporaneo per l appello
								temp_appello.add(carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getAppello().get(valoreletto-1));
								inse.setAppello(temp_appello); 
								pr.setInsegnamento(inse);
								temporaneo.add(pr);
								st.setPrenotazione(temporaneo);
								studenti_prenotazioni.add(st); 
								prenotazioni.add(pr);
							} else { 
								Prenotazione pr= new Prenotazione();
								Insegnamento inse= new Insegnamento();
								Studente st= new Studente();
								pr.setCodPrenotazione(casuale);
								inse.setNome(carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getNome());					
								ArrayList<String> temp_appello= new ArrayList<String>();
								temp_appello.add(carr_stud.get(indice_studente).getListaInsegnamento().get(valore-1).getAppello().get(valoreletto-1));
								inse.setAppello(temp_appello);
								st.setMatricola(login);
								st.setNome(nome_st);
								st.setCognome(cognome_st); //salvo in st di tipo studente nome cognome matricola
								pr.setStudenti(st);
								pr.setInsegnamento(inse);
								prenotazioni.add(pr);
								studenti_prenotazioni.get(indice_studente_prenotazione).getPrenotazione().add(pr);
							}
																
							System.out.println();
							System.out.println("---------->PRENOTAZIONE EFFETTUATA");
							/*Una volta che uno studente ha prenotato un esame non può più
							 * visualizzare nella sezione"prenotazione esami" ma può visualizzarlo solo nella
							 * sezione "visualizza esami prenotati" */
							carr_stud.get(indice_studente).getListaInsegnamento().remove(valore-1);
							System.out.println();
							System.out.println("Desideri prenotare un altro esame?");
							System.out.println("Premi s/n per continuare");
							Scanner decision= new Scanner(System.in);
							y_n=decision.next().charAt(0);
							while (y_n!='n' && y_n!='N' && y_n!='s' && y_n!='S') {
								System.out.println("Operazione non consentita, premi s/n");
								y_n=decision.next().charAt(0);	
							
							}
	
						}catch (NumberFormatException e) {
							System.out.println("Non è un numero");
						}
							
				} 
		
		
			
			}while (y_n=='s' || y_n== 'S');
			
			if (y_n=='n' || y_n== 'N') {
				System.out.println();
				System.out.println();
				System.out.println("---------->Effettua una scelta");
				System.out.println();
				System.out.println("  "+ "1 - Prenotazione Esami");
				System.out.println("  "+ "2 - Visualizza Esami prenotati");
				System.out.println("  "+ "0 - Ritorna al Menu Principale");

			}			
		}
		
}
	
	/**VISUALLIZZAZIONE ESAMI PRENOTATI**/
	/*Uno studente può visualizzare la lista degli esami prenotati*/
	public void visualizzaPrenotazioni() throws IOException {
		
		boolean visualizza_esami_studente= false;
		int indice_st=0;
		
		for (int i=0; i< studenti_prenotazioni.size(); i++) {
			if (studenti_prenotazioni.get(i).getMatricola().equals(login)) {
				visualizza_esami_studente= true;
				indice_st=i;
			}
		}
					
		if (visualizza_esami_studente==false) {
			System.out.println("  "+ "ESAMI PRENOTATI: 0");
			System.out.println();
		} else {
			System.out.println("---------->I TUOI ESAMI PRENOTATI");
			System.out.println();
			
			for (int h=0; h<studenti_prenotazioni.get(indice_st).getPrenotazione().size(); h++) {
				System.out.println((h+1)+ " - "+"> Insegnamento: "+ 
						studenti_prenotazioni.get(indice_st).getPrenotazione().get(h).getInsegnamento().getNome());
				System.out.println("   "+ " > Cod prenotazione: "+
						studenti_prenotazioni.get(indice_st).getPrenotazione().get(h).getCodPrenotazione());
				System.out.println("   "+ " > Data appello: "+ 
						studenti_prenotazioni.get(indice_st).getPrenotazione().get(h).getInsegnamento().getAppello().get(0));
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("  "+ "3 - Indietro ");
		System.out.println("  "+ "0 - Torna al Menu Principale");
					
	}
	
	
	
	/**VISUALLIZA PRENOTAZIONI EFFETTUATE DAGLI STUDENTI**/
	/*Un docente può visualizzare la lista degli insegnamneti che insegna 
	 * e per ognuno visualizzare la lista delle prenotazioni effettuate
	 * dagli studenti per quell'insegnamento*/
	@SuppressWarnings("resource")
	public void visualizzaPrenotazioniInsegnamento() throws IOException {
		
		docenteInsegnamento();
		ArrayList<Prenotazione> pren = new ArrayList<Prenotazione>();
		boolean docente_trovato= false;
		int pos_docente =0;
		
		
		for (int i=0; i<docente_insegnamenti.size(); i++){
			if (docente_insegnamenti.get(i).getMatricola().equals(login)) {
				docente_trovato=true;
				pos_docente=i;
			}
		}
		
		if (docente_trovato == true) {
			System.out.println("Per quale insegnamento vuoi visualizzare le prenotazioni?");
			System.out.println();
			
			for (int j=0; j<docente_insegnamenti.get(pos_docente).getInsegnamenti().size();j++) {
				System.out.println("  " + (j+1) + "-" +
					docente_insegnamenti.get(pos_docente).getInsegnamenti().get(j).getNome());
			}
			
			Scanner insegnam = new Scanner(System.in);
			String scegli = insegnam.nextLine();
			boolean prenotazioni_presenti= false;
			
		
				int valore_letto= Integer.parseInt(scegli);
			
				while (valore_letto == 0 || valore_letto>docente_insegnamenti.get(pos_docente).getInsegnamenti().size()) {
					if (docente_insegnamenti.get(pos_docente).getInsegnamenti().size()==1) {
						System.out.println("Premi 1");
					} else {
						System.out.println("Inserisci un numero tra 1 e " +
								docente_insegnamenti.get(pos_docente).getInsegnamenti().size());
					}
					scegli=insegnam.nextLine();
					valore_letto=Integer.parseInt(scegli);
				}
				
		
				for (int h=0; h<prenotazioni.size(); h++) {
					if (prenotazioni.get(h).getInsegnamento().getNome().
							equals(docente_insegnamenti.get(pos_docente).getInsegnamenti().get(valore_letto-1).getNome())) {
						prenotazioni_presenti=true;
						pren.add(prenotazioni.get(h));	
					} 	
				}
				
				if (prenotazioni_presenti==true) {
					System.out.println("---------->Lista Studenti ");
					System.out.println();
					
					for (int f=0; f<pren.size(); f++) {
						System.out.println(" " + (f+1) + " - Matricola " +pren.get(f).getStudenti().getMatricola());
						System.out.println("     Nome  "+ pren.get(f).getStudenti().getNome().toUpperCase());
						System.out.println("     Cognome "+ pren.get(f).getStudenti().getCognome().toUpperCase());
						System.out.println("     Data Appello "+ pren.get(f).getInsegnamento().getAppello().get(0));
						System.out.println();
					}
				} else {
					System.out.println("---------->Lista Studenti ");
					System.out.println();
					System.out.println(" VUOTA !");
				}
			
			
			
			
			System.out.println("  "+ "0 - Ritorna al Menu Principale");
			}
	}
		
	
		
}




