import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Processing the database table for owner's personal information.
 * 
 * @author Delia
 *
 */
public class Proprietar_detaliiUtil {

	public static final String CONNECTION_URL = "jdbc:mysql://localhost/agendafinala";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONNECTION_URL, "root", "root");
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * Add a given owner's personal information in database .
	 * 
	 * @param emp
	 *            the details which are added in database .An object of class
	 *            Proprietar_detalii.
	 */
	public void addProprietar_detalii(Proprietar_detalii emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"insert into Proprietar_detalii(nume, prenume, CNP, email, telefon) values(?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getNume());
			ps.setString(2, emp.getPrenume());
			ps.setString(3, emp.getCNP());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getTelefon());

			int affectedRows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				emp.setId(rs.getInt(1));
			}
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update an owner's details in database.
	 * 
	 * @param emp
	 *            the owner's details which are updated . An object of class Proprietar_detalii .
	 * @return <code>true</code> if the owner's details are updated in database ;
	 *         <code>false</code> otherwise
	 */
	public boolean updateProprietar_detalii(Proprietar_detalii emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update Proprietar_detalii set nume = ?, prenume = ?, CNP = ?, email = ?, telefon = ? where idProprietar_detalii = ?");
			ps.setString(1, emp.getNume());
			ps.setString(2, emp.getPrenume());
			ps.setString(3, emp.getCNP());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getTelefon());

			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns <code>true</code> if the owner's details are deleted from database.
	 * 
	 * @param id
	 *            the primary key of the owner's details which are deleted from database
	 * @return<code>true</code> if the owner's details are deleted from database ;
	 *                          <code>false</code> otherwise
	 */
	public boolean deleteProprietar_detalii(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("delete from Proprietar_detalii where idProprietar_detalii = ?");
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns the owner's details searched.
	 * 
	 * @param id
	 *            the primary key of the owner's details which are searched in database
	 * @return the owner's details searched in database
	 */

	public Proprietar_detalii findById(int id) {
		Proprietar_detalii emp = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from Proprietar_detalii where idProprietar_detalii = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("idProprietar_detalii");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String CNP = rs.getString("CNP");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");

				emp = new Proprietar_detalii(id, "nume", "prenume", "CNP",
						"email", "telefon");

			}
			closeConnection(conn);
			return emp;
		} catch (SQLException e) {
			return null;
		}
	}


	/**
	 * Get all owners with their personal information from database and return it in an ArrayList .
	 * 
	 * @return an ArrayList which contains all owners with their personal information from database
	 */

	public Proprietar_detalii[] getAllProprietar_detalii() {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from Proprietar_detalii");
			ResultSet rs = ps.executeQuery();
			List<Proprietar_detalii> Proprietar_detaliiList = new ArrayList<Proprietar_detalii>();
			while (rs.next()) {
				int id = rs.getInt("idProprietar_detalii");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String CNP = rs.getString("CNP");
				String email = rs.getString("email");
				String telefon = rs.getString("telefon");

				Proprietar_detaliiList.add(new Proprietar_detalii(id, "nume",
						"prenume", "CNP", "email", "telefon"));
			}
			closeConnection(conn);
			return Proprietar_detaliiList
					.toArray(new Proprietar_detalii[Proprietar_detaliiList
							.size()]);
		} catch (SQLException e) {
			return null;
		}
	}

	public static void updateProprietar_detalii(int id, String nume,
			String prenume, String CNP, String email, String telefon) {
		Proprietar_detalii e1 = new Proprietar_detalii(1, nume, prenume, CNP,
				email, telefon);
		Proprietar_detaliiUtil ev = new Proprietar_detaliiUtil();
		ev.updateProprietar_detalii(e1);
	}

	// test
	public static void main(String[] args) {

		Proprietar_detalii e1 = new Proprietar_detalii(1, "Delia", "Baltag",
				"2930929848200", "deliabaltag@yahoo.com", "0763811118");

		Proprietar_detaliiUtil p = new Proprietar_detaliiUtil();

	}
}