/**
 * Implements the frame for adding an event
 * 
 * @author Delia
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class EditareEvenimente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	protected static final String Id = null;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditareEvenimente frame = new EditareEvenimente(Id);
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
	public EditareEvenimente(String IdUtilizator) {
		setTitle("Adaugare eveniment");
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

		JLabel lblDenumireEveniment = new JLabel("Denumire eveniment");
		lblDenumireEveniment.setForeground(Color.BLACK);
		lblDenumireEveniment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDenumireEveniment.setBounds(29, 41, 146, 24);
		contentPane.add(lblDenumireEveniment);

		JLabel lblDescriere = new JLabel("Descriere");
		lblDescriere.setForeground(Color.BLACK);
		lblDescriere.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescriere.setBounds(29, 124, 146, 24);
		contentPane.add(lblDescriere);

		JLabel lblLocatie = new JLabel("Locatie");
		lblLocatie.setForeground(Color.BLACK);
		lblLocatie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocatie.setBounds(29, 81, 146, 24);
		contentPane.add(lblLocatie);

		JLabel lblDataSiOra = new JLabel("Data si ora");
		lblDataSiOra.setForeground(Color.BLACK);
		lblDataSiOra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataSiOra.setBounds(29, 170, 146, 23);
		contentPane.add(lblDataSiOra);

		textField = new JTextField();
		textField.setBounds(181, 44, 324, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(181, 84, 324, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(181, 127, 324, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(181, 172, 324, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText("Exemplu: 12.04.2014/13:00");

		// BUTONUL DE INSERARE EVENIMENT
		btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvenimenteUtil.insertEveniment(10, textField.getText(),
						textField_1.getText(), textField_2.getText(),
						textField_3.getText());
				System.out.println("Adaugare eveniment reusita!");
			}
		});
		btnNewButton.setBounds(386, 248, 108, 34);
		contentPane.add(btnNewButton);

		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
			}
		});
		btnNewButton_2.setBounds(264, 248, 108, 34);
		contentPane.add(btnNewButton_2);

	}
}