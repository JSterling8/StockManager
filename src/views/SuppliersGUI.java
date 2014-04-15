package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SuppliersGUI extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SuppliersGUI() {
		setLayout(null);
		this.setBounds(0, 0, 660, 475);
		setVisible(false);
		
		JButton button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(540, 11, 50, 35);
		add(button);
		
		JButton button_1 = new JButton("+");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBounds(600, 11, 50, 35);
		add(button_1);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "Supplier Name", "Date Added" }, { "Three", "Four" } },
						new String[] { "Column 1", "Column 2"});
		
		table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(10, 57, 640, 407);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		add(table);
	}
}
