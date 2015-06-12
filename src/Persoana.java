/**
 * Implements a person from the agenda and contains personal information about
 * this.
 * 
 * @author Delia
 *
 */
public class Persoana {

	private int idPersoana;
	private String nume;
	private String prenume;
	private String adresa;
	private String CNP;
	private String telefon;
	private String email;

	/**
	 * Constructs a person with a specified id ,first name, last name ,address
	 * CNP, phone number and email
	 * 
	 * @param idPersoana
	 *            the primary key of the person
	 * @param nume
	 *            the person's last name
	 * @param prenume
	 *            the person's first name
	 * @param adresa
	 *            the person's address
	 * @param CNP
	 *            the person's CNP
	 * @param telefon
	 * 			  the person's phone number
	 * @param email
	 * 			  the person's email
	 */
	
	public Persoana(int idPersoana, String nume, String prenume, String adresa,
			String cNP, String telefon, String email) {
		super();
		this.idPersoana = idPersoana;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		CNP = cNP;
		this.telefon = telefon;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persoana [idPersoana=" + idPersoana + ", nume=" + nume
				+ ", prenume=" + prenume + ", adresa=" + adresa + ", CNP="
				+ CNP + ", telefon=" + telefon + ", email=" + email + "]";
	}

	public int getIdPersoana() {
		return idPersoana;
	}

	public void setIdPersoana(int idPersoana) {
		this.idPersoana = idPersoana;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}