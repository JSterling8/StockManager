package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConfirmationGUI extends JFrame {

	private JPanel contentPane;

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
		// TODO Auto-generated constructor stub
		initialize();
	}

	public ConfirmationGUI(AddProductGUI addProductGUI) {
		// TODO Auto-generated constructor stub
		initialize();
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
}


