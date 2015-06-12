import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Processing the database table for events.
 * 
 * @author Delia
 *
 */
public class EvenimenteUtil {

	public static final String CONNECTION_URL = "jdbc:mysql://localhost/agendafinala";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONNECTION_URL, "root", "root");
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * Add a given event in database .
	 * 
	 * @param emp
	 *            the event which is added in database .An object of class
	 *            Evenimente.
	 */
	public void addEvenimente(Evenimente emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"insert into Evenimente(denumire, descriere, locatie, data_ora) values(?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getDenumire());
			ps.setString(2, emp.getDescriere());
			ps.setString(3, emp.getLocatie());
			ps.setString(4, emp.getData_ora());

			int affectedRows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				emp.setIdEvenimente(rs.getInt(1));
			}
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update an event in database.
	 * 
	 * @param emp
	 *            the event which is updated . An object of class Evenimente .
	 * @return <code>true</code> if the event is updated in database ;
	 *         <code>false</code> otherwise
	 */
	
	public boolean updateEvenimente(Evenimente emp) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update Evenimente set denumire = ?, descriere = ?, locatie = ?,data_ora = ? where idEvenimente = ?");
			ps.setString(1, emp.getDenumire());
			ps.setString(2, emp.getDescriere());
			ps.setString(3, emp.getLocatie());
			ps.setString(4, emp.getData_ora());

			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns <code>true</code> if the event is deleted from database.
	 * 
	 * @param id
	 *            the primary key of the event which is deleted from database
	 * @return<code>true</code> if the event is deleted from database ;
	 *                          <code>false</code> otherwise
	 */
	public boolean deleteEvenimente(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("delete from Evenimente where idEvenimente = ?");
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			closeConnection(conn);
			return affectedRows == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Returns the event searched.
	 * 
	 * @param id
	 *            the primary key of the event which is searched in database
	 * @return the event searched in database
	 */

	public Evenimente findById(int id) {
		Evenimente emp = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select denumire, descriere, locatie, data_ora from Evenimente where idEvenimente = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("idEvenimente");
				String denumire = rs.getString("denumire");
				String descriere = rs.getString("descriere");
				String locatie = rs.getString("locatie");
				String data_ora = rs.getString("data_ora");

				emp = new Evenimente(id2, denumire, descriere, locatie,
						data_ora);

			}
			closeConnection(conn);
			return emp;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Get all events from database and return it in an ArrayList .
	 * 
	 * @return an ArrayList which contains all events from database
	 */

	public Evenimente[] getAllEvenimente() {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from Evenimente");
			ResultSet rs = ps.executeQuery();
			List<Evenimente> EvenimenteList = new ArrayList<Evenimente>();
			while (rs.next()) {
				int id = rs.getInt("idEvenimente");
				String denumire = rs.getString("denumire");
				String descriere = rs.getString("descriere");
				String locatie = rs.getString("locatie");
				String data_ora = rs.getString("data_ora");

				EvenimenteList.add(new Evenimente(id, denumire, descriere,
						locatie, data_ora));
			}
			closeConnection(conn);
			return EvenimenteList
					.toArray(new Evenimente[EvenimenteList.size()]);
		} catch (SQLException e) {
			return null;
		}
	}

	// test

	public static void insertEveniment(int id, String denumire,
			String descriere, String locatie, String data) {
		Evenimente e1 = new Evenimente(1, denumire, descriere, locatie, data);
		EvenimenteUtil ev = new EvenimenteUtil();
		ev.addEvenimente(e1);
	}

	public static void eraseEveniment(int id) {
		// Evenimente e1 = new Evenimente (1, denumire, descriere, locatie,
		// data);
		EvenimenteUtil ev = new EvenimenteUtil();
		ev.deleteEvenimente(id);
	}

}
