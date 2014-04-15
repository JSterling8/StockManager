package views;

import java.awt.Color;
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
	
	private ArrayList<JButton> buttons;
	private JButton btnStock;
	private JButton btnSuppliers;
	private JButton btnCustomers;
	private JButton btnTransactions;
	private JButton btnReminders;
	
	private JPanel currentlyActivePanel;
	private JButton currentlyActiveButton;

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
		currentlyActivePanel = stockGUI;
		
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
		
		btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActivePanel = stockGUI;
				currentlyActiveButton = btnStock;
				showSubView();
				highlightButton();
			}
		});
		btnStock.setBounds(5, 11, 130, 34);
		frame.getContentPane().add(btnStock);
		
		btnSuppliers = new JButton("Suppliers");
		btnSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActivePanel = suppliersGUI;
				currentlyActiveButton = btnSuppliers;
				showSubView();
				highlightButton();
			}
		});
		btnSuppliers.setBounds(140, 11, 130, 34);
		frame.getContentPane().add(btnSuppliers);
		
		btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActivePanel = customersGUI;
				currentlyActiveButton = btnCustomers;
				showSubView();
				highlightButton();
			}
		});
		btnCustomers.setBounds(275, 11, 130, 34);
		frame.getContentPane().add(btnCustomers);
		
		btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActivePanel = transactionsGUI;
				currentlyActiveButton = btnTransactions;
				showSubView();
				highlightButton();
			}
		});
		btnTransactions.setBounds(410, 11, 130, 34);
		frame.getContentPane().add(btnTransactions);
		
		btnReminders = new JButton("Reminders");
		btnReminders.setBackground(UIManager.getColor("Button.background"));
		btnReminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentlyActivePanel = remindersGUI;
				currentlyActiveButton = btnReminders;
				showSubView();
				highlightButton();
			}
		});
		btnReminders.setSelected(true);
		btnReminders.setBounds(545, 10, 130, 35);
		frame.getContentPane().add(btnReminders);
		
		buttons = new ArrayList<JButton>();

		buttons.add(btnStock);
		buttons.add(btnSuppliers);
		buttons.add(btnCustomers);
		buttons.add(btnTransactions);
		buttons.add(btnReminders);

	}

	public void showSubView() {
		for (int i = 0; i < subViews.size(); i++){
			if (subViews.get(i) != currentlyActivePanel){
				subViews.get(i).setVisible(false);
			}
			else {
				subViews.get(i).setVisible(true);
			}
		}
	}
	
	public void highlightButton() {
		for (int i = 0; i < buttons.size(); i++){
			if (buttons.get(i) != currentlyActiveButton){
				buttons.get(i).setSelected(false);
			}
			else {
				buttons.get(i).setSelected(true);
			}
		}
	}
}
