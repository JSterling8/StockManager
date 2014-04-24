package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.ReminderController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaySupplierGUI extends JFrame {

	private static final long serialVersionUID = -8768310562519638406L;
	private JPanel contentPane;
	private JTextField tfAmount;
	private JButton btnSubmit;
	private JButton btnCancel;
	private long reminderId;		// The id of the reminder that this popup is referring to.

	/**
	 * Create the frame.
	 */
	public PaySupplierGUI(long reminderId) {
		this.reminderId = reminderId;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 228, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmountToPay = new JLabel("Amount to Pay:");
		lblAmountToPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountToPay.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmountToPay.setBounds(11, 11, 187, 35);
		contentPane.add(lblAmountToPay);
		
		tfAmount = new JTextField();
		tfAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// If the user pressed enter.
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					submit();
				}
			}
		});
		tfAmount.setBounds(11, 57, 187, 35);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(11, 103, 89, 35);
		contentPane.add(btnCancel);
		btnSubmit.setBounds(111, 103, 89, 35);
		contentPane.add(btnSubmit);
		
		setVisible(true);
	}
	
	/**
	 * This is the method called when the user presses enter or clicks submit.
	 */
	public void submit(){
		//TODO make sure they're not paying more than they owe.
		ReminderController.payAmountOutstanding(Double.parseDouble(tfAmount.getText()), reminderId);
		dispose();
	}

}
