package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorView extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorView(JFrame frame, String errorMsg){ 
		JDialog new_dialog = new JDialog(frame, "Test");
		JLabel message = new JLabel(errorMsg);
		new_dialog.add(message);
		new_dialog.setModal(false);
		new_dialog.setVisible(true);
		new_dialog.toFront();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
