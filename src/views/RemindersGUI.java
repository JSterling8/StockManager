package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 640, 453);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}