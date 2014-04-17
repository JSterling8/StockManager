package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfProductName;
	private JButton btnSubmit;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductGUI frame = new AddProductGUI(new AddStockGUI());
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
	public AddProductGUI(AddStockGUI addStockGUI) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Product");
		setBounds(100, 100, 450, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 150, 35);
		contentPane.add(lblProductName);
		
		tfProductName = new JTextField();
		tfProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProductName.setBounds(169, 11, 255, 35);
		contentPane.add(tfProductName);
		tfProductName.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmationGUI cg = new ConfirmationGUI(AddProductGUI.this);
				setVisible(false);
			}
		});
		btnSubmit.setBounds(314, 57, 100, 35);
		contentPane.add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(179, 57, 100, 35);
		contentPane.add(btnCancel);
	}
	
	/**
	 * Return product name
	 */
	
	public String getName() {
		
		return tfProductName.getText();
		
	}
}
