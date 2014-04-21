package views;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.TableModel;

public class SellStockGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfUnits;
	private JTextField tfPricePerUnit;
	private JTextField tfTotalAmount;
	private JTextField tfProfitLoss;
	private JComboBox cbCompanyName;
	private JComboBox cbProduct;
	private StockGUI stockGUI;
	private DefaultTableModel tableModel;


	/**
	 * Create the frame.
	 */
	public SellStockGUI(StockGUI stockGUI) {
		this.stockGUI =  stockGUI;
		setTitle("Sell Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbCompanyName = new JComboBox();
		cbCompanyName.setModel(new DefaultComboBoxModel(new String[] {"ACME Corp."}));
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

		JLabel lblProcuct = new JLabel("Product Name");
		lblProcuct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProcuct.setBounds(10, 106, 297, 35);
		contentPane.add(lblProcuct);

		cbProduct = new JComboBox();
		cbProduct.setBounds(10, 150, 297, 35);
		// TODO get from database instead of table.
		for (int i = 0; i < stockGUI.getTable().getModel().getRowCount(); i++){
			cbProduct.addItem(stockGUI.getTable().getModel().getValueAt(i, 0));
		}
		cbProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = cbProduct.getSelectedIndex();
				tfPricePerUnit.setText("" + getStockGUI().getStock().get(selectedIndex).getRrp());
			}
		});
		contentPane.add(cbProduct);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 695, 169);
		contentPane.add(scrollPane);

		tableModel = 
				new DefaultTableModel(
						new String[] { "Product Name", "Supplier" , "Quantity" , "Price/Unit", "Total Price"},
						0);

		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(317, 106, 91, 35);
		contentPane.add(lblUnits);

		JLabel lblPrice = new JLabel("Price/Unit");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice.setBounds(461, 106, 134, 35);
		contentPane.add(lblPrice);

		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(317, 147, 134, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);

		tfPricePerUnit = new JTextField();
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setBounds(461, 147, 134, 35);
		contentPane.add(tfPricePerUnit);
		tfPricePerUnit.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(605, 146, 100, 35);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateInput()){
					// TODO placeholder.
					addToTable();
					// calculatePrice();
				}
			}
		});
		contentPane.add(btnInsert);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 713, 12);
		contentPane.add(separator);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalAmount.setBounds(313, 433, 223, 35);
		contentPane.add(lblTotalAmount);

		JLabel lblProfitloss = new JLabel("Profit/Loss");
		lblProfitloss.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfitloss.setBounds(317, 479, 223, 35);
		contentPane.add(lblProfitloss);

		tfTotalAmount = new JTextField();
		tfTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalAmount.setBounds(548, 433, 157, 35);
		contentPane.add(tfTotalAmount);
		tfTotalAmount.setColumns(10);

		tfProfitLoss = new JTextField();
		tfProfitLoss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProfitLoss.setBounds(548, 479, 157, 35);
		contentPane.add(tfProfitLoss);
		tfProfitLoss.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancel.setBounds(605, 525, 100, 35);
		contentPane.add(btnCancel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConfirmationGUI conf = new ConfirmationGUI(SellStockGUI.this);
				setVisible(false);				
			}
		});
		btnSubmit.setBounds(494, 525, 100, 35);
		contentPane.add(btnSubmit);

		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(313, 386, 177, 35);
		contentPane.add(lblAttachInvoice);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(548, 386, 157, 35);
		contentPane.add(btnBrowse);
		setResizable(false);

		if (cbProduct.getItemCount() > 0){
			tfPricePerUnit.setText("" + getStockGUI().getStock().get(0).getRrp());
		}

		setVisible(true);
	}

	public boolean validateInput(){
		boolean isValid = true;

		if (cbProduct.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a product name.");
			isValid = false;
		}
		else if (cbCompanyName.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(new JFrame(), "Please select a company name.");
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

		return isValid;
	}

	public void addToTable(){
		double totalPrice = Double.parseDouble(tfUnits.getText()) * Double.parseDouble(tfPricePerUnit.getText());
		tableModel.addRow(new String [] {(String) cbProduct.getSelectedItem(),
				(String)cbCompanyName.getSelectedItem(),
				tfUnits.getText(),
				tfPricePerUnit.getText(),
				"" + totalPrice
		});
	}

	public String getCompanyName(){
		return cbCompanyName.getSelectedItem().toString();
	}

	public JTable getTable(){
		return table;
	}

	public StockGUI getStockGUI() {
		return stockGUI;
	}

}
