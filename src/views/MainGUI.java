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
	private StockGUI stockGUI;
	private SuppliersGUI suppliersGUI;
	private CustomersGUI customersGUI;
	private TransactionsGUI transactionsGUI;
	private RemindersGUI remindersGUI;
	
	private JPanel currentlyActive;

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
		
		
		stockGUI = new StockGUI();
		stockGUI.setBounds(12, 48, 660, 475);
		frame.getContentPane().add(stockGUI);
		currentlyActive = stockGUI;
		
		suppliersGUI = new SuppliersGUI();
		suppliersGUI.setBounds(12, 48, 660, 475);
		frame.getContentPane().add(suppliersGUI);

		customersGUI = new CustomersGUI();
		customersGUI.setBounds(12, 48, 660, 475);
		frame.getContentPane().add(customersGUI);

		transactionsGUI = new TransactionsGUI();
		transactionsGUI.setBounds(12, 48, 660, 475);
		frame.getContentPane().add(transactionsGUI);

		remindersGUI = new RemindersGUI();
		remindersGUI.setBounds(12, 48, 660, 475);
		frame.getContentPane().add(remindersGUI);

		subViews = new ArrayList<JPanel>();
		
		subViews.add(stockGUI);
		subViews.add(suppliersGUI);
		subViews.add(customersGUI);
		subViews.add(transactionsGUI);
		subViews.add(remindersGUI);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActive = stockGUI;
				showSubView();
			}
		});
		btnStock.setBounds(5, 11, 130, 34);
		frame.getContentPane().add(btnStock);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActive = suppliersGUI;
				showSubView();
			}
		});
		btnSuppliers.setBounds(140, 11, 130, 34);
		frame.getContentPane().add(btnSuppliers);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActive = customersGUI;
				showSubView();
			}
		});
		btnCustomers.setBounds(275, 11, 130, 34);
		frame.getContentPane().add(btnCustomers);
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActive = transactionsGUI;
				showSubView();
			}
		});
		btnTransactions.setBounds(410, 11, 130, 34);
		frame.getContentPane().add(btnTransactions);
		
		JButton btnReminders = new JButton("Reminders");
		btnReminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActive = remindersGUI;
				showSubView();
			}
		});
		btnReminders.setBounds(545, 10, 130, 35);
		frame.getContentPane().add(btnReminders);
		
	}

	public void showSubView() {
		for (int i = 0; i < subViews.size(); i++){
			if (subViews.get(i) != currentlyActive){
				subViews.get(i).setVisible(false);
			}
			else {
				subViews.get(i).setVisible(true);
			}
			
		}
	}
}
