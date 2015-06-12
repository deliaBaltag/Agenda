/**
 * Implements an owner of the agenda and contains his username and password.
 * 
 * @author Delia
 *
 */
public class Proprietar {
	private int idProprietar;
	private String utilizator;
	private String parola;

	/**
	 * Constructs an owner 
	 * 
	 */
	
	public Proprietar() {
		this.idProprietar = 0;
		this.utilizator = "";
		this.parola = "";
	}

	public int getIdProprietar() {
		return idProprietar;
	}

	public void setIdProprietar(int idProprietar) {
		this.idProprietar = idProprietar;
	}

	public String getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Proprietar(int idProprietar, String utilizator, String parola) {
		super();
		this.idProprietar = idProprietar;
		this.utilizator = utilizator;
		this.parola = parola;
	}

	@Override
	public String toString() {
		return "Proprietar [idProprietar=" + idProprietar + ", utilizator="
				+ utilizator + ", parola=" + parola + "]";
	}

}