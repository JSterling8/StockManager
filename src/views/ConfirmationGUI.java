package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ConfirmationGUI extends JFrame {

	private JPanel contentPane;
	private AddCompanyGUI addCompanyGUI;
	private AddProductGUI addProductGUI;
	private RemoveStockGUI removeStockGUI;
	private SellStockGUI sellStockGUI;
	private AddStockGUI addStockGUI;


	public ConfirmationGUI(AddStockGUI addStockGUI) {

		this.addStockGUI = addStockGUI;

		setTitle("Confirmation");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 515, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 164, 35);
		contentPane.add(lblProductName);

		JLabel lblProductNameResult = new JLabel(addStockGUI.getProductName());
		lblProductNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductNameResult.setBounds(186, 11, 266, 35);
		contentPane.add(lblProductNameResult);

		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSupplier.setBounds(10, 58, 164, 35);
		contentPane.add(lblSupplier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 490, 187);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(addStockGUI.getTable());

		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalPrice.setBounds(10, 355, 193, 35);
		contentPane.add(lblTotalPrice);

		JLabel lblTotalPricePlusVat = new JLabel("Total Price plus VAT:");
		lblTotalPricePlusVat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalPricePlusVat.setBounds(10, 402, 193, 35);
		contentPane.add(lblTotalPricePlusVat);

		JLabel lblSupplierNameResult = new JLabel(addStockGUI.getSupplierName());
		lblSupplierNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSupplierNameResult.setBounds(186, 58, 266, 35);
		contentPane.add(lblSupplierNameResult);

		JLabel lblTotalPriceResult = new JLabel(addStockGUI.getTotalPrice());
		lblTotalPriceResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalPriceResult.setBounds(215, 355, 266, 35);
		contentPane.add(lblTotalPriceResult);

		JLabel lblTotalPricePlusVatResult = new JLabel(addStockGUI.getTotalPricePlusVat());
		lblTotalPricePlusVatResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalPricePlusVatResult.setBounds(215, 402, 266, 35);
		contentPane.add(lblTotalPricePlusVatResult);

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				getAddStockGUI().setVisible(true);

			}
		});
		btnNewButton.setBounds(106, 449, 100, 35);
		contentPane.add(btnNewButton);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				getAddStockGUI().dispose();

			}
		});
		btnConfirm.setBounds(312, 449, 100, 35);
		contentPane.add(btnConfirm);

	}

	public ConfirmationGUI(SellStockGUI sellStockGUI) {

		this.sellStockGUI = sellStockGUI;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 749, 328);
		setTitle("Confirmation");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblPleaseConfirmThat = new JLabel("Sell " + sellStockGUI.getCompanyName() + " the following:");
		lblPleaseConfirmThat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseConfirmThat.setBounds(10, 11, 364, 35);
		contentPane.add(lblPleaseConfirmThat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 695, 169);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(sellStockGUI.getTable());


		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSellStockGUI().setVisible(true);
				dispose();
			}
		});
		btnEdit.setBounds(177, 239, 100, 35);
		contentPane.add(btnEdit);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Save info to database.
				getSellStockGUI().dispose();
				dispose();
			}
		});
		btnOk.setBounds(454, 239, 100, 35);
		contentPane.add(btnOk);
	}

	public ConfirmationGUI(AddCompanyGUI addCompanyGUI) {
		this.addCompanyGUI = addCompanyGUI;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 361, 319);
		setTitle("Confirmation");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblPleaseConfirmThat = new JLabel("Confirm the following " + addCompanyGUI.getCompanyType() + " details: ");
		lblPleaseConfirmThat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseConfirmThat.setBounds(10, 11, 364, 35);
		contentPane.add(lblPleaseConfirmThat);

		JLabel lName = new JLabel("Name");
		lName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lName.setBounds(20, 57, 98, 35);
		contentPane.add(lName);

		JLabel lEmail = new JLabel("Email");
		lEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lEmail.setBounds(20, 99, 98, 35);
		contentPane.add(lEmail);

		JLabel lPhone = new JLabel("Phone");
		lPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lPhone.setBounds(20, 146, 98, 35);
		contentPane.add(lPhone);

		JLabel lAddress = new JLabel("Address");
		lAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lAddress.setBounds(20, 193, 98, 35);
		contentPane.add(lAddress);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAddCompanyGUI().setVisible(true);
				dispose();
			}
		});
		btnEdit.setBounds(61, 239, 100, 35);
		contentPane.add(btnEdit);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Save info to database.
				getAddCompanyGUI().dispose();
				dispose();
			}
		});
		btnOk.setBounds(222, 239, 100, 35);
		contentPane.add(btnOk);

		JLabel lblName = new JLabel(addCompanyGUI.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(128, 60, 200, 35);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel(addCompanyGUI.getEmail());
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(128, 102, 200, 35);
		contentPane.add(lblEmail);

		JLabel lblPhone = new JLabel(addCompanyGUI.getPhone());
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(128, 146, 200, 35);
		contentPane.add(lblPhone);

		JLabel lblAddress = new JLabel(addCompanyGUI.getAddress());
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(128, 193, 200, 35);
		contentPane.add(lblAddress);
	}

	public ConfirmationGUI(AddProductGUI addProductGUI) {
		this.addProductGUI = addProductGUI;

		setTitle("Confiration");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 375, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 152, 35);
		contentPane.add(lblProductName);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				getAddProductGUI().dispose();

			}
		});
		btnConfirm.setBounds(58, 58, 100, 35);
		contentPane.add(btnConfirm);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				getAddProductGUI().setVisible(true);

			}
		});
		btnEdit.setBounds(216, 58, 100, 35);
		contentPane.add(btnEdit);

		JLabel lblProductNameResult = new JLabel(addProductGUI.getName());
		lblProductNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductNameResult.setBounds(174, 11, 181, 35);
		contentPane.add(lblProductNameResult);

	}

	public ConfirmationGUI(RemoveStockGUI removeStockGUI) {
		this.removeStockGUI = removeStockGUI;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 361, 319);
		setTitle("Confirmation");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblPleaseConfirmThat = new JLabel("Confirm removal of the following: ");
		lblPleaseConfirmThat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseConfirmThat.setBounds(10, 11, 364, 35);
		contentPane.add(lblPleaseConfirmThat);

		JLabel lProduct = new JLabel("Product");
		lProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lProduct.setBounds(20, 57, 98, 35);
		contentPane.add(lProduct);

		JLabel lUnits = new JLabel("Units");
		lUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lUnits.setBounds(20, 99, 98, 35);
		contentPane.add(lUnits);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRemoveStockGUI().setVisible(true);
				dispose();
			}
		});
		btnEdit.setBounds(61, 239, 100, 35);
		contentPane.add(btnEdit);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Save info to database.
				getRemoveStockGUI().dispose();
				dispose();
			}
		});
		btnOk.setBounds(222, 239, 100, 35);
		contentPane.add(btnOk);

		JLabel lblProduct = new JLabel(removeStockGUI.getProductName());
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProduct.setBounds(128, 60, 200, 35);
		contentPane.add(lblProduct);

		JLabel lblUnits = new JLabel(removeStockGUI.getUnits());
		lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnits.setBounds(128, 102, 200, 35);
		contentPane.add(lblUnits);

		JLabel lReason = new JLabel("Reason");
		lReason.setFont(new Font("Tahoma", Font.BOLD, 18));
		lReason.setBounds(20, 145, 98, 35);
		contentPane.add(lReason);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 148, 194, 80);
		contentPane.add(scrollPane);

		JTextArea tpReason = new JTextArea();
		tpReason.setLineWrap(true);
		tpReason.setText(removeStockGUI.getReason());
		scrollPane.setViewportView(tpReason);
		tpReason.setEditable(false);
	}

	private AddCompanyGUI getAddCompanyGUI(){
		return addCompanyGUI;
	}

	private AddProductGUI getAddProductGUI() {
		return addProductGUI;
	}

	public RemoveStockGUI getRemoveStockGUI(){
		return removeStockGUI;
	}

	public SellStockGUI getSellStockGUI(){
		return sellStockGUI;
	}

	/**
	 * @return the addStockGUI
	 */
	public AddStockGUI getAddStockGUI() {
		return addStockGUI;
	}
}


