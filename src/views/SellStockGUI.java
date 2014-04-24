/**
 * 
 * @author Jonathan Sterling
 */

package views;



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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Company;
import models.Customer;
import controllers.CustomerController;
import controllers.StockController;

public class SellStockGUI extends JFrame {

	private JComboBox cbDay;
	private JComboBox cbMonth;
	private JComboBox cbYear;
	private static final long serialVersionUID = -1802942040864294457L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfUnits;
	private JTextField tfPricePerUnit;
	private JTextField tfTotalAmount;
	private JTextField tfProfitLoss;
	private static JComboBox<Company> cbCompanyName;
	private JComboBox<String> cbProduct;
	private DefaultTableModel tableModel;
	private double totalAmount;
	private double profit;
	private Customer customer;
	private ArrayList<Double> pricePerUnitList;
	private ArrayList<Double> priceList;
	private JTextField tfQuantityLeft;
	private ArrayList<Double> quantityLeftList;
	private ArrayList<Long> idList; // List of ids of stocks being sold.

	/*
	 *  This justPressed variable is used to solve an issue where
	 *  if the user presses enter whilst in a text field, a popup
	 *  appears if the amount of units entered is more than the
	 *  amount of units in stock, and then if they push enter
	 *  again to get rid of the popup they can just press enter
	 *  indefinitely because it pops up again and again.
	 */
	private boolean justPressed;


