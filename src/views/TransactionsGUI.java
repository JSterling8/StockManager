package views;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class TransactionsGUI extends JPanel {

	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public TransactionsGUI() {
		
		this.setBounds(0, 0, 660, 475);
		setLayout(null);
		setVisible(false);
		
		JRadioButton rdbtnBuying = new JRadioButton("Buying");
		rdbtnBuying.setBounds(385, 6, 161, 23);
		add(rdbtnBuying);
		
		JRadioButton rdbtnSelling = new JRadioButton("Selling");
		rdbtnSelling.setBounds(112, 6, 161, 23);
		add(rdbtnSelling);
		
		JButton btnWeekly = new JButton("Weekly");
		btnWeekly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnWeekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWeekly.setBounds(6, 41, 120, 35);
		add(btnWeekly);
		
		JButton btnMonthly = new JButton("Monthly");
		btnMonthly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMonthly.setBounds(182, 41, 120, 35);
		add(btnMonthly);
		
		JButton btnQuarterly = new JButton("Quarterly");
		btnQuarterly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuarterly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuarterly.setBounds(358, 41, 120, 35);
		add(btnQuarterly);
		
		JButton btnAnnually = new JButton("Annually");
		btnAnnually.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnnually.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnually.setBounds(534, 41, 120, 35);
		add(btnAnnually);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[] [] { { "Buy/Sell", "Company", "Amout" , "Invoice" } },
						new String[] { "Column 1", "Column 2" , "Column 3" , "Column 4"});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 640, 376);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setGridColor(Color.black);

	}

}
