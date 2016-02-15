package ui;

import java.awt.EventQueue;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

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
					frame.setModel(model);
					view.setModel(model);
					frame.add(view);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
