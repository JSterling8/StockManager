package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.UnitController;

public class AddUnitsGUI extends JFrame {

	private static final long serialVersionUID = -1489798724987880161L;
	private JPanel contentPane;
	private JTextField tfUnits;
	private AddProductGUI addProductGUI;


	/**
	 * Create the frame.
	 */
	public AddUnitsGUI(final AddProductGUI addProductGUI) {
		this.addProductGUI = addProductGUI;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnits = new JLabel("Unit Type:");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(10, 11, 116, 35);
		contentPane.add(lblUnits);
		
		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUnits.setColumns(10);
		tfUnits.setBounds(136, 11, 288, 35);
		contentPane.add(tfUnits);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(106, 57, 100, 35);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO check that input isn't blank.
				UnitController.addUnit(tfUnits.getText());
				addProductGUI.updateUnits();
				dispose();
			}
		});
		btnSubmit.setBounds(246, 57, 100, 35);
		contentPane.add(btnSubmit);
		
		setVisible(true);
	}

}
