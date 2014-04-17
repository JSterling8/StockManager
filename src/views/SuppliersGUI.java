package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuppliersGUI extends JPanel {
	private JTable table;

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
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "Supplier Name", "Phone Number" , "Email Address" }},
						new String[] { "Column 1", "Column 2", "Column3" });
		
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
	}
}
