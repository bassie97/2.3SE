package ui;

import java.awt.EventQueue;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;
import view.HistoryView;

public class MVCcalculator {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorController frame = new CalculatorController();
					CalculatorModel model = new CalculatorModel();
					CalculatorView view = new CalculatorView();
					HistoryView history = new HistoryView();
					frame.setModel(model);
					view.setModel(model);
					history.setModel(model);
					frame.add(view);
					frame.add(history);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
