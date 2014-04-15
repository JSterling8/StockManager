package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class AddStockGUI extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField tfUnits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStockGUI frame = new AddStockGUI();
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
	public AddStockGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Stock");
		setBounds(100, 100, 545, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 277, 35);
		contentPane.add(lblProductName);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSupplier.setBounds(10, 57, 277, 35);
		contentPane.add(lblSupplier);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(10, 103, 277, 35);
		contentPane.add(lblUnits);
		
		JLabel lblPricePerUnit = new JLabel("Price Per Unit");
		lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPricePerUnit.setBounds(10, 149, 277, 35);
		contentPane.add(lblPricePerUnit);
		
		JLabel lblVat = new JLabel("VAT %");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVat.setBounds(10, 195, 277, 35);
		contentPane.add(lblVat);
		
		JLabel lblAttachInvoice = new JLabel("Attach Invoice");
		lblAttachInvoice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAttachInvoice.setBounds(10, 241, 277, 35);
		contentPane.add(lblAttachInvoice);
		
		JLabel lblRecommendedRetailPrice = new JLabel("Recommended");
		lblRecommendedRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecommendedRetailPrice.setBounds(10, 287, 277, 35);
		contentPane.add(lblRecommendedRetailPrice);
		
		JLabel lblRetailPrice = new JLabel("Retail Price:");
		lblRetailPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRetailPrice.setBounds(10, 310, 277, 35);
		contentPane.add(lblRetailPrice);
		
		JComboBox cbProductName = new JComboBox();
		cbProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbProductName.setBounds(297, 12, 150, 35);
		contentPane.add(cbProductName);
		
		JButton btnAddProduct = new JButton("+");
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddProduct.setBounds(476, 11, 50, 35);
		contentPane.add(btnAddProduct);
		
		JComboBox cbSupplier = new JComboBox();
		cbSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbSupplier.setBounds(297, 58, 150, 35);
		contentPane.add(cbSupplier);
		
		JButton btnAddSupplier = new JButton("+");
		btnAddSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSupplier.setBounds(476, 57, 50, 35);
		contentPane.add(btnAddSupplier);
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false); //this is the key!!
		numberFormatter.setMinimum(0l); //Optional
		
		// TODO fix this because it doesn't let you delete all of the digits you enter.
		tfUnits = new JFormattedTextField(numberFormatter);
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setBounds(297, 106, 229, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);
		
		JFormattedTextField tfPricePerUnit = new JFormattedTextField(numberFormatter);
		tfPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPricePerUnit.setColumns(10);
		tfPricePerUnit.setBounds(297, 149, 229, 35);
		contentPane.add(tfPricePerUnit);
		
		JFormattedTextField tfVAT = new JFormattedTextField(numberFormatter);
		tfVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfVAT.setColumns(10);
		tfVAT.setBounds(297, 195, 229, 35);
		contentPane.add(tfVAT);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBrowse.setBounds(297, 244, 229, 35);
		contentPane.add(btnBrowse);
		
		JFormattedTextField tfRRP = new JFormattedTextField(numberFormatter);
		tfRRP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfRRP.setColumns(10);
		tfRRP.setBounds(297, 297, 229, 35);
		contentPane.add(tfRRP);
		
		//TODO add action listener
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(426, 343, 100, 35);
		contentPane.add(btnSubmit);
		
		//TODO add action listener
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(297, 343, 100, 35);
		contentPane.add(btnCancel);
	}
}
