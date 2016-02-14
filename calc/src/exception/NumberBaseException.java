package exception;

import javax.swing.JOptionPane;

public class NumberBaseException extends Exception {

	public NumberBaseException(String msg) {
		JOptionPane.showMessageDialog(null, "The given number/symbol isn't allowed in this numberbase.", "Error",
	            JOptionPane.ERROR_MESSAGE);
	  }
	
	
	
}
