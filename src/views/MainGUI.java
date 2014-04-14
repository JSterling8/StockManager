package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainGUI extends javax.swing.JFrame {
	private RemindersGUI remindersGUI;
	private StockGUI stockGUI;
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
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockGUI.setVisible(true);
				remindersGUI.setVisible(false);
			}
		});
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
		btnReminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remindersGUI.setVisible(true);
				stockGUI.setVisible(false);
			}
		});
		btnReminders.setBounds(581, 10, 89, 23);
		frame.getContentPane().add(btnReminders);
		
		remindersGUI = new RemindersGUI();
		remindersGUI.setBounds(10, 32, 665, 231);
		frame.getContentPane().add(remindersGUI);
		
		stockGUI = new StockGUI();
		stockGUI.setBounds(10, 32, 665, 231);
		frame.getContentPane().add(stockGUI);
		
		

		
	
	}
}
