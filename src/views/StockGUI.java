package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.Stock;
import models.Supplier;

@SuppressWarnings("serial")
public class StockGUI extends JPanel {
	private JTable table;
	private ArrayList<Stock> stock;
	private DefaultTableModel tableModel;

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
				SellStockGUI ss = new SellStockGUI(StockGUI.this);
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSell.setBounds(105, 11, 85, 35);
		add(btnSell);
		
		JButton btnRemoveStock = new JButton("Remove");
		btnRemoveStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Get the string to pass from what's selected in the JTable.
				RemoveStockGUI rs = new RemoveStockGUI("Product A");
			}
		});
		btnRemoveStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemoveStock.setBounds(498, 11, 152, 35);
		add(btnRemoveStock);
		
		JButton btnBuyStock = new JButton("Buy");
		btnBuyStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockGUI as = new AddStockGUI(StockGUI.this);
			}
		});
		btnBuyStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuyStock.setBounds(10, 11, 85, 35);
		add(btnBuyStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 640, 407);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		loadStock();
	}
	
	public void loadStock(){
		stock = new ArrayList<Stock>();
		//TODO the id for the supplier is set to -5,-2.  Should be positive in actual implementation.
		stock.add(new Stock("prod1", new Supplier("Supp1", -2), 1.1, 2.2, 4));
		stock.add(new Stock("prod2", new Supplier("Supp2", -3), 1.1, 2.2, 5));
		stock.add(new Stock("prod3", new Supplier("Supp3", -4), 1.1, 2.2, 6));
		stock.add(new Stock("prod4", new Supplier("Supp4", -5), 1.1, 2.2, 7));

		
		tableModel = 
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
	
	public void addStock(Stock stockToAdd){
		stock.add(stockToAdd);
		tableModel.addRow(new String[] {stockToAdd.getProductName(),
							stockToAdd.getSupplier().getName(),
							"" + stockToAdd.getQuantity(),
							"" + stockToAdd.getPrice()} );
	}
	
	public JTable getTable(){
		return table;
	}
	
	public ArrayList<Stock> getStock(){
		return stock;
	}
		
}
