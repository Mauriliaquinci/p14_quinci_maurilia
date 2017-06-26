package prenotazioneesami;

import java.util.ArrayList;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */

/**
 *E' l'insieme degli insegnamenti inseriti dallo studente dopo aver 
 * compilato il Piano di Studi.
 */

public class CarrieraStudente {	
	
	/** Attributi  */
	private int num_ins;
	Studente iesimo= new Studente();
	
	/** Associazioni */
	public ArrayList<Insegnamento> listaInsegnamento;
	
	/** 
	 * Costruttore con parametri
	 * @param listaInsegnamento -
	 * @param iesimo -
	 */
	public CarrieraStudente(ArrayList<Insegnamento> listaInsegnamento, Studente iesimo) {
		super();
		this.listaInsegnamento = listaInsegnamento;
		this.iesimo=iesimo;
	 }
	
	/**
	 * Costruttore senza parametri
	*/
	public CarrieraStudente() {}
	
	/**
	 * Operazione getListaInsegnamento
	 * @return listaInsegnamento
	 */
	public ArrayList<Insegnamento> getListaInsegnamento() {
		return listaInsegnamento;
	}
	
	/**
	 * Operazione setListaInsegnamento
	 * @param listaInsegnamento
	 */
	public void setListaInsegnamento(ArrayList<Insegnamento> listaInsegnamento){
		this.listaInsegnamento= listaInsegnamento;
	}

    /**
     * Operation aggiungiInsegnamento
     * @param ins
     */
    public void aggiungiInsegnamento (Insegnamento ins ) {
    	if (listaInsegnamento.isEmpty()) {
    		ArrayList<Insegnamento> i = new ArrayList<Insegnamento>();
    		i.add(ins);
    		setListaInsegnamento(i);
    	} else {
    		listaInsegnamento.add(ins);
    		
    	}
    }
    
    /** Operazione getNumInsCarriera
     * @return il numero di insegnamenti presenti in carriera
     */
    public int getNumInsCarriera() {
    	num_ins=listaInsegnamento.size();
    	return num_ins;
    }
    
    /**Operazione setStudente
     * @param iesimo
     */
    public void setStudente(Studente iesimo) {
    	this.iesimo=iesimo;
    }
    
    /**
     * Operation getStudente
     * @return iesimo
     */
    public Studente getStudente() {
    	return iesimo;
    }
    /**
     * Operation numMaxInsegnamento
     */
    public int numMaxInsegnamento() {
    	return 40;
    }
}

