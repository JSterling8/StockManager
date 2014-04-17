package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		btnAddStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddStock.setBounds(600, 11, 50, 35);
		add(btnAddStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 640, 407);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
