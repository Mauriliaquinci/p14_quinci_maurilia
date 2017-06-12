package prenotazioneesami;

/**
 * 
 * @version 1.0 28.06.2017
 * @author Maurilia Quinci
 *
 */
/** Generalizza le classi Studente e Docente. Quest'ultime ereditano tutti gli attrubuti presenti 
 */
public class UtenteRegistrato {
	
	/** Attributes */
	protected String matricola;
	protected String nome;
	protected String cognome;
	protected String email;
	protected String password;
	protected boolean s_d;
	
	/**Costruttore
	 * 
	 * @param matricola
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param s_d che distingue uno studente da un docente
	 */
	public UtenteRegistrato(String matricola, String nome, String cognome,
							String email, String password, boolean s_d) {
		super();
		this.matricola=matricola;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.password=password;
		this.s_d=s_d;
	}
	
	/**Costruttore senza parametri
	 * 
	 */
	public UtenteRegistrato() {}
	
	/**Operazione getMatricola
	 * 
	 * @return matricola
	 */
	public String getMatricola() {
		return matricola;
	}
	
	/**Operazione setMatricola
	 * 
	 * @param matr
	 */
	public void setMatricola(String matr) {
		matricola=matr;
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
	
	/**Operazione getCognome
	 * 
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**Operazione setCognome
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	/**Operazione getEmail
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**Operazione setEmail
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email=email;
	}
	
	/**Operazione getPassword
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**Operazione setPassword
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password=password;
	}
	
	/**Operazione getS_D
	 * 
	 * @return s_d
	 */
	public boolean getS_D() {
		return s_d;
	}
	
	/**Operazione setS_D
	 * 
	 * @param s_d
	 */
	public void setS_D(boolean s_d) {
		this.s_d=s_d;
	}
	
}
