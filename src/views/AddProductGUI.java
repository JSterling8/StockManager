package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.UnitController;

public class AddProductGUI extends JFrame {


	private static final long serialVersionUID = 7369638800895464113L;
	private JPanel contentPane;
	private JTextField tfProductName;
	private JButton btnSubmit;
	private JButton btnCancel;
	private JComboBox<String> cbUnits;

	private AddStockGUI addStockGUI;
	private JLabel lblUnits;


	/**
	 * Create the frame.
	 */
	public AddProductGUI(AddStockGUI addStockGUI) {
		setVisible(true);
		this.addStockGUI = addStockGUI;

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Product");
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 11, 150, 35);
		contentPane.add(lblProductName);

		tfProductName = new JTextField();
		tfProductName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// If the user pressed enter.
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					openConfirmation();
				}
			}
		});
		tfProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfProductName.setBounds(169, 11, 255, 35);
		contentPane.add(tfProductName);
		tfProductName.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openConfirmation();
			}
		});
		btnSubmit.setBounds(250, 126, 100, 35);
		contentPane.add(btnSubmit);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(110, 126, 100, 35);
		contentPane.add(btnCancel);
		
		lblUnits = new JLabel("Units:");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(10, 57, 150, 35);
		contentPane.add(lblUnits);
		
		cbUnits = new JComboBox<String>();
		cbUnits.setBounds(169, 67, 195, 35);
		contentPane.add(cbUnits);
		updateUnits();
		
		JButton btnAddUnits = new JButton("+");
		btnAddUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUnitsGUI au = new AddUnitsGUI(AddProductGUI.this);
			}
		});
		btnAddUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddUnits.setBounds(374, 66, 50, 35);
		contentPane.add(btnAddUnits);
	}

	private void openConfirmation(){
		//TODO should check that it contains at least one letter or number.
		if (!tfProductName.getText().equals("") && !tfProductName.getText().equals("  ")){
			@SuppressWarnings("unused")
			ConfirmationGUI cg = new ConfirmationGUI(AddProductGUI.this);
			setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "You must enter a product name.");
		}
	}

	/**
	 * Return product name
	 */
	public String getName() {
		return tfProductName.getText();
	}
	
	public String getUnits() {
		return (String) cbUnits.getSelectedItem();
	}

	public AddStockGUI getAddStockGUI(){
		return addStockGUI;
	}
	
	public void updateUnits(){
		cbUnits.removeAllItems();
		for (int i = 0; i < UnitController.unitList.size(); i++){
			cbUnits.addItem(UnitController.unitList.get(i));
		}
	}
}
