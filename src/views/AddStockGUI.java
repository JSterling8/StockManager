package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
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
	private JComboBox<String> cbProductName;
	private static JComboBox<Supplier> cbSupplier = new JComboBox<Supplier>();
	private JTextField tfPricePerUnit;
	private JTextField tfRRP;
	private JTextField tfTotalPrice;
	private DefaultTableModel tableModel;
	private double totalPrice;
	private ArrayList<Double> pricePerUnitList;
	private ArrayList<Double> priceList;
	private static ArrayList<Double> rrpList;

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
		setBounds(100, 100, 545, 582);
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
		lblAttachInvoice.setBounds(241, 408, 139, 35);
		contentPane.add(lblAttachInvoice);

		JLabel lblRecommendedRetailPrice = new JLabel("RRP");
		lblRecommendedRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecommendedRetailPrice.setBounds(241, 104, 115, 35);
		contentPane.add(lblRecommendedRetailPrice);

		cbProductName = new JComboBox<String>();
		cbProductName.setModel(new DefaultComboBoxModel(new String[] {}));
		cbProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbProductName.setBounds(197, 12, 250, 35);
		contentPane.add(cbProductName);
		for(int i = 0; i < ProductController.productList.size(); i++) {
			cbProductName.addItem(ProductController.productList.get(i));
		}

		JButton btnAddProduct = new JButton("+");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductGUI apg = new AddProductGUI(AddStockGUI.this);
			}
		});
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
		btnAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompanyGUI ac = new AddCompanyGUI("Supplier");
			}
		});
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
		btnBrowse.setBounds(392, 409, 134, 35);
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
		btnSubmit.setBounds(426, 503, 100, 35);
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(321, 503, 100, 35);
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
		lblTotalPrice.setBounds(280, 456, 100, 35);
		contentPane.add(lblTotalPrice);

		tfTotalPrice = new JTextField();
		tfTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalPrice.setEditable(false);
		tfTotalPrice.setBounds(392, 456, 134, 35);
		contentPane.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		tfTotalPrice.setEditable(false);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDueDate.setBounds(6, 348, 100, 35);
		contentPane.add(lblDueDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(168, 351, 63, 35);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(306, 351, 87, 35);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(455, 348, 63, 35);
		contentPane.add(comboBox_2);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay.setBounds(112, 348, 50, 35);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(237, 348, 63, 35);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(399, 348, 50, 35);
		contentPane.add(lblYear);

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

	public static ArrayList<Double> getRrpList() {
		return rrpList;
	}

	public void updateProductList() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (int i = 0; i < ProductController.productList.size(); i++){
			model.addElement(ProductController.productList.get(i));
		}
		
		cbProductName.setModel(model);
	}
	
	public static void updateSupplierList() {
		DefaultComboBoxModel<Supplier> model = new DefaultComboBoxModel<Supplier>();
		for (int i = 0; i < SupplierController.supplierList.size(); i++){
			model.addElement(SupplierController.supplierList.get(i));
		}
		
		cbSupplier.setModel(model);
	}
}
