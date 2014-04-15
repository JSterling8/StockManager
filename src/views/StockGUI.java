package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
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
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSell.setBounds(10, 11, 70, 35);
		add(btnSell);
		
		JButton button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(540, 11, 50, 35);
		add(button);
		
		JButton button_1 = new JButton("+");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBounds(600, 11, 50, 35);
		add(button_1);
		
		table = new JTable();
		table.setBounds(10, 57, 640, 407);
		add(table);
	}
}
