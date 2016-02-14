package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Calculator;

public class TextfieldView extends JPanel{

	private Calculator calc;
	
	public TextfieldView(Calculator calc){
		this.calc = calc;
		setBorder(new TitledBorder(null, "Variables", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(659, 11, 147, 306);
	}
}
