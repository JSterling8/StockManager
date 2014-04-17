package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellStockGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfUnits;
	private JTextField tfPricePerUnit;
	private JTextField tfVat;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellStockGUI frame = new SellStockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SellStockGUI() {
		
		setTitle("Sell Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 14, 150, 35);
		contentPane.add(comboBox);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompanyName.setBounds(10, 11, 178, 35);
		contentPane.add(lblCompanyName);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(362, 12, 50, 35);
		contentPane.add(button);
		
		JLabel lblProcuct = new JLabel("Product Name");
		lblProcuct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProcuct.setBounds(10, 106, 150, 35);
		contentPane.add(lblProcuct);
		
		JComboBox cbProduct = new JComboBox();
		cbProduct.setBounds(10, 153, 150, 35);
		contentPane.add(cbProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 695, 169);
		contentPane.add(scrollPane);
		
		TableModel tableModel = 
				new DefaultTableModel(
						new String[][] { { "Title", "Units" , "Price per Unit", "VAT %" }},
						new String[] { "Column 1", "Column 2", "Column3", "Column 4" });
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(167, 105, 91, 35);
		contentPane.add(lblUnits);
		
		JLabel lblPrice = new JLabel("Price/Unit");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice.setBounds(313, 105, 134, 35);
		contentPane.add(lblPrice);
		
		JLabel lblVat = new JLabel("VAT %");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVat.setBounds(459, 105, 92, 35);
		contentPane.add(lblVat);
		
		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(167, 150, 134, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);
		
		tfPricePerUnit = new JTextField();
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setBounds(459, 150, 134, 35);
		contentPane.add(tfPricePerUnit);
		tfPricePerUnit.setColumns(10);
		
		tfVat = new JTextField();
		tfVat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVat.setBounds(313, 150, 134, 35);
		contentPane.add(tfVat);
		tfVat.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(605, 151, 100, 35);
		contentPane.add(btnInsert);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 713, 12);
		contentPane.add(separator);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalAmount.setBounds(313, 381, 223, 35);
		contentPane.add(lblTotalAmount);
		
		JLabel lblTotalAmountPlus = new JLabel("Total Amount plus VAT");
		lblTotalAmountPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalAmountPlus.setBounds(313, 424, 223, 35);
		contentPane.add(lblTotalAmountPlus);
		
		JLabel lblProfitloss = new JLabel("Profit/Loss");
		lblProfitloss.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfitloss.setBounds(313, 471, 223, 35);
		contentPane.add(lblProfitloss);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(548, 386, 157, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(548, 429, 157, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(548, 476, 157, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancel.setBounds(605, 523, 100, 35);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSubmit.setBounds(493, 523, 100, 35);
		contentPane.add(btnSubmit);
		setResizable(false);

	}
}
