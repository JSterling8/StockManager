package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class RemindersGUI extends JPanel {
	private JTable table;

	private String name = "Reminders";
	

	
	/**
	 * Create the panel.
	 */
	public RemindersGUI() {
		setLayout(null);
		setVisible(true);
		this.setBounds(0, 0, 660, 475);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "Incoming/Outcoming", "Company", "Amout" , "Due Date" , "Invoice" }, { "Three", "Four" } },
						new String[] { "Column 1", "Column 2" , "Column 3" , "Column 4", "Column 5"});
		
		table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(10, 11, 640, 453);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		add(table);

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}