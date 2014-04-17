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

public class CustomersGUI extends JPanel {

	private String name = "Customers";
	
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CustomersGUI() {
		setVisible(false);
		
		setLayout(null);
		this.setBounds(0, 0, 660, 475);
		setVisible(false);
		
		JButton button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(540, 11, 50, 35);
		add(button);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompanyGUI ac = new AddCompanyGUI("Customer");
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBounds(600, 11, 50, 35);
		add(button_1);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "Customer Name", "Phone Number" , "Email Address" }},
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

	public String getName() {
		return name;
	}

}
