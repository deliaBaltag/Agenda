import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
/**
 * Implements the frame for adding a person
 * 
 * @author Delia
 *
 */
public class EditarePersoane extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected static final String Id = null;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarePersoane frame = new EditarePersoane(Id);
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
	public EditarePersoane(String IdUtilizator) {
		setTitle("Adaugare persoana");
		setBounds(100, 100, 540, 340);
		contentPane = new JPanel() {
			// BACKGROUND
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(
						loginProprietar.class.getResource("/pack/infoo.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNume = new JLabel("Nume");
		lblNume.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNume.setForeground(Color.BLACK);
		lblNume.setBounds(63, 40, 92, 17);
		contentPane.add(lblNume);

		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setForeground(Color.BLACK);
		lblPrenume.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenume.setBounds(63, 71, 92, 17);
		contentPane.add(lblPrenume);

		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresa.setForeground(Color.BLACK);
		lblAdresa.setBounds(63, 99, 92, 18);
		contentPane.add(lblAdresa);

		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setForeground(Color.BLACK);
		lblCnp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCnp.setBounds(63, 128, 92, 17);
		contentPane.add(lblCnp);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefon.setForeground(Color.BLACK);
		lblTelefon.setBounds(63, 156, 92, 17);
		contentPane.add(lblTelefon);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(63, 184, 92, 17);
		contentPane.add(lblEmail);

		textField = new JTextField();
		textField.setBounds(187, 41, 286, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(187, 70, 286, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(187, 99, 286, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(187, 127, 286, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(187, 155, 286, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(187, 183, 286, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersoanaUtil.insertPersoana(60, textField.getText(),
						textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(),
						textField_5.getText());
				System.out.println("Adaugare persoana reusita!");
			}
		});
		btnNewButton.setBounds(339, 238, 103, 41);
		contentPane.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(0, 100, 0));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
				textField_4.setText(" ");
				textField_5.setText(" ");
			}
		});

		btnClear.setBounds(226, 238, 103, 41);
		contentPane.add(btnClear);
	}
}