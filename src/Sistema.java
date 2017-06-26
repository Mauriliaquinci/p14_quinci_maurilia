package prenotazioneesami;

import java.util.ArrayList;
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
	
	/** Association **/
	private ArrayList<Prenotazione> prenotazioni;			//prenotazioni effettuate da tutti gli studenti
	private ArrayList<CarrieraStudente> carr_stud; 			// in carr_stud memorizzo le materie prenotabili per ogni studente
	private ArrayList<UtenteRegistrato> u;					//array di utenti registrati letti da file
	
	/** Costruttore
	 */
	public Sistema() {
		super();
		prenotazioni= new ArrayList<Prenotazione>();
		carr_stud= new ArrayList<CarrieraStudente>();
		u= new ArrayList<UtenteRegistrato>();
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
	public ArrayList<CarrieraStudente> getCarrStud() {
		return carr_stud;
	}
	
	/**Operazione setCarrStud
	 * 
	 * @param carr_stud
	 */
	public void setCarrStud(ArrayList<CarrieraStudente> carr_stud) {
		this.carr_stud=carr_stud;
	}
	
	/**Operazione getUtente
	 * 	
	 * @return
	 */
	public ArrayList<UtenteRegistrato> getUtente() {
		return u;
	}
	
	/**Operazione setUtente
	 * 
	 * @param u
	 */
	public void setUtente(ArrayList<UtenteRegistrato> u) {
		this.u=u;
	}
	
	/**Operazione cancellaCarriera
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	public int cancellaCarriera(Studente s, CarrieraStudente c) { 
		int indice = -1;
		for (int g=0; g<carr_stud.size(); g++){
			if (carr_stud.get(g).getStudente().getMatricola().equals(s.getMatricola())
					&& carr_stud.get(g).getListaInsegnamento().size()==c.getListaInsegnamento().size()) {
				indice = g;
			}
		}
			
		if (indice != -1) {
			if (carr_stud.get(indice).getNumInsCarriera()==carr_stud.get(indice).numMaxInsegnamento()) { 
				carr_stud.remove(indice);
				return carr_stud.size();
			} else {
				return -1;
			}
		} else {
			return -1;
		}	
	}
	
	/**Operazione verificaMatricola
	 * 
	 * @param matricola
	 * @param studente_docente
	 * @return
	 */
	
	public int verificaMatricola(String matricola, boolean studente_docente) {
		boolean esiste = false; 	//esiste= true se la matricola inserita esiste nel file u(utenti registrati)
		int matricola_trovata=0; 	// tengo conto della posizione nel vettore
		int st_do=0; 		//accesso effettuato da un docente o da uno studente
		
		/*  verifico se l'accesso l'ha effettuato
		 * uno studente o un docente facendo un controllo sulla lunghezza della matricola e 
		 * nello stesso tempo verifico se esiste nel vettore u(utenti registrati)*/
		
		for (int i=0; i < u.size(); i++) {
			if (u.get(i).getMatricola().equals(matricola) 
					&& matricola.length()>4) {
				st_do= 1; 		//è uno studente
				esiste = true;		
				matricola_trovata=i;
			}  else if (u.get(i).getMatricola().equals(matricola) 
						&& matricola.length()<=4) {
				st_do= 0;		// è un docente
				esiste = true;
				matricola_trovata=i;		
			}	
		}
		
		if (esiste==true && st_do==1 && studente_docente==false) { // un docente accede come studente
			return -1; 
		} else if (esiste==true && st_do==0 && studente_docente==true) { // uno studente accede come docente
			return -2;
		} else if (esiste==true && st_do==1 && studente_docente==true) { 
				return matricola_trovata;
			} else if (esiste==true && st_do==0 && studente_docente==false) {
					return matricola_trovata;
				} else {
					return -3;	
				}
	}
	
	/**Operazione verificaPassword
	 * 
	 * @param matricola
	 * @param password
	 * @param tentativo
	 * @param studentedocente
	 * @return
	 */
	public int verificaPassword(String matricola, String password, 
								int tentativo, boolean studentedocente) {
		if (verificaMatricola(matricola, studentedocente)>=0) {
			int matricola_trovata = verificaMatricola(matricola, studentedocente);
			if (u.get(matricola_trovata).getPassword().equals(password) 
				&& tentativo<3) {
				return matricola_trovata;
			} else {
				return -1;
			}
		} else {
 			return -1;
		}	
	}
	
	/**Operazione verificaEmail
	 * 
	 * @param matricola
	 * @param studentedocente
	 * @param email
	 * @return
	 */
	public int verificaEmail(String matricola, boolean studentedocente, 
								String email) {
		if (verificaMatricola(matricola,studentedocente)>=0) {
			int indice =verificaMatricola(matricola,studentedocente);
			if (u.get(indice).getEmail().equals(email)) {
				return indice;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
	/**Operazione PrenotazioneEsame
	 * 
	 * @param s
	 * @param ins
	 * @param appello
	 * @return
	 */
	public int PrenotazioneEsame(Studente s, Insegnamento ins, String appello) {
		boolean insegnamentopresenteincarriera = false;
		boolean esiste_prenotazione = false;
		boolean esistecarrierastudente =false;
		boolean listapiena = false;
		int indicecarriera = -1;
		int indice_esame = -1;
		boolean appello_esame = false;
		
		if (carr_stud.size() !=0) { // carriera non vuota
			for(int h=0; h<carr_stud.size(); h++) {
				if (carr_stud.get(h).getStudente().getMatricola().
						equals(s.getMatricola())) {
					esistecarrierastudente = true;
					indicecarriera=h;
				}
			}
			
			if (esistecarrierastudente == true) { //studente presente nell array
				if (carr_stud.get(indicecarriera).getListaInsegnamento().
						size()!=0) {
					listapiena = true;
				} else {
					listapiena= false;
				}
				
				if (listapiena == true) {
					for(int g=0; g<carr_stud.get(indicecarriera).
									getListaInsegnamento().size(); g++) {
						if (carr_stud.get(indicecarriera).getListaInsegnamento().
								get(g).getCodice().equals(ins.getCodice())) {
							insegnamentopresenteincarriera = true; //esame presente in carriera
							indice_esame =g;
						}
					}
					
					if (insegnamentopresenteincarriera == true) {
						if (prenotazioni.size()!=0) {
							for(int i=0; i< prenotazioni.size(); i++) {
								if (prenotazioni.get(i).getStudenti().
										getMatricola().equals(s.getMatricola()) 
										&& prenotazioni.get(i).getInsegnamento().
											getCodice().equals(ins.getCodice())) {
										esiste_prenotazione= true; //prenotazione dell esame già effettuata
								}
							}
							
							if (esiste_prenotazione == false) {
								for(int f=0; f < carr_stud.get(indicecarriera).
													getListaInsegnamento().
													get(indice_esame).getAppello().
													size(); f++) {
									if (carr_stud.get(indicecarriera).
													getListaInsegnamento().
													get(indice_esame).getAppello().
													get(f).equals(appello)) {
										appello_esame=true; //l'appello selezionato 
															//corrisponde alle date 
															//appelli dell'insegnam
									}
								}
								
								if (appello_esame == true) {
									Random random= new Random();
									int casuale = random.nextInt(100);
									Prenotazione prenotazione = new Prenotazione();
									prenotazione.setCodPrenotazione(casuale);
									prenotazione.setStudenti(s);
									ArrayList<String> appello_prenotato = new ArrayList<String>();
									appello_prenotato.add(appello);
									ins.setAppello(appello_prenotato);
									prenotazione.setInsegnamento(ins);
									prenotazioni.add(prenotazione);								
									s.setPrenotazione(prenotazioni);
									carr_stud.get(indicecarriera).
											getListaInsegnamento().remove(indice_esame);
									return 0;
								} else {
									return 1;
								}
							} else {
								return 1; //prenotazione dell' insegnamento già effettuato
							}
						} else {
							Prenotazione prenotazione = new Prenotazione();
							prenotazione.setStudenti(s);
							prenotazione.setInsegnamento(ins);
							ArrayList<Prenotazione> prenot = new ArrayList<Prenotazione>();
							prenot.add(prenotazione);
							setPrenotazioni(prenot);	
							return 0;
						}
					
					} else {
						return 1;  //esame che si vuole prenotare 
									// non è presente in carriera
					}
				} else {
					return 1; //lista insegnamenti vuota
				}
			} else {
				return 1; //studente non presente in carriera
			}
		} else {
			return 1; // carriera vuota
		}
	}
	
}




