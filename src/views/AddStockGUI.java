package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddStockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfUnits;
	private JTable table;
	private JComboBox cbProductName;
	private JComboBox cbSupplier;
	private JTextField tfPricePerUnit;
	private JTextField tfRRP;
	private JTextField tfVAT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStockGUI frame = new AddStockGUI();
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
	public AddStockGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Stock");
		setBounds(100, 100, 545, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 277, 35);
		contentPane.add(lblProductName);

		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSupplier.setBounds(10, 57, 277, 35);
		contentPane.add(lblSupplier);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(10, 103, 115, 35);
		contentPane.add(lblUnits);

		JLabel lblPricePerUnit = new JLabel("Price/Unit");
		lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPricePerUnit.setBounds(82, 103, 115, 35);
		contentPane.add(lblPricePerUnit);

		JLabel lblVat = new JLabel("VAT %");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVat.setBounds(197, 103, 115, 35);
		contentPane.add(lblVat);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(10, 305, 177, 35);
		contentPane.add(lblAttachInvoice);

		JLabel lblRecommendedRetailPrice = new JLabel("RRP");
		lblRecommendedRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecommendedRetailPrice.setBounds(281, 103, 115, 35);
		contentPane.add(lblRecommendedRetailPrice);

		cbProductName = new JComboBox();
		cbProductName.setModel(new DefaultComboBoxModel(new String[] {"Test1", "Test2", "Test3"}));
		cbProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbProductName.setBounds(197, 12, 250, 35);
		contentPane.add(cbProductName);

		JButton btnAddProduct = new JButton("+");
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddProduct.setBounds(476, 11, 50, 35);
		contentPane.add(btnAddProduct);

		cbSupplier = new JComboBox();
		cbSupplier.setModel(new DefaultComboBoxModel(new String[] {"Test11", "Test22", "Test33"}));
		cbSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbSupplier.setBounds(197, 58, 250, 35);
		contentPane.add(cbSupplier);

		JButton btnAddSupplier = new JButton("+");
		btnAddSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSupplier.setBounds(476, 57, 50, 35);
		contentPane.add(btnAddSupplier);

		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(10, 149, 50, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);
		tfUnits.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b') && (character != '.')) {
					e.consume();
				}
			}
		});

		tfPricePerUnit = new JTextField();
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setColumns(10);
		tfPricePerUnit.setBounds(90, 149, 50, 35);
		contentPane.add(tfPricePerUnit);
		tfPricePerUnit.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b') && (character != '.')) {
					e.consume();
				}
			}
		});

		tfVAT = new JTextField();
		tfVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVAT.setColumns(10);
		tfVAT.setBounds(195, 149, 50, 35);
		contentPane.add(tfVAT);
		tfVAT.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b') && (character != '.')) {
					e.consume();
				}
			}
		});

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(197, 305, 329, 35);
		contentPane.add(btnBrowse);

		tfRRP = new JTextField();
		tfRRP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfRRP.setColumns(10);
		tfRRP.setBounds(275, 149, 50, 35);
		contentPane.add(tfRRP);
		tfRRP.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b')) {
					e.consume();
				}
			}
		});

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmationGUI cg = new ConfirmationGUI(AddStockGUI.this);
				setVisible(false);
			}
		});
		btnSubmit.setBounds(396, 351, 100, 35);
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(227, 351, 100, 35);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 516, 99);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateInput();
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(372, 149, 154, 35);
		contentPane.add(btnInsert);
	}

	/**
	 * Checks that the user has entered all of the required information
	 * in order to add to the database.
	 * 
	 * @return Returns true if the user has entered all of the required information.
	 * 			Returns false if the user hasn't entered all of the required information.
	 */
	public boolean validateInput(){
		boolean isValid = true;
		
		if (cbProductName.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a product name.");
			isValid = false;
		}
		else if (cbSupplier.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a supplier name.");
			isValid = false;
		}
		else if(tfUnits.getText() != null && tfUnits.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a number of units.");
			isValid = false;
		}
		else if(tfPricePerUnit.getText() != null && tfPricePerUnit.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a price per unit.");
			isValid = false;
		}
		else if(tfVAT.getText() != null && tfVAT.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter an amount of VAT.");
			isValid = false;
		}
		else if(tfRRP.getText() != null && tfRRP.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a RRP.");
			isValid = false;
		}
		
		return isValid;
	}
}
