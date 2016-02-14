package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class CalculatorController extends JFrame {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorController frame = new CalculatorController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorController() {
		setTitle("MultiFormatCalculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 503);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 13, 778, 130);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(12, 156, 97, 70);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBounds(121, 156, 97, 70);
		getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("3");
		button.setBounds(230, 156, 97, 70);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("4");
		button_1.setBounds(339, 156, 97, 70);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("+");
		button_2.setBounds(449, 156, 97, 70);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.setBounds(558, 156, 97, 70);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(12, 233, 97, 70);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(121, 233, 97, 70);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(230, 233, 97, 70);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBounds(339, 233, 97, 70);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("*");
		button_8.setBounds(449, 233, 97, 70);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("/");
		button_9.setBounds(558, 233, 97, 70);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton("9");
		button_10.setBounds(12, 311, 97, 70);
		getContentPane().add(button_10);
		
		JButton button_11 = new JButton("0");
		button_11.setBounds(121, 311, 97, 70);
		getContentPane().add(button_11);
		
		JButton btnA = new JButton("A");
		btnA.setBounds(230, 311, 97, 70);
		getContentPane().add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setBounds(339, 311, 97, 70);
		getContentPane().add(btnB);
		
		JButton button_14 = new JButton(".");
		button_14.setBounds(449, 311, 97, 70);
		getContentPane().add(button_14);
		
		JButton button_15 = new JButton("^");
		button_15.setBounds(558, 311, 97, 70);
		getContentPane().add(button_15);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(12, 388, 97, 70);
		getContentPane().add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setBounds(121, 388, 97, 70);
		getContentPane().add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setBounds(230, 388, 97, 70);
		getContentPane().add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.setBounds(339, 388, 97, 70);
		getContentPane().add(btnF);
		
		JButton button_20 = new JButton("=");
		button_20.setBounds(449, 388, 97, 70);
		getContentPane().add(button_20);
		
		JButton btnC_1 = new JButton("C");
		btnC_1.setBounds(558, 388, 97, 70);
		getContentPane().add(btnC_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hexadecimal");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(664, 179, 127, 25);
		getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblBase = new JLabel("Base:");
		lblBase.setBounds(667, 156, 56, 16);
		getContentPane().add(lblBase);
		
		JRadioButton rdbtnBinary = new JRadioButton("Binary");
		buttonGroup.add(rdbtnBinary);
		rdbtnBinary.setBounds(663, 201, 127, 25);
		getContentPane().add(rdbtnBinary);
		
		JRadioButton rdbtnOctal = new JRadioButton("Octal");
		buttonGroup.add(rdbtnOctal);
		rdbtnOctal.setBounds(663, 222, 127, 25);
		getContentPane().add(rdbtnOctal);
		
		JRadioButton rdbtnDecimal = new JRadioButton("Decimal");
		buttonGroup.add(rdbtnDecimal);
		rdbtnDecimal.setBounds(663, 245, 127, 25);
		getContentPane().add(rdbtnDecimal);
		
		JLabel lblFormat = new JLabel("Format:");
		lblFormat.setBounds(667, 287, 56, 16);
		getContentPane().add(lblFormat);
		
		JRadioButton rdbtnFractional = new JRadioButton("Fractional");
		buttonGroup_1.add(rdbtnFractional);
		rdbtnFractional.setBounds(663, 312, 127, 25);
		getContentPane().add(rdbtnFractional);
		
		JRadioButton rdbtnFloatingPoint = new JRadioButton("Floating Point");
		buttonGroup_1.add(rdbtnFloatingPoint);
		rdbtnFloatingPoint.setBounds(663, 334, 127, 25);
		getContentPane().add(rdbtnFloatingPoint);
		
		JRadioButton rdbtnFixedPoint = new JRadioButton("Fixed Point");
		buttonGroup_1.add(rdbtnFixedPoint);
		rdbtnFixedPoint.setBounds(663, 356, 127, 25);
		getContentPane().add(rdbtnFixedPoint);
		Dimension dim = new Dimension(700, 50);
	}
}