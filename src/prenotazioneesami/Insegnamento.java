package prenotazioneesami;

import java.util.ArrayList;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */

/**
 * Specifica il codice, nome, numero di crediti formativi
 * classe(primo, secondo...quinto anno)di un insegnamento e la lista degli appelli per sostenere un esame.
 * Ad ogni insegnamento corrisponde una o più prenotazioni
 */

public class Insegnamento {
	
    /** Attributes */
    private String codice;
    private String nome;
    private String cfu;
    private String classe;
    private ArrayList<String> appello;
    
    /** Associations */
    private Esame esame;
    private ArrayList<Prenotazione> prenotazione;
   
    /**Costruttore 
     * 
     * @param codice
     * @param nome
     * @param cfu
     * @param classe
     * @param appello
     * @param esame
     * @param prenotazione
     */
    public Insegnamento(String codice, String nome, String cfu, String classe,
    					ArrayList<String> appello, Esame esame, 
    					ArrayList<Prenotazione> prenotazione ) {
    	super();
    	this.codice=codice;
    	this.nome=nome;
    	this.cfu=cfu;
    	this.classe=classe;
    	this.esame=esame;
    	this.prenotazione= prenotazione;
    	this.appello= appello;
    }
    
    public Insegnamento(String codice, String nome, String cfu, String classe) {
    	this.codice=codice;
    	this.nome=nome;
    	this.cfu=cfu;
    	this.classe=classe;
    	
    }
    
    /**Costruttore senza parametri
     * 
     */
    public Insegnamento() {}
    
    /**Operazione getCodice
     * 
     * @return codice
     */
    public String getCodice() {
    	return codice;
    }
    
    /**Operazione setCodice
     * 
     * @param codice
     */
    public void setCodice(String codice) {
    	this.codice=codice;
    }
    
    /**Operazione getNome
     * 
     * @return nome
     */
    public String getNome() {
    	return nome;
    }
    
    /**Operazione setNome
     * 
     * @param nome
     */
    public void setNome(String nome) {
    	this.nome=nome;
    }
    
    /**Operazione getCfu
     * 
     * @return cfu
     */
    public String getCfu() {
    	return cfu;
    }
    
    /**Operazione setCfu
     * 
     * @param cfu
     */
    public void setCfu(String cfu) {
    	this.cfu=cfu;
    }
    
    /**Operazione getClasse
     * 
     * @return classe
     */
    public String getClasse() {
    	return classe;
    }
    
    /**Operazione setClasse
     * 
     * @param classe
     */
    public void setClasse(String classe) {
    	this.classe=classe;
    }
    
    /**Operazione getEsame
     * 
     * @return esame
     */
    public Esame getEsame() {
    	return esame;
    }
    
    /**Operazione setEsame
     * 
     * @param esame
     */
    public void setEsame(Esame esame) {
    	this.esame=esame;
    }
    
    /**Operazione getPrenotazione
     * 
     * @return prenotazione
     */
    public  ArrayList<Prenotazione> getPrenotazione() {
    	return prenotazione;
    }
    
    /**Operazione setPrenotazione
     * 
     * @param prenotazione
     */
    public void setPrenotazione( ArrayList<Prenotazione> prenotazione) {
    	this.prenotazione=prenotazione;
    }
    
    /**Operazione getAppello
     * 
     * @return appello
     */
    public ArrayList<String> getAppello() {
    	return appello;
    }
    
    /**Operazione setAppello
     * 
     * @param appello
     */
    public void setAppello(ArrayList<String> appello) {
    	this.appello=appello;
    }
    /**
     * Operation addAppello
     *
     * @param data 
     * @return void
     */
    public int addAppello(String data ) {
    	if(appello.size()<3){
    		appello.add(data);
    		return 0;
    	} else {
    		return 1;
    	}
    }
    
  
    
    
    
    
    
    
  
}

