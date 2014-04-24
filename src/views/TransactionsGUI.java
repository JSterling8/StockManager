package views;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import controllers.TransactionController;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransactionsGUI extends JPanel {

	private static JTable table;
	private DefaultTableModel tableModel;
	private JRadioButton rdbtnBuying;
	private JRadioButton rdbtnSelling;
	private JTextField tfProfitLoss;
	
	/**
	 * Create the panel.
	 */
	public TransactionsGUI() {
		
		this.setBounds(0, 0, 660, 475);
		setLayout(null);
		setVisible(false);
		
		rdbtnBuying = new JRadioButton("Buying");
		rdbtnBuying.setSelected(false);
		rdbtnBuying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a new table model
				
				DefaultTableModel tableModel = 
						new DefaultTableModel( new String[] { "Buy/Sell", 
								"Company Name", 
								"Cost/Profit"}, 
								0);
				
				// Update buy transaction list
				
				for (int i = 0; i < TransactionController.buyTransactionList.size(); i++){
					tableModel.addRow(new String[] {"Buy" , 
							TransactionController.buyTransactionList.get(i).getSupplier().toString(),
												"" + TransactionController.buyTransactionList.get(i).getTotalPrice(),
												} );
				}
				
				table.setModel(tableModel);
				
				System.out.println("Buy");
				rdbtnSelling.setSelected(false);
				
			}
		});
		rdbtnBuying.setBounds(385, 6, 161, 23);
		add(rdbtnBuying);
		
		rdbtnSelling = new JRadioButton("Selling");
		rdbtnSelling.setSelected(true);
		rdbtnSelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a new table model
				
				DefaultTableModel tableModel = 
						new DefaultTableModel( new String[] { "Buy/Sell", 
								"Company Name", 
								"Cost/Profit"}, 
								0);
				
				// Update sell transaction list
				
				for (int i = 0; i < TransactionController.sellTransactionList.size(); i++){
					tableModel.addRow(new String[] {"Sell" , 
							TransactionController.sellTransactionList.get(i).getCustomer().toString(),
												"" + TransactionController.sellTransactionList.get(i).getProfit(),
												} );
				}
				
				table.setModel(tableModel);
				
				System.out.println("Sell");
				rdbtnBuying.setSelected(false);
				
			}
		});
		rdbtnSelling.setBounds(112, 6, 161, 23);
		add(rdbtnSelling);
		
		JButton btnWeekly = new JButton("Weekly");
		btnWeekly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnWeekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnWeekly.setBounds(6, 41, 120, 35);
		add(btnWeekly);
		
		JButton btnMonthly = new JButton("Monthly");
		btnMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double profitLoss = 0;
				
				Date date = new Date(System.currentTimeMillis());
				int year = date.getYear();
				int month = date.getMonth();
				
				DefaultTableModel tableModel = 
						new DefaultTableModel( new String[] { "Buy/Sell", 
								"Company Name", 
								"Cost/Profit"}, 
								0);
				
				// Update sell transaction list
				
				for (int i = 0; i < TransactionController.sellTransactionList.size(); i++){
					
					// Check if the transaction's year and month match
					
					if(TransactionController.sellTransactionList.get(i).getDate().getYear() == year
							&& TransactionController.sellTransactionList.get(i).getDate().getMonth() == month) {
					
					profitLoss = profitLoss + TransactionController.sellTransactionList.get(i).getProfit();
						
					tableModel.addRow(new String[] {"Sell" , 
							TransactionController.sellTransactionList.get(i).getCustomer().toString(),
												"" + TransactionController.sellTransactionList.get(i).getProfit(),
												} );
					} else {
						
						// Do not add it
						
					}
				
				}
				
				table.setModel(tableModel);
				tfProfitLoss.setText(Double.toString(profitLoss));
				
			}
		});
		btnMonthly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMonthly.setBounds(182, 41, 120, 35);
		add(btnMonthly);
		
		JButton btnQuarterly = new JButton("Quarterly");
		btnQuarterly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnQuarterly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuarterly.setBounds(358, 41, 120, 35);
		add(btnQuarterly);
		
		JButton btnAnnually = new JButton("Annually");
		btnAnnually.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnnually.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnAnnually.setBounds(534, 41, 120, 35);
		add(btnAnnually);
		
		tableModel = 
				new DefaultTableModel( new String[] { "Buy/Sell", 
						"Company Name", 
						"Cost/Profit"}, 
						0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 640, 324);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		
		JLabel lblProfitLoss = new JLabel("Profit/Loss");
		lblProfitLoss.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfitLoss.setBounds(297, 430, 223, 35);
		add(lblProfitLoss);
		
		tfProfitLoss = new JTextField();
		tfProfitLoss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProfitLoss.setEditable(false);
		tfProfitLoss.setColumns(10);
		tfProfitLoss.setBounds(497, 430, 157, 35);
		add(tfProfitLoss);
		
	}
	
	public static void updateTransaction(){
		DefaultTableModel tableModel = 
				new DefaultTableModel( new String[] { "Buy/Sell", 
						"Company Name", 
						"Cost/Profit"}, 
						0);
		
		// Update buy transaction list
		
		for (int i = 0; i < TransactionController.buyTransactionList.size(); i++){
			tableModel.addRow(new String[] {"Buy" , 
					TransactionController.buyTransactionList.get(i).getSupplier().toString(),
										"" + TransactionController.buyTransactionList.get(i).getTotalPrice(),
										} );
		}
		
		// Update sell transaction list
		
		for (int i = 0; i < TransactionController.sellTransactionList.size(); i++){
			tableModel.addRow(new String[] {"Sell" , 
					TransactionController.sellTransactionList.get(i).getCustomer().toString(),
										"" + TransactionController.sellTransactionList.get(i).getProfit(),
										} );
		}
		
		// Update removal transaction list
		
		// TODO the update bit for removal transactions
		
		table.setModel(tableModel);
		
	}
}
