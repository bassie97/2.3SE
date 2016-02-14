package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Calculator;
import exception.FormatException;
import exception.NumberBaseException;
import model.HexBase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

public class VariableView extends JPanel{

	private Calculator calc;
	
	public VariableView(Calculator calc){
		this.calc = calc;
		setBorder(new TitledBorder(null, "Variables", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(659, 11, 286, 306);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(23, 16, 61, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(124, 16, 57, 14);
		add(lblNewLabel_1);
		
		JLabel lblButton = new JLabel("Button");
		lblButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblButton.setBounds(215, 16, 57, 14);
		add(lblButton);
		
		JButton btnNewButton = new JButton("New Variable");
		btnNewButton.setBounds(12, 272, 264, 23);
		add(btnNewButton);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		namePanel.setBounds(12, 41, 81, 219);
		add(namePanel);
		namePanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JPanel valuePanel = new JPanel();
		valuePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		valuePanel.setBounds(103, 40, 102, 219);
		add(valuePanel);
		valuePanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JPanel knopPanel = new JPanel();
		knopPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		knopPanel.setBounds(215, 41, 61, 219);
		add(knopPanel);
		knopPanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             String name = JOptionPane.showInputDialog("Please enter a symbol for this variable:");
             String value = JOptionPane.showInputDialog("Please enter a value this variable:");
             try {
              JButton addButton = new JButton("Add");
     calc.addVariable(name, value);
     
     namePanel.add(new JLabel(name));
              valuePanel.add(new JLabel(value + " ("+ calc.getBase().getName() + ")"));
              knopPanel.add(addButton);
              addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
             calc.addVariableTextfield(name);
            }
           });
                 
              revalidate();
              repaint();
    } catch (NumberBaseException e1) {
    } catch (FormatException e1) {
    }
             
            }
        });
 }
}
