package views;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import controllers.TransactionController;

public class TransactionsGUI extends JPanel {

	private static JTable table;
	private DefaultTableModel tableModel;
	private JRadioButton rdbtnBuying;
	private JRadioButton rdbtnSelling;
	
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
		rdbtnSelling.setSelected(false);
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
		scrollPane.setBounds(10, 88, 640, 376);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		
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
