package prenotazioneesami;

import java.util.ArrayList;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */

/**
 * E' una sottoclasse della classe UtenteRegistrato.Ogni docente possiede una lista degli insegnamenti che insegna
*/
public class Docente  extends UtenteRegistrato {
	
	/** Association */
	private ArrayList<Insegnamento> insegnamenti;
	
	/**Costruttore con parametri
	 * /
	 * @param matricola
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param s_d
	 */
	public Docente(String matricola, String nome, String cognome, String email, 
					String password, boolean s_d) {
		super(matricola, nome, cognome, email, password, s_d);
		insegnamenti=new ArrayList<Insegnamento>();
	}
	
	/**Costruttore senza parametri
	 */
	 
	public Docente() {}
	
	/**Operazione getInsegnamenti
	 * @return insegnamenti
	 */
	public ArrayList<Insegnamento> getInsegnamenti() {
		return insegnamenti;
	}
	
	/**Operazione setInsegnamenti
	 * 
	 * @param insegnamenti
	 */
	public void setInsegnamenti(ArrayList<Insegnamento> insegnamenti) {
		this.insegnamenti=insegnamenti;
	}
	
}
