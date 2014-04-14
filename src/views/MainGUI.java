package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import views.RemindersGUI;;

@SuppressWarnings("serial")
public class MainGUI extends javax.swing.JFrame {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setSize(700, 200);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(10, 11, 67, 21);
		frame.getContentPane().add(btnStock);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.setBounds(84, 11, 75, 21);
		frame.getContentPane().add(btnSuppliers);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(159, 11, 100, 21);
		frame.getContentPane().add(btnCustomers);
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.setBounds(266, 11, 124, 21);
		frame.getContentPane().add(btnTransactions);
		
		JButton btnProfitlossOverview = new JButton("Profit/Loss Overview");
		btnProfitlossOverview.setBounds(398, 11, 173, 21);
		frame.getContentPane().add(btnProfitlossOverview);
		
		JButton btnReminders = new JButton("Reminders");
		btnReminders.setBounds(581, 10, 89, 23);
		frame.getContentPane().add(btnReminders);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 38, 665, 225);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		RemindersGUI remindersGUI = new RemindersGUI();
		remindersGUI.setBounds(1, 227, 664, -229);
		panel.add(remindersGUI);

		
	
	}
}
