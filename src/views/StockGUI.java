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

import models.Stock;
import models.Supplier;

@SuppressWarnings("serial")
public class StockGUI extends JPanel {
	private JTable table;
	private ArrayList<Stock> stock;

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
		
		JButton btnRemoveStock = new JButton("-");
		btnRemoveStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Get the string to pass from what's selected in the JTable.
				RemoveStockGUI rs = new RemoveStockGUI("Product A");
			}
		});
		btnRemoveStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemoveStock.setBounds(540, 11, 50, 35);
		add(btnRemoveStock);
		
		JButton btnAddStock = new JButton("+");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockGUI as = new AddStockGUI();
			}
		});
		btnAddStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddStock.setBounds(600, 11, 50, 35);
		add(btnAddStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 640, 407);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		updateStock();
	}
	
	public void updateStock(){
		stock = new ArrayList<Stock>();
		stock.add(new Stock("prod1", new Supplier("Supp1"), 1.1, 2.2));
		stock.add(new Stock("prod2", new Supplier("Supp2"), 1.1, 2.2));
		stock.add(new Stock("prod3", new Supplier("Supp3"), 1.1, 2.2));
		stock.add(new Stock("prod4", new Supplier("Supp4"), 1.1, 2.2));

		
		DefaultTableModel tableModel = 
				new DefaultTableModel(
						new String[] { "Product Name", "Supplier" , "Quantity" , "Price"},
						0);
		
		for (int i = 0; i < stock.size(); i++){
			tableModel.addRow(new String[] {stock.get(i).getProductName(), 
										stock.get(i).getSupplier().getName(),
										"" + stock.get(i).getQuantity(),
										"" + stock.get(i).getPrice()} );
		}
		
		table.setModel(tableModel);
		
	}
	
}
