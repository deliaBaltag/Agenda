import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTable;

import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
/**
 * Implements the main frame for the owner with his information 
 * and different functions.
 * 
 * @author Delia
 *
 */
public class Profil extends JFrame {
	private JPanel contentPane;
	protected static final String idUtil = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profil frame = new Profil(idUtil);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profil(String Id) {
		setTitle("Contul meu");
		setBounds(100, 100, 639, 271);
		contentPane = new JPanel() {
			// BACKGROUND
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(
						loginProprietar.class.getResource("/pack/galaxy.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnEvenimente = new JMenu("Persoane");
		mnEvenimente.setFont(new Font("Tahoma", Font.BOLD, 13));
		mnEvenimente.setForeground(Color.BLACK);
		menuBar.add(mnEvenimente);

		JMenuItem mntmPersoaneleMele = new JMenuItem("Persoanele mele");
		mntmPersoaneleMele.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmPersoaneleMele.setForeground(Color.BLACK);
		mntmPersoaneleMele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersoanaTabel.persoana();
			}
		});
		mnEvenimente.add(mntmPersoaneleMele);

		JMenuItem mntmEditarePersoane = new JMenuItem("Adaugare persoana");
		mntmEditarePersoane.setForeground(Color.BLACK);
		mntmEditarePersoane.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmEditarePersoane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarePersoane edit_pers = new EditarePersoane(Id);
				edit_pers.setVisible(true);
			}
		});
		mnEvenimente.add(mntmEditarePersoane);

		JMenuItem mntmStergerePersoane = new JMenuItem("Stergere persoana");
		mntmStergerePersoane.setForeground(Color.BLACK);
		mntmStergerePersoane.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmStergerePersoane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StergerePersoane erase_pers = new StergerePersoane(Id);
				erase_pers.setVisible(true);
			}
		});
		mnEvenimente.add(mntmStergerePersoane);

		JMenu mnNewMenu_1 = new JMenu("Evenimente");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmToateEvenimenteleLa = new JMenuItem("Evenimentele mele");
		mntmToateEvenimenteleLa.setForeground(Color.BLACK);
		mntmToateEvenimenteleLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmToateEvenimenteleLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvenimenteTabel.eveniment();
			}
		});
		mnNewMenu_1.add(mntmToateEvenimenteleLa);

		JMenuItem mntmEditareEvenimente = new JMenuItem("Adaugare eveniment");
		mntmEditareEvenimente.setForeground(Color.BLACK);
		mntmEditareEvenimente.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmEditareEvenimente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EditareEvenimente edit_ev = new EditareEvenimente(Id);
				edit_ev.setVisible(true);

			}
		});
		mnNewMenu_1.add(mntmEditareEvenimente);

		JMenuItem mntmStergereEvenimente = new JMenuItem("Stergere eveniment");
		mntmStergereEvenimente.setForeground(Color.BLACK);
		mntmStergereEvenimente.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmStergereEvenimente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StergereEvenimente erase_ev = new StergereEvenimente(Id);
				erase_ev.setVisible(true);

			}
		});
		mnNewMenu_1.add(mntmStergereEvenimente);

		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblDateleMele = new JLabel("Date Personale");
		lblDateleMele.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateleMele.setForeground(Color.BLACK);
		lblDateleMele.setBounds(22, 21, 150, 35);
		getContentPane().add(lblDateleMele);

		// ADAUGARE TABEL
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();

		String url = "jdbc:mysql://localhost:3306/agendafinala";
		String userid = "root";
		String password = "root";
		String sql = "SELECT nume, prenume, CNP, email, telefon FROM proprietar_detalii";
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 67, 580, 58);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

	}
}