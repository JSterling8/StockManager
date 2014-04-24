package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import controllers.ReminderController;
import controllers.StockController;

@SuppressWarnings("serial")
public class RemindersGUI extends JPanel {
	private static JTable table;

	private String name = "Reminders";
	private DefaultTableModel tableModel;
	

	
	/**
	 * Create the panel.
	 */
	public RemindersGUI() {
		setLayout(null);
		setVisible(true);
		this.setBounds(0, 0, 660, 475);
		
		tableModel = 
				new DefaultTableModel( new String[] { "Buy/Sell", 
														"Company Name", 
														"Outstanding amount", 
														"Due Date" }, 
														0);
		
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

		updateReminder();
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public static void updateReminder(){
		DefaultTableModel tableModel = 
				new DefaultTableModel( new String[] { "Reminder", 
						"Company Name", 
						"Outstanding amount", 
						"Due Date" }, 
						0);
		
		for (int i = 0; i < ReminderController.reminderList.size(); i++){
			tableModel.addRow(new String[] {ReminderController.reminderList.get(i).getBuyOrSell(), 
					ReminderController.reminderList.get(i).getCompany().toString(),
										"" + ReminderController.reminderList.get(i).getAmountToPay(),
										"" + ReminderController.reminderList.get(i).getDueDate()} );
		}
		
		table.setModel(tableModel);
		
	}
}