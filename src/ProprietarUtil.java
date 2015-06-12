import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Processing the database table for owner.
 * 
 * @author Delia
 *
 */
public class ProprietarUtil {

	public static final String CONNECTION_URL = "jdbc:mysql://localhost/agendafinala";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONNECTION_URL, "root", "root");
	}

	public static void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * Add a given owner in database .
	 * 
	 * @param emp
	 *            the owner which is added in database .An object of class
	 *            Proprietar.
	 */
	public void addProprietar(Proprietar emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into Proprietar(utilizator, parola) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getUtilizator());
			ps.setString(2, emp.getParola());
			int affectedRows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				emp.setIdProprietar(rs.getInt(1));
			}
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update an owner in database.
	 * 
	 * @param emp
	 *            the owner which is updated . An object of class Proprietar .
	 * @return <code>true</code> if the owner is updated in database ;
	 *         <code>false</code> otherwise
	 */
	public boolean updateProprietar(Proprietar emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update Proprietar set utilizator = ?, parola = ? where idProprietar = ?");
			ps.setString(1, emp.getUtilizator());
			ps.setString(2, emp.getParola());
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns <code>true</code> if the owner is deleted from database.
	 * 
	 * @param id
	 *            the primary key of the owner which is deleted from database
	 * @return<code>true</code> if the owner is deleted from database ;
	 *                          <code>false</code> otherwise
	 */
	public static boolean deleteProprietar(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("delete from Proprietar where idProprietar = ?");
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns the owner searched.
	 * 
	 * @param id
	 *            the primary key of the owner which is searched in database
	 * @return the owner searched in database
	 */

	public Proprietar findById(int id) {
		Proprietar emp = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from Proprietar where idProprietar = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("idProprietar");
				String utilizator = rs.getString("utilizator");
				String parola = rs.getString("parola");

				emp = new Proprietar(id, "utilizator", "parola");

			}
			closeConnection(conn);
			return emp;
		} catch (SQLException e) {
			return null;
		}
	}


	/**
	 * Get all owners from database and return it in an ArrayList .
	 * 
	 * @return an ArrayList which contains all owners from database
	 */

	public static List getAllProprietar() {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from Proprietar");
			ResultSet rs = ps.executeQuery();
			List<Proprietar> ProprietarList = new ArrayList<Proprietar>();
			while (rs.next()) {
				int id = rs.getInt("idProprietar");
				String utilizator = rs.getString(2);
				String parola = rs.getString(3);

				ProprietarList.add(new Proprietar(id, utilizator, parola));
			}
			closeConnection(conn);
			// return ProprietarList.toArray(new
			// Proprietar[ProprietarList.size()]);
			return ProprietarList;
		} catch (SQLException e) {
			return null;
		}
	}

	public static void insertProprietar(int id, String utilizator, String parola) {
		Proprietar e1 = new Proprietar(1, utilizator, parola);
		ProprietarUtil ev = new ProprietarUtil();
		ev.addProprietar(e1);
	}

	public ProprietarUtil() {
	}

	// test

	public static void main(String[] args) {
		Proprietar e1 = new Proprietar(1, "Delia Baltag", "1234");

		ProprietarUtil p = new ProprietarUtil();

	}

	public static int intconvert(String s) { // convert from string to int
		int val;
		try {
			val = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			val = 0;
		}
		return val;
	}
}