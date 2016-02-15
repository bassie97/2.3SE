package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import model.CalculatorModel;

public class HistoryView extends JTextPane implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CalculatorModel model;

	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setEditable(false);
		setBounds(779, 33, 210, 422);
	}
	
	/**
	 * set te model for the view
	 * @param model
	 */
	public void setModel(CalculatorModel model) {
		this.model = model;
		
		if (model != null) {
			//register the view as listener for the model
			model.addActionListener(this);
		}
		
		repaint();
	}
	
	/**
	 * 
	 * @return model
	 */
	public CalculatorModel getModel(){
		return this.model;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<String> list = model.getHistory();
		String historyString = "";
		for (String row : list) {
			historyString += row + System.getProperty("line.separator");
			
		}
		this.setText(historyString);
		repaint();
		
	}
}

	
