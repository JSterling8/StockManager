package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddSupplierGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField tfAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSupplierGUI frame = new AddSupplierGUI();
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
	public AddSupplierGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Add Supplier");
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(30, 6, 98, 35);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(30, 48, 98, 35);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(30, 95, 98, 35);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(30, 142, 98, 35);
		contentPane.add(lblAddress);
		
		tfName = new JTextField();
		tfName.setBounds(140, 9, 200, 35);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(140, 53, 200, 35);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(140, 100, 200, 35);
		contentPane.add(tfPhone);
		tfPhone.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(140, 147, 200, 35);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancel.setBounds(60, 194, 100, 30);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO Pass user's input to the confirmation GUI
				
				dispose();
				
			}
		});
		btnOk.setBounds(220, 194, 100, 30);
		contentPane.add(btnOk);
	}

}
