package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.CustomerController;

public class CustomersGUI extends JPanel {

	private String name = "Customers";
	
	private static JTable table;
	private static DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public CustomersGUI() {
		setVisible(false);
		
		setLayout(null);
		this.setBounds(0, 0, 660, 475);
		setVisible(false);
		
		JButton btnRemoveCustomer = new JButton("-");
		btnRemoveCustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemoveCustomer.setBounds(540, 11, 50, 35);
		add(btnRemoveCustomer);
		
		JButton btwAddCustomer = new JButton("+");
		btwAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompanyGUI ac = new AddCompanyGUI("Customer");
			}
		});
		btwAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btwAddCustomer.setBounds(600, 11, 50, 35);
		add(btwAddCustomer);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[] { "Name", "Phone" , "Email" , "Address"},
						0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 640, 407);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		
		updateTable();
	}

	public String getName() {
		return name;
	}
	
	public static void updateTable() {
		tableModel = 
				new DefaultTableModel(
						new String[] { "Name", "Phone" , "Email" , "Address"},
						0);
		for (int i = 0; i < CustomerController.customerList.size(); i++){
			tableModel.addRow(new String[] {CustomerController.customerList.get(i).getCompanyName(), 
					CustomerController.customerList.get(i).getPhoneNumber().toString(),
										CustomerController.customerList.get(i).getEmail(),
										CustomerController.customerList.get(i).getAddress()} );
		}
		
		table.setModel(tableModel);
	}
	
	public void removeCustomer(int[] indicesToRemove){		
		Arrays.sort(indicesToRemove);
	    for (int i = indicesToRemove.length - 1; i >= 0; i--) {
	        tableModel.removeRow(indicesToRemove[i]);
	        tableModel.fireTableRowsDeleted(indicesToRemove[i], indicesToRemove[i]);
			CustomerController.customerList.remove(i);
	    }
	}

}
