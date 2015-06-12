import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Implements a table with the persons from database.
 * 
 * @author Delia
 *
 */
public class PersoanaTabel extends JFrame {
	public PersoanaTabel() {
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		String url = "jdbc:mysql://localhost:3306/agendafinala";
		String userid = "root";
		String password = "root";
		String sql = "SELECT idPersoana, nume, prenume, adresa, telefon, email FROM persoana ";
		try (Connection connection = DriverManager.getConnection(url, userid,
				password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames.add(md.getColumnName(i));
			}

			while (rs.next()) {
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++) {
					row.add(rs.getObject(i));
				}

				data.add(row);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i < data.size(); i++) {
			ArrayList subArray = (ArrayList) data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++) {
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++)
			columnNamesVector.add(columnNames.get(i));

		JTable table = new JTable(dataVector, columnNamesVector) {
			public Class getColumnClass(int column) {
				for (int row = 0; row < getRowCount(); row++) {
					Object o = getValueAt(row, column);

					if (o != null) {
						return o.getClass();
					}
				}

				return Object.class;
			}
		};

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	public static void persoana() {
		PersoanaTabel frame = new PersoanaTabel();
		// frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		PersoanaTabel frame = new PersoanaTabel();
		// frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}
