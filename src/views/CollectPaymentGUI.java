package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.ReminderController;

public class CollectPaymentGUI extends JFrame {

	private static final long serialVersionUID = -1189443536999357395L;
	private JPanel contentPane;
	private JTextField tfAmount;
	private long reminderId;				// The id of the reminder that this popup is referring to.


	/**
	 * Create the frame.
	 */
	public CollectPaymentGUI(long reminderId) {
		this.reminderId = reminderId;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 228, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmountPaid = new JLabel("Amount Paid");
		lblAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountPaid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmountPaid.setBounds(10, 11, 187, 35);
		contentPane.add(lblAmountPaid);
		
		tfAmount = new JTextField();
		tfAmount.setColumns(10);
		tfAmount.setBounds(10, 57, 187, 35);
		tfAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// If the user pressed enter.
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					submit();
				}
			}
		});
		contentPane.add(tfAmount);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 103, 89, 35);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		btnSubmit.setBounds(110, 103, 89, 35);
		contentPane.add(btnSubmit);
		
		setVisible(true);
	}

	/**
	 * This is the method called when the user presses enter or clicks submit.
	 */
	public void submit(){
		//TODO make sure they're not paying more than they owe.
		ReminderController.collectAmountOwed(Double.parseDouble(tfAmount.getText()), reminderId);
		dispose();
	}
}
