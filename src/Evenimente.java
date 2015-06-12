/**
 * Implements an event from the agenda and contains information about
 * this.
 * 
 * @author Delia
 *
 */
public class Evenimente {
	private int idEvenimente;
	private String denumire;
	private String descriere;
	private String locatie;
	private String data_ora;

	@Override
	public String toString() {
		return "Evenimente [idEvenimente=" + idEvenimente + ", denumire="
				+ denumire + ", descriere=" + descriere + ", locatie="
				+ locatie + ", data_ora=" + data_ora + "]";
	}
	
	/**
	 * Constructs an event with a specified id ,name, description,
	 * location and date/hour
	 * 
	 * @param idEvenimente
	 *            the primary key of the event
	 * @param nume
	 *            the event's last name
	 * @param descriere
	 *            the event's description
	 * @param locatie
	 *            the event's location
	 * @param data_ora
	 *            the event's date/hour

	 */

	public Evenimente(int idEvenimente, String denumire, String descriere,
			String locatie, String data_ora) {
		super();
		this.idEvenimente = idEvenimente;
		this.denumire = denumire;
		this.descriere = descriere;
		this.locatie = locatie;
		this.data_ora = data_ora;
	}

	public int getIdEvenimente() {
		return idEvenimente;
	}

	public void setIdEvenimente(int idEvenimente) {
		this.idEvenimente = idEvenimente;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public String getData_ora() {
		return data_ora;
	}

	public void setData_ora(String data_ora) {
		this.data_ora = data_ora;
	}

}