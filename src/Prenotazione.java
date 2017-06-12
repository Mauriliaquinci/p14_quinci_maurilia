package prenotazioneesami;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */
/**Specifica il codice di prenotazione (generato casualmente),
 * il promemoria. Ogni prenotazione viene effettuata da uno studente per un determinato insegnamento.
 * 
 */
public class Prenotazione {
	
	/** Attributes */
	private int cod_prenotazione;
	
	/** Associations */
	private Promemoria promemoria;
	private Studente studente;
	private Insegnamento insegnamento;
	
	/** Costruttore
	 * 
	 * @param cod_prenotazione
	 * @param promemoria
	 * @param insegnamento
	 * @param studente
	 */
	public Prenotazione(int cod_prenotazione, Promemoria promemoria, 
						Insegnamento insegnamento, Studente studente) {
		super();
		this.cod_prenotazione=cod_prenotazione;
		this.promemoria=promemoria;
		this.studente=studente;	
		this.insegnamento=insegnamento;
		
	}
	
	/** Costruttore senza parametri
	 * 
	 */
	public Prenotazione() {}
	
	/**Operazione getCOdPrenotazione
	 * 
	 * @return cod_prenotazione
	 */
	public int getCodPrenotazione() {
		return cod_prenotazione;
	}
	
	/**Operazione setCodPrenotazione
	 * 
	 * @param cod_prenotazione
	 */
	public void setCodPrenotazione(int cod_prenotazione) {
		this.cod_prenotazione=cod_prenotazione;
	}
	
	/**Operazione getPromemoria
	 * 
	 * @return promemoria
	 */
	public Promemoria getPromemoria() {
		return promemoria;
	}
	
	/**Operazione setPromemoria
	 * 
	 * @param promemoria
	 */
	public void setPromemoria(Promemoria promemoria) {
		this.promemoria=promemoria;
	}
	
	/**Operazione getStudenti
	 * 
	 * @returnstudente
	 */
	public Studente getStudenti() {
		return studente;
	}
	
	/**Operazione setStudenti
	 * 
	 * @param studente
	 */
	public void setStudenti(Studente studente) {
		this.studente=studente;
	}
	
	/**Operazione getInsegnamento
	 * 
	 * @return insegnamento
	 */
	public Insegnamento getInsegnamento() {
		return insegnamento;
	}
	
	/**Operazione setInsegnamento
	 * 
	 * @param insegnamento
	 */
	public void setInsegnamento(Insegnamento insegnamento) {
		this.insegnamento=insegnamento;
	}
	
	/**Operazione cancellaPrenotazione
	 * 
	 * @param p
	 */
	public void cancellaPrenotazione(Prenotazione p) {
		cod_prenotazione=0;	
	}
	
	/**Operazione modificaPrenotazione
	 * 
	 */
	public void modificaPrenotazione() {}
	
	

}
