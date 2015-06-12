/**
 * Implements the owner's personal information of the agenda.
 * 
 * @author Delia
 *
 */

public class Proprietar_detalii {
	private int id;
	private String nume;
	private String prenume;
	private String CNP;
	private String email;
	private String telefon;

	@Override
	public String toString() {
		return "Proprietar_detalii [id=" + id + ", nume=" + nume + ", prenume="
				+ prenume + ", CNP=" + CNP + ", email=" + email + ", telefon="
				+ telefon + "]";
	}
	
	/**
	 * Constructs owner's personal informations with a specified id ,lastName, firstName,
	 * CNP,email and phone number
	 * 
	 * @param id
	 *            the primary key of the owner's details
	 * @param nume
	 *            the owner's last name
	 * @param prenume
	 *            the owner's first name
	 * @param CNP
	 *            the owner's CNP
	 * @param email
	 *            the owner's email
	 * @param telefon
	 * 			  the owner's phone number

	 */

	public Proprietar_detalii(int id, String nume, String prenume, String cNP,
			String email, String telefon) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		CNP = cNP;
		this.email = email;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}