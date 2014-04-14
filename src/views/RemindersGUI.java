package views;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class RemindersGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemindersGUI() {
		setLayout(null);
		
		JLabel lblTest = new JLabel("I'm the remindersGUI");
		lblTest.setBounds(32, 25, 179, 14);
		add(lblTest);
		setVisible(true);

	}

}
