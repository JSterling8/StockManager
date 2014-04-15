package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainGUI extends javax.swing.JFrame {
	private JFrame frame;
	private ArrayList<JPanel> subViews;

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
					window.frame.setSize(700, 575);
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
		frame.setSize(700, 575);
		frame.setVisible(true);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSubView("Stock");
			}
		});
		btnStock.setBounds(5, 11, 130, 34);
		frame.getContentPane().add(btnStock);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.setBounds(140, 11, 130, 34);
		frame.getContentPane().add(btnSuppliers);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(275, 11, 130, 34);
		frame.getContentPane().add(btnCustomers);
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.setBounds(410, 11, 130, 34);
		frame.getContentPane().add(btnTransactions);
		
		JButton btnReminders = new JButton("Reminders");
		btnReminders.setBounds(545, 10, 130, 35);
		frame.getContentPane().add(btnReminders);
		
		subViews = new ArrayList<JPanel>();
		
		subViews.add(new StockGUI());
		subViews.add(new SuppliersGUI());
		subViews.add(new CustomersGUI());
		subViews.add(new TransactionsGUI());
		subViews.add(new RemindersGUI());
	}

	protected void showSubView(String string) {
		
	}
}
