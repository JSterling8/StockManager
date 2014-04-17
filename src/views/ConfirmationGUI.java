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
import javax.swing.border.EmptyBorder;

public class ConfirmationGUI extends JFrame {

	private JPanel contentPane;
	private AddCompanyGUI addCompanyGUI;
	private AddProductGUI addProductGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmationGUI frame = new ConfirmationGUI();
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
	public ConfirmationGUI() {
		initialize();
	}

	public ConfirmationGUI(AddStockGUI addStockGUI) {
		// TODO Auto-generated constructor stub
		initialize();
	}

	public ConfirmationGUI(SellStockGUI sellStockGUI) {
		// TODO Auto-generated constructor stub
		initialize();
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
		// TODO Auto-generated constructor stub
		
		this.addProductGUI = addProductGUI;
		
		setTitle("Confiration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setVisible(true);
	}
	
	private AddCompanyGUI getAddCompanyGUI(){
		return addCompanyGUI;
	}
	
	private AddProductGUI getAddProductGUI() {
		
		return addProductGUI;
		
	}
}


