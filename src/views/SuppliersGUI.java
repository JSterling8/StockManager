package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.StockController;
import controllers.SupplierController;

public class SuppliersGUI extends JPanel {
	private static JTable table;
	private static DefaultTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public SuppliersGUI() {
		setLayout(null);
		this.setBounds(0, 0, 660, 475);
		setVisible(false);
		
		JButton btnRemove = new JButton("-");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemove.setBounds(540, 11, 50, 35);
		add(btnRemove);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompanyGUI ac = new AddCompanyGUI("Supplier");
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(600, 11, 50, 35);
		add(btnAdd);
		
		tableModel = 
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
	
	public static void updateTable(){
		for (int i = 0; i < SupplierController.supplierList.size(); i++){
			tableModel.addRow(new String[] {SupplierController.supplierList.get(i).getCompanyName(), 
					SupplierController.supplierList.get(i).getPhoneNumber().toString(),
										"" + SupplierController.supplierList.get(i).getEmail(),
										"" + SupplierController.supplierList.get(i).getAddress()} );
		}
		
		table.setModel(tableModel);
	}
}
