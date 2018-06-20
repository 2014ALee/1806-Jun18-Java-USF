package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingMain extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
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
	public SwingMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 203, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(66, 11, 111, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 42, 46, 14);
		contentPane.add(lblAge);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(66, 42, 111, 20);
		contentPane.add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 73, 46, 14);
		contentPane.add(lblPhone);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(66, 73, 111, 20);
		contentPane.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hello " + nameTextField.getText());
			}
		});
		btnSubmit.setBounds(10, 132, 89, 23);
		contentPane.add(btnSubmit);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(66, 104, 111, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 104, 46, 14);
		contentPane.add(lblEmail);
	}
}
