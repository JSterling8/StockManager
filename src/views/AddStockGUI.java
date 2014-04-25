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

	
	private JComboBox cbDay;
	private JComboBox cbMonth;
	private JComboBox cbYear;
	private JPanel contentPane;
	private JTextField tfQuantity;
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
	private JTextField tfUnits;

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
		setBounds(100, 100, 545, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 57, 177, 35);
		contentPane.add(lblProductName);

		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSupplier.setBounds(10, 11, 177, 35);
		contentPane.add(lblSupplier);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(10, 104, 100, 35);
		contentPane.add(lblQuantity);

		JLabel lblPricePerUnit = new JLabel("Price/Unit");
		lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPricePerUnit.setBounds(218, 104, 100, 35);
		contentPane.add(lblPricePerUnit);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(197, 351, 139, 35);
		contentPane.add(lblAttachInvoice);

		JLabel lblRecommendedRetailPrice = new JLabel("RRP");
		lblRecommendedRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecommendedRetailPrice.setBounds(328, 104, 73, 35);
		contentPane.add(lblRecommendedRetailPrice);

		cbProductName = new JComboBox<String>();
		cbProductName.setModel(new DefaultComboBoxModel(new String[] {}));
		cbProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbProductName.setBounds(197, 58, 250, 35);
		contentPane.add(cbProductName);
		for(int i = 0; i < ProductController.productList.size(); i++) {
			cbProductName.addItem(ProductController.productList.get(i).getName());
		}

		JButton btnAddProduct = new JButton("+");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductGUI apg = new AddProductGUI(AddStockGUI.this);
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddProduct.setBounds(476, 57, 50, 35);
		contentPane.add(btnAddProduct);

		cbSupplier = new JComboBox<Supplier>();
		cbSupplier.setModel(new DefaultComboBoxModel(new String[] {}));
		cbSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbSupplier.setBounds(197, 12, 250, 35);
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
		btnAddSupplier.setBounds(476, 11, 50, 35);
		contentPane.add(btnAddSupplier);

		tfQuantity = new JTextField();
		tfQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfQuantity.setBounds(10, 149, 100, 35);
		contentPane.add(tfQuantity);
		tfQuantity.setColumns(10);
		tfQuantity.addKeyListener(new KeyAdapter() {
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
		tfPricePerUnit.setBounds(218, 150, 100, 35);
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
		btnBrowse.setBounds(392, 351, 134, 35);
		contentPane.add(btnBrowse);

		tfRRP = new JTextField();
		tfRRP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfRRP.setColumns(10);
		tfRRP.setBounds(328, 150, 73, 35);
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
		btnSubmit.setBounds(426, 446, 100, 35);
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(316, 446, 100, 35);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 516, 99);
		contentPane.add(scrollPane);

		tableModel = 
				new DefaultTableModel( new String[] { "Product Name", 
						"Quantity", 
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
					double price = Double.parseDouble(tfQuantity.getText()) * Double.parseDouble(tfPricePerUnit.getText());

					rrpList.add(Double.parseDouble(tfRRP.getText()));
					priceList.add(price);
					pricePerUnitList.add(Double.parseDouble(tfPricePerUnit.getText()));

					tableModel.addRow(new String[]{
							(String) cbProductName.getSelectedItem(),
							tfQuantity.getText(),
							tfUnits.getText(),
							NumberFormat.getCurrencyInstance().format(Double.parseDouble(tfPricePerUnit.getText())),
							NumberFormat.getCurrencyInstance().format(price)});

					totalPrice = totalPrice + (Double.parseDouble(tfQuantity.getText()) * Double.parseDouble(tfPricePerUnit.getText()));
					tfTotalPrice.setText("" + totalPrice);
					
					// Disable the supplier combobox because you only buy from one supplier at a time.
					cbSupplier.setEnabled(false);

				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(411, 150, 115, 35);
		contentPane.add(btnInsert);

		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalPrice.setBounds(197, 397, 100, 35);
		contentPane.add(lblTotalPrice);

		tfTotalPrice = new JTextField();
		tfTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalPrice.setEditable(false);
		tfTotalPrice.setBounds(392, 397, 134, 35);
		contentPane.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		tfTotalPrice.setEditable(false);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDueDate.setBounds(10, 305, 100, 35);
		contentPane.add(lblDueDate);
		
		cbDay = new JComboBox();
		cbDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDay.setBounds(84, 351, 73, 35);
		cbDay.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
		contentPane.add(cbDay);
		
		cbMonth = new JComboBox();
		cbMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbMonth.setBounds(84, 397, 73, 35);
		cbMonth.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12}));
		contentPane.add(cbMonth);
		
		cbYear = new JComboBox();
		cbYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbYear.setBounds(61, 443, 96, 35);
		cbYear.setModel(new DefaultComboBoxModel(new Integer[] {2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026,2027, 2028, 2029, 2030}));
		contentPane.add(cbYear);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay.setBounds(10, 351, 63, 35);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(10, 397, 63, 35);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(10, 443, 63, 35);
		contentPane.add(lblYear);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(128, 104, 73, 35);
		contentPane.add(lblUnits);
		
		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setColumns(10);
		tfUnits.setBounds(128, 149, 73, 35);
		contentPane.add(tfUnits);

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
		else if(tfQuantity.getText() != null && tfQuantity.getText().equals("")){
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
			model.addElement(ProductController.productList.get(i).getName());
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

	public int getDay() {	
		return (int) cbDay.getSelectedItem();
	}
	
	public int getMonth() {
		return (int) cbMonth.getSelectedItem();
	}
	
	public int getYear() {
		return (int) cbYear.getSelectedItem();
	}
	
}
