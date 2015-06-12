import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPasswordField;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
/**
 * Implements the frame for the log in
 * 
 * @author Delia
 *
 */
public class loginProprietar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginProprietar frame = new loginProprietar();
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
	public loginProprietar() {
		setTitle("Agenda Personala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 291);
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

		textField = new JTextField();
		textField.setBounds(169, 58, 184, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 57, 130, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 103, 73, 21);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(169, 104, 184, 23);
		contentPane.add(passwordField);

		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Proprietar> das = new ArrayList<Proprietar>();
				das = ProprietarUtil.getAllProprietar();
				// for(int i = 0;i<das.size();i++){

				if (das.get(0).getUtilizator().equals(textField.getText())
						&& das.get(0).getParola()
								.equals(passwordField.getText())) {

					String idUtil = textField.getText()
							+ passwordField.getText();
					Profil profil = new Profil(idUtil);
					profil.setVisible(true);

					// }
				} else {
					JFrame frame = new JFrame("Eroare Conectare");
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JLabel lbl = new JLabel("Parola sau username gresit.");
					frame.getContentPane().add(lbl, BorderLayout.CENTER);
					frame.pack();
					frame.setSize(200, 200);
					frame.setVisible(true);

				}

			}
		});

		btnLogIn.setBounds(200, 160, 158, 31);
		contentPane.add(btnLogIn);

	}
}