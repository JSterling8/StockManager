package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class RemoveStockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfUnits;
	private JTextField tfReason;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveStockGUI frame = new RemoveStockGUI();
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
	public RemoveStockGUI() {
		
		setTitle("Remove Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnits.setBounds(26, 34, 100, 35);
		contentPane.add(lblUnits);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReason.setBounds(26, 81, 100, 35);
		contentPane.add(lblReason);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnOk.setBounds(138, 138, 100, 30);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancel.setBounds(251, 138, 100, 30);
		contentPane.add(btnCancel);
		
		tfUnits = new JTextField();
		tfUnits.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		tfUnits.setBounds(138, 36, 213, 35);
		contentPane.add(tfUnits);
		tfUnits.setColumns(10);
		
		tfUnits.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
		
		tfReason = new JTextField();
		tfReason.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		tfReason.setBounds(138, 83, 213, 35);
		contentPane.add(tfReason);
		tfReason.setColumns(10);
		setResizable(false);
	}
}
