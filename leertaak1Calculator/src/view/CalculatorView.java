package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import model.CalculatorModel;

public class CalculatorView extends JTextField implements ActionListener{
	private CalculatorModel model;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorView(){
		this.setBounds(12, 13, 753, 130);
		this.setColumns(10);
		Font font = new Font("SansSerif", Font.BOLD, 50);
		this.setFont(font);
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
	
	
	/**
	 * show the result in the outputscreen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setText(model.getText());
	}
}