import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Processing the database table for persons.
 * 
 * @author Delia
 *
 */
public class PersoanaUtil {

	public static final String CONNECTION_URL = "jdbc:mysql://localhost/agendafinala";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONNECTION_URL, "root", "root");
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * Add a given person in database .
	 * 
	 * @param emp
	 *            the person which is added in database .An object of class
	 *            Persoana.
	 */
	public void addPersoana(Persoana emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"insert into persoana(nume, prenume, adresa, CNP, telefon, email) values(?,?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getNume());
			ps.setString(2, emp.getPrenume());
			ps.setString(3, emp.getAdresa());
			ps.setString(4, emp.getCNP());
			ps.setString(5, emp.getTelefon());
			ps.setString(6, emp.getEmail());

			// ps.setInt(8, emp.id_p);
			int affectedRows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				emp.setIdPersoana(rs.getInt(1));
			}
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update a person in database.
	 * 
	 * @param emp
	 *            the person which is updated . An object of class Persoana .
	 * @return <code>true</code> if the person is updated in database ;
	 *         <code>false</code> otherwise
	 */
	public boolean updatePersoana(Persoana emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update persoana set nume = ?, prenume = ?, adresa = ?, CNP = ?, telefon = ?, email = ? where idPersoana = ?");
			ps.setString(1, emp.getNume());
			ps.setString(2, emp.getPrenume());
			ps.setString(3, emp.getAdresa());
			ps.setString(4, emp.getCNP());
			ps.setString(5, emp.getTelefon());
			ps.setString(6, emp.getEmail());

			// ps.setInt(8, emp.id_p);
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns <code>true</code> if the person is deleted from database.
	 * 
	 * @param id
	 *            the primary key of the person which is deleted from database
	 * @return<code>true</code> if the person is deleted from database ;
	 *                          <code>false</code> otherwise
	 */
	public boolean deletePersoana(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("delete from persoana where idPersoana = ?");
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns the person searched.
	 * 
	 * @param id
	 *            the primary key of the person which is searched in database
	 * @return the person searched in database
	 */

	public Persoana findByIdPersoana(int id) {
		Persoana emp = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from persoana where idPersoana = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("idPersoana");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String adresa = rs.getString("adresa");
				String CNP = rs.getString("CNP");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");

				// int id_p = rs.getInt("id_p");
				emp = new Persoana(id, nume, prenume, adresa, CNP, telefon,
						email);

			}
			closeConnection(conn);
			return emp;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Get all persons from database and return it in an ArrayList .
	 * 
	 * @return an ArrayList which contains all persons from database
	 */

	public Persoana[] getAllPersoana() {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from persoana");
			ResultSet rs = ps.executeQuery();
			List<Persoana> PersoanaList = new ArrayList<Persoana>();
			while (rs.next()) {
				int id = rs.getInt("idPersoana");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String adresa = rs.getString("adresa");
				String CNP = rs.getString("CNP");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");

				// int id_p = rs.getInt("id_p");

				PersoanaList.add(new Persoana(id, "nume", "prenume", "adresa",
						"CNP", "telefon", "email"));
			}
			closeConnection(conn);
			return PersoanaList.toArray(new Persoana[PersoanaList.size()]);
		} catch (SQLException e) {
			return null;
		}
	}

	public static void insertPersoana(int id, String nume, String prenume,
			String adresa, String CNP, String telefon, String email) {
		Persoana e1 = new Persoana(1, nume, prenume, adresa, CNP, telefon,
				email);
		PersoanaUtil ev = new PersoanaUtil();
		ev.addPersoana(e1);
	}

	public static void erasePersoana(int id) {

		PersoanaUtil ev = new PersoanaUtil();
		if (ev.findByIdPersoana(id) != null)
			ev.deletePersoana(id);
		else
			System.out.println("Nu exista persoana la id-ul selectat.");
	}

	
}