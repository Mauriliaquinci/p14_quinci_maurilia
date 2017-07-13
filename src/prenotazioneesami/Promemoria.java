package prenotazioneesami;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */

/** Promemoria in cui vengono specificati: data, aula e orario
 * 
 */
public class Promemoria {
	
	/** Attributes */
	private String data;
	private String aula;
	private String orario;
	
	/**Costruttore
	 * 
	 * @param data
	 * @param aula
	 * @param orario
	 */
	public Promemoria(String data, String aula, String orario){
		super();
		this.data=data;
		this.aula=aula;
		this.orario=orario;
	}
	
	/**Operazione getData
	 * 
	 * @return data
	 */
	public String getData() {
		return data;
	}
	
	/**Operazione setData
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data=data;
	}
	
	/**Operazione getAula
	 * 
	 * @return aula
	 */
	public String getAula() {
		return aula;
	}
	
	/**Operazione setAula
	 * 
	 * @param aula
	 */
	public void setAula(String aula) {
		this.aula=aula;
	}
	
	/**Operazione getOrario
	 * 
	 * @return orario
	 */
	public String getOrario() {
		return orario;
	}
	
	/**Operazione setOrario
	 * 
	 * @param orario
	 */
	public void setOrario(String orario) {
		this.orario=orario;
	}
	
	public void stampaPromemoria(Promemoria p) {
		setData(p.data);
		setAula(p.aula);
		setOrario(p.orario);
	}

}