	/**
	 * Create the frame.
	 */
	public SellStockGUI() {		
		totalAmount = 0;
		profit = 0;
		justPressed = false;

		pricePerUnitList = new ArrayList<Double>();
		priceList = new ArrayList<Double>();
		quantityLeftList = new ArrayList<Double>();
		idList = new ArrayList<Long>();
		
		// Puts all of the quantities of products into an ArrayList.
		for (int a = 0; a < StockController.stockList.size(); a++){
			quantityLeftList.add(StockController.stockList.get(a).getQuantity());
		}

		setTitle("Sell Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbCompanyName = new JComboBox<Company>();
		for(int i = 0; i < CustomerController.customerList.size(); i++){
			cbCompanyName.addItem(CustomerController.customerList.get(i));
		}
		cbCompanyName.setBounds(200, 14, 150, 35);
		contentPane.add(cbCompanyName);

		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompanyName.setBounds(10, 11, 178, 35);
		contentPane.add(lblCompanyName);

		JButton btnAddCompany = new JButton("+");
		btnAddCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompanyGUI ac = new AddCompanyGUI("Customer");
			}
		});
		btnAddCompany.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddCompany.setBounds(362, 14, 50, 35);
		contentPane.add(btnAddCompany);

		JLabel lblProduct = new JLabel("Product Name");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProduct.setBounds(10, 106, 178, 35);
		contentPane.add(lblProduct);

		//TODO Format text output to 4/5 decimals.
		tfQuantityLeft = new JTextField();
		tfQuantityLeft.setEditable(false);
		tfQuantityLeft.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfQuantityLeft.setColumns(10);
		tfQuantityLeft.setBounds(192, 147, 111, 35);
		contentPane.add(tfQuantityLeft);
		setResizable(false);

		tfPricePerUnit = new JTextField();
		tfPricePerUnit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean isValid = true;

				// If the user pressed enter.
				if (e.getKeyCode()==KeyEvent.VK_ENTER){

					// If there's no popup that they're pressing enter to get rid of.
					if (!justPressed){
						// Tests/checks that they're only entering numbers.
						try{
							@SuppressWarnings("unused")
							double test = Double.parseDouble(tfPricePerUnit.getText());
							test = Double.parseDouble(tfUnits.getText());
						}
						catch(NumberFormatException error){
							JOptionPane.showMessageDialog(new JFrame(), "You can only enter valid numbers.");
							isValid = false;
							justPressed = true;
						}
						
						// If the input doesn't throw an error.
						if (isValid){
							// If the input isn't empty.
							if ( !tfPricePerUnit.getText().equals("") && !tfUnits.getText().equals("")){
								// If they're not entering more product than they have.
								if (!(Double.parseDouble(tfUnits.getText()) > quantityLeftList.get(cbProduct.getSelectedIndex()))){
									insert();
								}
							}

							// Else if they're entering too much product so enter is disabled, let them know:
							else if ( !justPressed && 
									tfUnits.getText() != null &&
									!tfUnits.getText().equals("") && 
									Double.parseDouble(tfUnits.getText()) > quantityLeftList.get(cbProduct.getSelectedIndex())){
								JOptionPane.showMessageDialog(new JFrame(), "You don't have that much of this product available.");
								justPressed = true;
							}
							// Else if they've just pressed the enter key to create the popup, 
							// set justPressed to false so enter works the next time they press the key.
							else if(justPressed){
								justPressed = false;
							}
						}
					}
					// Otherwise set justPressed to false to indicate there's no longer a popup.
					else {
						justPressed = false;
					}
				}
			}
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b') && (character != '.')) {
					e.consume();
				}
			}
		});
		
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setBounds(459, 147, 134, 35);
		contentPane.add(tfPricePerUnit);
		tfPricePerUnit.setColumns(10);

		cbProduct = new JComboBox<String>();
		cbProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Shows the amount of that stock available.
				tfQuantityLeft.setText("" + quantityLeftList.get(cbProduct.getSelectedIndex()));

				// Shows the recommended price.
				tfPricePerUnit.setText("" + StockController.stockList.get(cbProduct.getSelectedIndex()).getRRP());
			}
		});
		cbProduct.setBounds(10, 147, 172, 35);
		for(int i = 0; i < StockController.stockList.size(); i++){
			cbProduct.addItem(StockController.stockList.get(i).getProductName());
		}
		contentPane.add(cbProduct);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 695, 198);
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

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(313, 106, 91, 35);
		contentPane.add(lblUnits);

		JLabel lblPrice = new JLabel("Price/Unit");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice.setBounds(459, 106, 134, 35);
		contentPane.add(lblPrice);

		// TODO format output to 4 or 5 decimal points.
		tfUnits = new JTextField();
		tfUnits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean isValid = true;

				// If the user pressed enter.
				if (e.getKeyCode()==KeyEvent.VK_ENTER){

					// If there's no popup that they're pressing enter to remove.
					if (!justPressed){
						// Tests/checks that they're only entering numbers.
						try{
							@SuppressWarnings("unused")
							double test = Double.parseDouble(tfPricePerUnit.getText());
							test = Double.parseDouble(tfUnits.getText());
						}
						catch(NumberFormatException error){
							JOptionPane.showMessageDialog(new JFrame(), "You can only enter valid numbers.");
							isValid = false;
							justPressed = true;
						}


						// If the input doesn't throw an error.
						if (isValid){
							// If the input isn't empty.
							if ( !tfPricePerUnit.getText().equals("") && !tfUnits.getText().equals("")){
								// If they're not entering more product than they have.
								if (!(Double.parseDouble(tfUnits.getText()) > quantityLeftList.get(cbProduct.getSelectedIndex()))){
									insert();
								}
							}

							// Else if they're entering too much product so enter is disabled, let them know:
							else if ( !justPressed && 
									tfUnits.getText() != null &&
									!tfUnits.getText().equals("") && 
									Double.parseDouble(tfUnits.getText()) > quantityLeftList.get(cbProduct.getSelectedIndex())){
								JOptionPane.showMessageDialog(new JFrame(), "You don't have that much of this product available.");
								justPressed = true;
							}
							// Else if they've just pressed the enter key to create the popup, 
							// set justPressed to false so enter works the next time they press the key.
							else if(justPressed){
								justPressed = false;
							}
						}
					}
					// Otherwise set justPressed to false to indicate there's no longer a popup.
					else {
						justPressed = false;
					}
				}
			}
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (((character < '0') || (character > '9'))
						&& (character != '\b') && (character != '.')) {
					e.consume();
				}
			}
		});

		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(313, 147, 134, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(605, 147, 100, 35);
		contentPane.add(btnInsert);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 713, 12);
		contentPane.add(separator);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalAmount.setBounds(313, 527, 223, 35);
		contentPane.add(lblTotalAmount);

		JLabel lblProfitloss = new JLabel("Profit/Loss");
		lblProfitloss.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfitloss.setBounds(313, 573, 223, 35);
		contentPane.add(lblProfitloss);

		tfTotalAmount = new JTextField();
		tfTotalAmount.setEditable(false);
		tfTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalAmount.setBounds(548, 527, 157, 35);
		contentPane.add(tfTotalAmount);
		tfTotalAmount.setColumns(10);

		tfProfitLoss = new JTextField();
		tfProfitLoss.setEditable(false);
		tfProfitLoss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProfitLoss.setBounds(548, 573, 157, 35);
		contentPane.add(tfProfitLoss);
		tfProfitLoss.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancel.setBounds(605, 619, 100, 35);
		contentPane.add(btnCancel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() == 0){
					JOptionPane.showMessageDialog(new JFrame(), "Please insert at least one product to sell.");
				}

				else {		
					@SuppressWarnings("unused")
					ConfirmationGUI conf = new ConfirmationGUI(SellStockGUI.this);
					setVisible(false);
				}
			}
		});
		btnSubmit.setBounds(493, 619, 100, 35);
		contentPane.add(btnSubmit);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(313, 481, 177, 35);
		contentPane.add(lblAttachInvoice);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(548, 481, 157, 35);
		contentPane.add(btnBrowse);

		JLabel lblQuantityOwned = new JLabel("Available");
		lblQuantityOwned.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantityOwned.setBounds(192, 106, 111, 35);
		contentPane.add(lblQuantityOwned);
		
		JLabel label = new JLabel("Due Date");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(185, 431, 100, 35);
		contentPane.add(label);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay.setBounds(291, 431, 50, 35);
		contentPane.add(lblDay);
		
		cbDay = new JComboBox();
		cbDay.setBounds(337, 434, 73, 35);
		cbDay.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
		contentPane.add(cbDay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(416, 431, 63, 35);
		contentPane.add(lblMonth);
		
		cbMonth = new JComboBox();
		cbMonth.setBounds(475, 434, 73, 35);
		cbMonth.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12}));
		contentPane.add(cbMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(554, 431, 50, 35);
		contentPane.add(lblYear);
		
		cbYear = new JComboBox();
		cbYear.setBounds(616, 431, 89, 35);
		cbYear.setModel(new DefaultComboBoxModel(new Integer[] {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026,2027, 2028, 2029, 2030}));
		contentPane.add(cbYear);

		setVisible(true);
	}

	public boolean validateInput(){
		boolean isValid = true;

		if (cbCompanyName.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a product name.");
			isValid = false;
		}
		else if (cbProduct.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a supplier name.");
			isValid = false;
		}
		else if(tfUnits.getText() != null && tfUnits.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a number of units.");
			isValid = false;
		}
		else if (Double.parseDouble(tfUnits.getText()) <= 0 ){
			JOptionPane.showMessageDialog(new JFrame(), "Number of units must be greater than 0.");
			isValid = false;
		}
		else if(tfPricePerUnit.getText() != null && tfPricePerUnit.getText().equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a price per unit.");
			isValid = false;
		}
		else if (Double.parseDouble(tfPricePerUnit.getText()) <= 0 ){
			JOptionPane.showMessageDialog(new JFrame(), "Price per unit must be greater than 0.");
			isValid = false;
		}
		else if (Double.parseDouble(tfQuantityLeft.getText()) < Double.parseDouble(tfUnits.getText())){
			JOptionPane.showMessageDialog(new JFrame(), "You don't have that much of this product available.");
			isValid = false;
		}


		return isValid;
	}

	public void insert(){
		double price = 0;
		if (validateInput()){
			customer = CustomerController.customerList.get(cbCompanyName.getSelectedIndex());

			price = Double.parseDouble(tfUnits.getText()) * Double.parseDouble(tfPricePerUnit.getText());
			pricePerUnitList.add(Double.parseDouble(tfPricePerUnit.getText()));
			priceList.add(price);
			idList.add(StockController.stockList.get(cbProduct.getSelectedIndex()).getId());
			tableModel.addRow(new String[]{
					(String) cbProduct.getSelectedItem(),
					tfUnits.getText(),
					NumberFormat.getCurrencyInstance().format(Double.parseDouble(tfPricePerUnit.getText())),
					NumberFormat.getCurrencyInstance().format(price)});
			totalAmount += price;
			tfTotalAmount.setText(NumberFormat.getCurrencyInstance().format(totalAmount));

			// profit = (sellingPrice * numOfUnits) - (purchasePrice * numOfUnits)
			profit -= StockController.stockList.get(cbProduct.getSelectedIndex()).getPrice() * Double.parseDouble(tfUnits.getText());
			profit += price;
			tfProfitLoss.setText(NumberFormat.getCurrencyInstance().format(profit));

			// Subtract the amount they wish to remove from the quantity left.
			// Update the quantity left ArrayList
			// Update tfQuantityLeft
			double quantity = quantityLeftList.get(cbProduct.getSelectedIndex()) - Double.parseDouble(tfUnits.getText());
			quantityLeftList.set(cbProduct.getSelectedIndex(), quantity);
			tfQuantityLeft.setText("" + quantity);
		}
	}

	public String getCompanyName(){
		return cbCompanyName.getSelectedItem().toString();
	}

	public JTable getTable(){
		return table;
	}

	public double getProfitLoss() {
		return profit;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ArrayList<Double> getPricePerUnitList() {
		return pricePerUnitList;
	}

	public ArrayList<Double> getPriceList() {
		return priceList;
	}

	public JComboBox<String> getCbProduct() {
		return cbProduct;
	}

	public static void updateCompanyList() {
		DefaultComboBoxModel<Company> model = new DefaultComboBoxModel<Company>();
		for (int i = 0; i < CustomerController.customerList.size(); i++){
			model.addElement(CustomerController.customerList.get(i));
		}
		
		cbCompanyName.setModel(model);
	}

	public ArrayList<Long> getIdList() {
		return idList;
	}
	
	public int getDay() {	
		return cbDay.getSelectedIndex();
	}
	
	public int getMonth() {
		return cbMonth.getSelectedIndex();
	}
	
	public int getYear() {
		return cbYear.getSelectedIndex();
	}
}
