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
 * Implements the frame for deleting a person
 * 
 * @author Delia
 *
 */
public class StergerePersoane extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected static final String Id = null;;

	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StergerePersoane frame = new StergerePersoane(Id);
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
	public StergerePersoane(String IdUtilizator) {
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

		JLabel lblNume = new JLabel("ID");
		lblNume.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNume.setForeground(Color.BLACK);
		lblNume.setBounds(63, 40, 92, 17);
		contentPane.add(lblNume);

		textField = new JTextField();
		textField.setBounds(187, 41, 286, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersoanaUtil.erasePersoana(Integer.parseInt(textField.getText()));

				// System.out.println("Stergere persoana reusita!");
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

			}
		});

		btnClear.setBounds(226, 238, 103, 41);
		contentPane.add(btnClear);
	}
}