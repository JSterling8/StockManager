package views;
//TODO put in pay and remove buttons.
//TODO fix weird past dates.
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controllers.ReminderController;

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
		scrollPane.setBounds(10, 65, 640, 399);
		add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);

		updateReminder();

		JButton btnPay = new JButton("Pay Supplier");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO placeholder
				if (table.getSelectedRow() != -1){
					if(table.getValueAt(table.getSelectedRow(), 0).equals("You need to pay")){
						PaySupplierGUI ps = new PaySupplierGUI(ReminderController.reminderList.get(table.getSelectedRow()).getId());
					}
				}
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPay.setBounds(10, 11, 225, 35);
		add(btnPay);

		JButton btnCollect = new JButton("Collect Payment");
		btnCollect.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCollect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO placeholder2
				if (table.getSelectedRow() != -1){
					if(table.getValueAt(table.getSelectedRow(), 0).equals("You need to be paid")){
						CollectPaymentGUI cp = new CollectPaymentGUI(ReminderController.reminderList.get(table.getSelectedRow()).getId());
					}
				}
			}
		});
		btnCollect.setBounds(425, 11, 225, 35);
		add(btnCollect);		
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