package prenotazioneesami;

import java.util.ArrayList;


/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */
/**
 * E' una sottoclasse della classe UtenteRegistrato. Ogni studente effettua una o più prenotazioni, sostiene più esami e possiede una Carriera Studente
 * 
*/

public class Studente extends UtenteRegistrato {
	
	/** Attributes */
	private boolean valutazione; 			//valutazione della didattica(true, false)
	private boolean pagamento_tassa;		//pagamento tassa universitaria( true, false)
	private boolean accetta_voto_esame;		//voto esame accettato(true), rifiutato(false)
	
	  /** Associations */
	private ArrayList<Prenotazione> prenotazione;
	private CarrieraStudente carriera;
	private ArrayList<Esame> esami_sostenuti;
	
	/** Costruttore
	 * 
	 * @param matricola
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param s_d
	 * @param valutazione
	 * @param pagamento_tassa
	 * @param accetta_voto_esame
	 */
	public Studente(String matricola, String nome, String cognome, String email, 
					String password,boolean s_d, boolean valutazione, 
					boolean pagamento_tassa, boolean accetta_voto_esame) {
		super(matricola, nome, cognome, email, password, s_d);
		this.valutazione=valutazione;
		this.pagamento_tassa=pagamento_tassa;
		this.accetta_voto_esame=accetta_voto_esame;	
	}
	
	/** Costruttore senza parametri
	 * 
	 */
	public Studente() {}
	
	
	/**Operazione isValutazione
	 * 
	 * @return valutazione
	 */
	public boolean isValutazione() {
		return valutazione;
	}
	
	/**Operazione setValutazione
	 * 
	 * @param valutazione
	 */
	public void setValutazione(boolean valutazione) {
		this.valutazione=valutazione;
	}
	
	/**Operazione isPagamentoTassa
	 * 
	 * @return pagamento_tassa
	 */
	public boolean isPagamentoTassa() {
		return pagamento_tassa;
	}
	
	/**Operazione setPagamentoTassa
	 * 
	 * @param pagamento_tassa
	 */
	public void setPagamentoTassa(boolean pagamento_tassa) {
		this.pagamento_tassa=pagamento_tassa;
	}
	
	/**Operazione isAccettaVotoEsame
	 * 
	 * @return accetta_voto_esame
	 */
	public boolean isAccettaVotoEsame() {
		return accetta_voto_esame;
	}
	
	/**Operazione setAccettaVotoEsame
	 * 
	 * @param accetta_voto_esame
	 */
	public void setAccettaVotoEsame(boolean accetta_voto_esame) {
		this.accetta_voto_esame=accetta_voto_esame;
	}
	
	/**Operazione getPrenotazione
	 * 
	 * @return prenotazione
	 */
	public ArrayList<Prenotazione> getPrenotazione() {
		return prenotazione;
	}
	
	/**Operazione setPrenotazione
	 * 
	 * @param prenotazione
	 */
	public void setPrenotazione(ArrayList<Prenotazione> prenotazione) {
		this.prenotazione=prenotazione;
	}
	
	/**Operazione getCarriera
	 * 
	 * @return carriera
	 */
	public CarrieraStudente getCarriera() {
		return carriera;
	}
	
	/**Operazione setCarriera
	 * 
	 * @param carriera
	 */
	public void setCarriera(CarrieraStudente carriera) {
		this.carriera=carriera;
	}
	
	/**Operazione getEsame
	 * 
	 * @return esame_sostenuti
	 */
	public ArrayList<Esame> getEsame() {
    	return esami_sostenuti;
    }
    
	/**Operazione setEsame
	 * 
	 * @param esami_sostenuti
	 */
    public void setEsame(ArrayList<Esame> esami_sostenuti) {
    	this.esami_sostenuti=esami_sostenuti;
    }
  
}
