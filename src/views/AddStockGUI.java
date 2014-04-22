package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import models.Supplier;
import controllers.ProductController;
import controllers.SupplierController;

public class AddStockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfUnits;
	private JTable table;
	private JComboBox cbProductName;
	private JComboBox<Supplier> cbSupplier;
	private JTextField tfPricePerUnit;
	private JTextField tfRRP;
	private JTextField tfTotalPrice;
	private DefaultTableModel tableModel;
	private double totalPrice;
	private ArrayList<Double> pricePerUnitList;
	private ArrayList<Double> priceList;
	private ArrayList<Double> rrpList;
	

	/**
	 * Create the frame.
	 */
	public AddStockGUI() {
		
		pricePerUnitList = new ArrayList<Double>();
		priceList = new ArrayList<Double>();
		rrpList = new ArrayList<Double>();
		
		totalPrice = 0;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Stock");
		setBounds(100, 100, 545, 485);
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
		lblUnits.setBounds(10, 104, 115, 35);
		contentPane.add(lblUnits);

		JLabel lblPricePerUnit = new JLabel("Price/Unit");
		lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPricePerUnit.setBounds(114, 104, 115, 35);
		contentPane.add(lblPricePerUnit);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(10, 305, 177, 35);
		contentPane.add(lblAttachInvoice);

		JLabel lblRecommendedRetailPrice = new JLabel("RRP");
		lblRecommendedRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecommendedRetailPrice.setBounds(241, 104, 115, 35);
		contentPane.add(lblRecommendedRetailPrice);

		cbProductName = new JComboBox();
		cbProductName.setModel(new DefaultComboBoxModel(new String[] {}));
		cbProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbProductName.setBounds(197, 12, 250, 35);
		contentPane.add(cbProductName);
		for(int i = 0; i < ProductController.productList.size(); i++) {
			
			cbProductName.addItem(ProductController.productList.get(i));
			
		}

		JButton btnAddProduct = new JButton("+");
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddProduct.setBounds(476, 11, 50, 35);
		contentPane.add(btnAddProduct);

		cbSupplier = new JComboBox<Supplier>();
		cbSupplier.setModel(new DefaultComboBoxModel(new String[] {}));
		cbSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbSupplier.setBounds(197, 58, 250, 35);
		contentPane.add(cbSupplier);
		for(int i = 0; i < SupplierController.supplierList.size(); i++) {
			
			cbSupplier.addItem(SupplierController.supplierList.get(i));
			
		}
		
		
		JButton btnAddSupplier = new JButton("+");
		btnAddSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSupplier.setBounds(476, 57, 50, 35);
		contentPane.add(btnAddSupplier);

		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(10, 149, 73, 35);
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
		tfPricePerUnit.setBounds(114, 149, 73, 35);
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

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(197, 305, 329, 35);
		contentPane.add(btnBrowse);

		tfRRP = new JTextField();
		tfRRP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfRRP.setColumns(10);
		tfRRP.setBounds(241, 149, 73, 35);
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
		btnSubmit.setBounds(426, 399, 100, 35);
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(314, 399, 100, 35);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 516, 99);
		contentPane.add(scrollPane);

		tableModel = 
				new DefaultTableModel( new String[] { "Product Name", 
													"Units", 
													"Price Per Unit", 
													"Price" }, 
												0);
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateInput()) {
					double price = Double.parseDouble(tfUnits.getText()) * Double.parseDouble(tfPricePerUnit.getText());
					
					rrpList.add(Double.parseDouble(tfRRP.getText()));
					priceList.add(price);
					pricePerUnitList.add(Double.parseDouble(tfPricePerUnit.getText()));
					
					tableModel.addRow(new String[]{
							(String) cbProductName.getSelectedItem(),
							tfUnits.getText(),
							NumberFormat.getCurrencyInstance().format(Double.parseDouble(tfPricePerUnit.getText())),
							NumberFormat.getCurrencyInstance().format(price)});
					
							totalPrice = totalPrice + (Double.parseDouble(tfUnits.getText()) * Double.parseDouble(tfPricePerUnit.getText()));
							tfTotalPrice.setText("" + totalPrice);
					
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(372, 150, 154, 35);
		contentPane.add(btnInsert);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalPrice.setBounds(259, 352, 100, 35);
		contentPane.add(lblTotalPrice);
		
		tfTotalPrice = new JTextField();
		tfTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalPrice.setEditable(false);
		tfTotalPrice.setBounds(392, 352, 134, 35);
		contentPane.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		tfTotalPrice.setEditable(false);
	
		setVisible(true);
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

		else if(tfRRP.getText() != null && tfRRP.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a RRP.");
			isValid = false;
		}
		
		return isValid;
	}
	
	public JTable getTable() {
		
		return table;
		
	}
	
	public String getProductName() {
		
		return cbProductName.getSelectedItem().toString();
		
	}
	
	public String getSupplierName() {
		
		return cbSupplier.getSelectedItem().toString();
		
	}
	
	public String getRRP() {
		
		return tfRRP.getText();
		
	}
	
	public String getTotalPrice() {
		
		return tfTotalPrice.getText();
		
	}
	
	public Supplier getSupplier() {
		
		return (Supplier) cbSupplier.getSelectedItem();
		
	}

	
	public ArrayList<Double> getPriceList() {
		
		return priceList;
		
	}
	
	public ArrayList<Double> getPricePerUnitList() {
		
		return pricePerUnitList;
		
	}
	
	public ArrayList<Double> getRrpList() {
		
		return rrpList;
		
	}
}
