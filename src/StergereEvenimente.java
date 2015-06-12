/**
 * Implements the frame for deleting an event
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

public class StergereEvenimente extends JFrame {

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
					StergereEvenimente frame = new StergereEvenimente(Id);
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
	public StergereEvenimente(String IdUtilizator) {
		setTitle("Stergere eveniment");
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

		JLabel lblDenumireEveniment = new JLabel("Id eveniment");
		lblDenumireEveniment.setForeground(Color.BLACK);
		lblDenumireEveniment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDenumireEveniment.setBounds(29, 41, 146, 24);
		contentPane.add(lblDenumireEveniment);

		textField = new JTextField();
		textField.setBounds(181, 44, 324, 20);
		contentPane.add(textField);
		textField.setColumns(10);

	
		btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvenimenteUtil.eraseEveniment(Integer.parseInt(textField
						.getText()));
				
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