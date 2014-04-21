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

@SuppressWarnings("serial")
public class StockGUI extends JPanel {
	private JTable table;

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
		btnRemove.setForeground(Color.RED);
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
		scrollPane.setBounds(10, 57, 640, 407);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		updateStock();
	}
	
	public void updateStock(){
		DefaultTableModel tableModel = 
				new DefaultTableModel(
						new String[] { "Product Name", "Supplier" , "Quantity" , "Price"},
						0);
		
		for (int i = 0; i < StockController.stockList.size(); i++){
			tableModel.addRow(new String[] {StockController.stockList.get(i).getProductName(), 
					StockController.stockList.get(i).getSupplier().getName(),
										"" + StockController.stockList.get(i).getQuantity(),
										"" + StockController.stockList.get(i).getPrice()} );
		}
		
		table.setModel(tableModel);
		
	}
	
}
