package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.StockController;
import models.Stock;
import models.Supplier;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StockGUI extends JPanel {
	private static JTable table;
	private JTextField tfTotalStockValue;

	/**
	 * Create the panel.
	 */
	public StockGUI() {
		setLayout(null);
		this.setBounds(0, 0, 660, 475);
		setVisible(false);
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellStockGUI ss = new SellStockGUI();
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSell.setBounds(10, 11, 70, 35);
		add(btnSell);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.BLACK);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Get the string to pass from what's selected in the JTable.
				RemoveStockGUI rs = new RemoveStockGUI("Product A");
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemove.setBounds(525, 11, 125, 35);
		add(btnRemove);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockGUI as = new AddStockGUI();
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuy.setBounds(90, 11, 70, 35);
		add(btnBuy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 640, 350);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tfTotalStockValue = new JTextField();
		tfTotalStockValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTotalStockValue.setEditable(false);
		tfTotalStockValue.setColumns(10);
		tfTotalStockValue.setBounds(493, 429, 157, 35);
		add(tfTotalStockValue);
		
		JLabel lblStockValue = new JLabel("Total Stock Value:");
		lblStockValue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStockValue.setBounds(293, 429, 223, 35);
		add(lblStockValue);
		
		updateStock();
	}
	
	public static void updateStock(){
		DefaultTableModel tableModel = 
				new DefaultTableModel(
						new String[] { "Product Name", "Supplier" , "Quantity" , "Units", "Price Per Unit", "Price"},
						0);
		
		for (int i = 0; i < StockController.stockList.size(); i++){
			tableModel.addRow(new String[] {StockController.stockList.get(i).getProduct().getName(), 
					StockController.stockList.get(i).getSupplier().toString(),
										"" + StockController.stockList.get(i).getQuantity(),
										"" + StockController.stockList.get(i).getProduct().getUnitType(),
										"" + StockController.stockList.get(i).getPricePerUnit(),
										StockController.stockList.get(i).getPricePerUnit() * StockController.stockList.get(i).getQuantity() + ""} );
		}
		
		table.setModel(tableModel);
		
	}
	
}
