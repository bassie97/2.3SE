package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Calculator;

public class ButtonView extends JPanel{

	private Calculator calc;
	
	public ButtonView(Calculator calc){
		this.calc = calc;
		setBorder(new TitledBorder(null, "Variables", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(659, 11, 147, 306);
	}
}
