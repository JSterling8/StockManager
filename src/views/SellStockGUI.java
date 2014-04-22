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

import models.Customer;
import controllers.CustomerController;
import controllers.StockController;

public class SellStockGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfUnits;
	private JTextField tfPricePerUnit;
	private JTextField tfTotalAmount;
	private JTextField tfProfitLoss;
	private JComboBox cbCompanyName;
	private JComboBox cbProduct;
	private DefaultTableModel tableModel;
	private double totalAmount;
	private double profit;
	private Customer customer;
	private ArrayList<Double> pricePerUnitList;
	private ArrayList<Double> priceList;
	private JTextField tfQuantityLeft;
	private ArrayList<Double> quantityLeftList;


	/**
	 * Create the frame.
	 */
	public SellStockGUI() {		
		totalAmount = 0;
		profit = 0;

		pricePerUnitList = new ArrayList<Double>();
		priceList = new ArrayList<Double>();
		quantityLeftList = new ArrayList<Double>();
		
		// Puts all of the quantities of products into an ArrayList.
		for (int a = 0; a < StockController.stockList.size(); a++){
			quantityLeftList.add(StockController.stockList.get(a).getQuantity());
		}
		
		setTitle("Sell Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbCompanyName = new JComboBox();
		for(int i = 0; i < CustomerController.customerList.size(); i++){
			cbCompanyName.addItem(CustomerController.customerList.get(i));
		}
		cbCompanyName.setBounds(200, 14, 150, 35);
		contentPane.add(cbCompanyName);

		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompanyName.setBounds(10, 11, 178, 35);
		contentPane.add(lblCompanyName);

		JButton button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(362, 12, 50, 35);
		contentPane.add(button);

		JLabel lblProduct = new JLabel("Product Name");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProduct.setBounds(10, 106, 178, 35);
		contentPane.add(lblProduct);

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
				if (e.getKeyCode()==KeyEvent.VK_ENTER && 
						!tfPricePerUnit.getText().equals("") &&
						!tfUnits.getText().equals("")){
					insert();
			    }
			}
		});
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setBounds(459, 147, 134, 35);
		contentPane.add(tfPricePerUnit);
		tfPricePerUnit.setColumns(10);
		
		cbProduct = new JComboBox();
		cbProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Shows the amount of that stock available.
				tfQuantityLeft.setText("" + quantityLeftList.get(cbProduct.getSelectedIndex()));
				
				// Shows the recommended price.
				tfPricePerUnit.setText("" + StockController.stockList.get(cbProduct.getSelectedIndex()).getPrice());
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

		tfUnits = new JTextField();
		tfUnits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER && 
					!tfPricePerUnit.getText().equals("") &&
					!tfUnits.getText().equals("")){
					insert();
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
		lblTotalAmount.setBounds(313, 455, 223, 35);
		contentPane.add(lblTotalAmount);

		JLabel lblProfitloss = new JLabel("Profit/Loss");
		lblProfitloss.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfitloss.setBounds(313, 501, 223, 35);
		contentPane.add(lblProfitloss);

		tfTotalAmount = new JTextField();
		tfTotalAmount.setEditable(false);
		tfTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalAmount.setBounds(548, 455, 157, 35);
		contentPane.add(tfTotalAmount);
		tfTotalAmount.setColumns(10);

		tfProfitLoss = new JTextField();
		tfProfitLoss.setEditable(false);
		tfProfitLoss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProfitLoss.setBounds(548, 501, 157, 35);
		contentPane.add(tfProfitLoss);
		tfProfitLoss.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancel.setBounds(605, 547, 100, 35);
		contentPane.add(btnCancel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() == 0){
					JOptionPane.showMessageDialog(new JFrame(), "Please insert at least one product to sell.");
				}

				else {		
					ConfirmationGUI conf = new ConfirmationGUI(SellStockGUI.this);
					setVisible(false);
				}
			}
		});
		btnSubmit.setBounds(493, 547, 100, 35);
		contentPane.add(btnSubmit);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(313, 409, 177, 35);
		contentPane.add(lblAttachInvoice);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(548, 409, 157, 35);
		contentPane.add(btnBrowse);
		
		JLabel lblQuantityOwned = new JLabel("Available");
		lblQuantityOwned.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantityOwned.setBounds(192, 106, 111, 35);
		contentPane.add(lblQuantityOwned);

		setVisible(true);
	}

	public boolean validateInput(){
		boolean isValid = true;

		//TODO Add check to see if they can remove that much product.
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


		return isValid;
	}
	
	public void insert(){
		double price = 0;
		if (validateInput()){
			customer = (Customer) cbCompanyName.getSelectedItem();
			
			price = Double.parseDouble(tfUnits.getText()) * Double.parseDouble(tfPricePerUnit.getText());
			pricePerUnitList.add(Double.parseDouble(tfPricePerUnit.getText()));
			priceList.add(price);
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
			
			//TODO remove from local qty arraylist.
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
}
