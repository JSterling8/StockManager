package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddCompanyGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private String companyType;
	private AddStockGUI addStockGUI;

	
	/**
	 * Create the frame.
	 */
	public AddCompanyGUI(String companyType) {
		initialize(companyType);
	}
	
	public void initialize(String companyType){
		this.companyType = companyType;
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Add " + companyType);
		
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
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfName.setBounds(140, 9, 200, 35);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEmail.setBounds(140, 53, 200, 35);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPhone.setBounds(140, 100, 200, 35);
		contentPane.add(tfPhone);
		tfPhone.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
				ConfirmationGUI cg = new ConfirmationGUI(AddCompanyGUI.this);
				setVisible(false);
				
			}
		});
		btnOk.setBounds(220, 194, 100, 30);
		contentPane.add(btnOk);
		
		setVisible(true);
	}
	
	public String getCompanyType(){
		return companyType;
	}
	
	public String getName(){
		return tfName.getText();
	}
	
	public String getEmail(){
		return tfEmail.getText();
	}
	
	public String getPhone(){
		return tfPhone.getText();
	}
	
	public String getAddress(){
		return tfAddress.getText();
	}
}
