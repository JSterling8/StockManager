package views;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import controllers.ReminderController;
import controllers.StockController;
import controllers.SupplierController;
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

				updateBuyTransactions();
			
			}
		});
		rdbtnBuying.setBounds(385, 6, 161, 23);
		add(rdbtnBuying);
		
		rdbtnSelling = new JRadioButton("Selling");
		rdbtnSelling.setSelected(true);
		rdbtnSelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateSellTransactions();
				
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
				
				double profitLoss = 0;
				
				Date date = new Date(System.currentTimeMillis());
				int year = date.getYear();
				
				DefaultTableModel tableModel = 
						new DefaultTableModel( new String[] { "Buy/Sell", 
								"Company Name", 
								"Cost/Profit"}, 
								0);
				
				// Update sell transaction list
				
				for (int i = 0; i < TransactionController.sellTransactionList.size(); i++){
					
					// Check if the transaction's year and month match
					
					if(TransactionController.sellTransactionList.get(i).getDate().getYear() == year) {
					
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		
		JButton btnDeleteTransaction = new JButton("Delete Transaction");
		btnDeleteTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnSelling.isSelected() == true) {
					
					removeSellTransaction(table.getSelectedRow());
					
				}
				
				if(rdbtnBuying.isSelected() == true) {
					
					removeBuyTransaction(table.getSelectedRow());
				 
				}
			}
		});
		btnDeleteTransaction.setBounds(497, 5, 157, 29);
		add(btnDeleteTransaction);
		
	}
	
	public static void updateTransaction(){
		DefaultTableModel tableModel = 
				new DefaultTableModel( new String[] { "Buy/Sell", 
						"Company Name", 
						"Cost/Profit"}, 
						0);
		
		// Update buy transaction list
		
		for (int i = 0; i < TransactionController.transactionList.size(); i++){
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
	
	/**
	 * 
	 * @param index To remove the transaction
	 * Remove the transaction by index and Reminder, Stock objects related to it
	 */
	
	public void removeBuyTransaction(int index){		
		
		long transactionId = TransactionController.buyTransactionList.get(index).getId();
		ArrayList<Long> stockIds = TransactionController.buyTransactionList.get(index).getIdForStockList();
		long reminderId = TransactionController.buyTransactionList.get(index).getReminderId();
		
		// Delete transaction object
		for(int i = 0; i < TransactionController.buyTransactionList.size(); i++) {
			
			if(TransactionController.buyTransactionList.get(i).getId() == transactionId) {
				TransactionController.buyTransactionList.remove(i);
			}
		}
		
		// Delete stock object
		StockController.removeById(stockIds);
		
		// Delete reminder object
		for(int j = 0; j < ReminderController.reminderList.size(); j++) {
			if(ReminderController.reminderList.get(j).getId() == reminderId) {
				ReminderController.reminderList.remove(j);
			}	
		}
		
		// Update displays
		
		TransactionsGUI.updateTransaction();
		RemindersGUI.updateReminder();
		StockGUI.updateStock();
		updateBuyTransactions();
		
	}
	
	public void removeSellTransaction(int index){		

		
	}
	
	/**
	 * Read buyTransaction ArrayList and update the table 
	 */
	
	public void updateSellTransactions() {
		
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
		
		rdbtnBuying.setSelected(false);
		
	}
	
	/**
	 * Read buyTransaction ArrayList and update the table 
	 */
	
	public void updateBuyTransactions() {
		
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
		
		rdbtnSelling.setSelected(false);
		
	}
}
