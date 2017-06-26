package prenotazioneesami;

import java.util.ArrayList;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */
/**
 * Specifica il voto di uno studente, la tipologia( scritto e/o orale) di esame e
 * l'esito del verbale ai fini della verbalizzazione dell'esame
 */

public class Esame {

	/** Attributes */
	private int voto;
	private ArrayList<String> tipo;
	private String esito_verbale;
	private Studente s;
	private Insegnamento i;
	
	/**Costruttore con parametri
	 * 
	 * @param voto
	 * @param tipo
	 * @param esito_verbale
	 */
	public Esame(int voto, ArrayList<String> tipo, String esito_verbale,
				Studente s, Insegnamento i){
		super();
		this.voto=voto;
		this.tipo= tipo;
		this.esito_verbale=esito_verbale;
		this.s = s;
		this.i=i;
	}
	
	/**Operazione getVoto
	 * 
	 * @return
	 */
	public int getVoto() {
		return voto;
	}
	
	/**Operazione setVoto
	 * 
	 * @param voto
	 */
	public void setVoto(int voto) {
		this.voto=voto;
	}
	
	/**Operazione getTipo
	 * 
	 * @return
	 */
	public ArrayList<String> getTipo() {
		return tipo;
	}
	
	/**Operazione setTipo
	 * 
	 * @param tipo
	 */
	public void setTipo(ArrayList<String> tipo) {
		this.tipo=tipo;
	}
	
	/**Operazione getEsitoVerbale
	 * 
	 * @return
	 */
	public String getEsitoVerbale() {
		return esito_verbale;
	}
	
	/**Operazione setEsitoVerbale
	 * 
	 * @param esito_verbale
	 */
	public void setEsitoVerbale(String esito_verbale) {
		this.esito_verbale=esito_verbale;
	}
	
	/**Operazione setStudente
	 * 
	 * @param s
	 */
	public void setStudente(Studente s) {
		this.s=s;
	}
	
	/**Operazione getStudente
	 * 	
	 * @return
	 */
	public Studente getStudente() {
		return s;
	}
	
	/**Operazione setInsegnamento
	 * 
	 * @param i
	 */
	public void setInsegnamento(Insegnamento i) {
		this.i=i;
	}
	
	/**Operazione getInsegnamento
	 * 
	 * @return
	 */
	public Insegnamento getInsegnamento() {
		return i;
	}
	/**Operazione isAccettaVoto
	 * 
	 * @param voto
	 * @return true se voto>=18 e lo studente ha accettato il voto esame
	 * 			false atrimenti
	 */
	public boolean isAccettaVoto(int voto) {
		if (voto>=18 &&  s.isAccettaVotoEsame()==true) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Operazione verbalizzaEsame
	 * 
	 * @param accetta_voto
	 */
	public void verbalizzaEsame() {
		boolean accetta_voto=isAccettaVoto(voto);
		if (accetta_voto==true) {
			esito_verbale="superato";
			setEsitoVerbale(esito_verbale);
		} else {
			esito_verbale="ritirato";
			setEsitoVerbale(esito_verbale);
		}
	}
}
