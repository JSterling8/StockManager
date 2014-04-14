package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StockGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public StockGUI() {
		setLayout(null);
		
		JLabel lblIAmThe = new JLabel("I am the StockGUI screen");
		lblIAmThe.setBounds(10, 11, 226, 14);
		add(lblIAmThe);

	}

}
