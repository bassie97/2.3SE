package view;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import controller.Calculator;
import controller.Command;
import exception.FormatException;
import exception.NumberBaseException;
import model.BinaryBase;
import model.DecimalBase;
import model.HexBase;
import model.OctalBase;

import javax.swing.JProgressBar;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import java.awt.SystemColor;

public class CalculatorJFrame extends JFrame {

	private JPanel contentPane;
	private Calculator calculator;
	private JTextField txtInsertNumbersHere;
	private JLabel lblInformation;
	private JLabel answer;
	
	//Variables for statistics
	private int plus = 0;
	private int min = 0;
	private int div = 0;
	private int mul = 0;
	private int add = 0;
	

	/**
	 * Create the frame.
	 */
	public CalculatorJFrame(Calculator calc) {
		setResizable(false);
		calculator = calc;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\marni\\Downloads\\warmup-math-icon.png"));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 375);
		calc.setAddVariable(add);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		mnMenu.add(mntmStatistics);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnMenu.add(mntmAbout);
		
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);

		
		mntmHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "+            sum the last two operands\n"
            			+ "-            substract the last operand from the previous one\n"
            			+ "*            multiply the last two operands\n"
            			+ "/            divide the last two operands\n"
            			+ "dec          switch to base 10\n"
            			+ "bin          switch to binary base\n"
            			+ "hex          switch to hexadecimal base\n"
            			+ "fixed        switch to fixed point format\n"
            			+ "float        switch to floating point format\n"
            			+ "", "Help",
        	            JOptionPane.ERROR_MESSAGE);
            }
        });
		
		mntmAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "This calculator was commissioned by Hanzehogeschool Groningen \n"
            			+ "Authors: Daniel Boonstra & Marnix Blaauw", "About",
        	            JOptionPane.ERROR_MESSAGE);
            }
        });
		
		mntmStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Times clicked + : " + plus + "\n"
            			+ "Times clicked - : " + min + "\n"
            			+ "Times clicked / : " + div + "\n"
            			+ "Times clicked * : " + mul + "\n"
            			+ "Total calculations made :" + add, "Statistics",
        	            JOptionPane.ERROR_MESSAGE);
            }
        });
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setPreferredSize(new Dimension(200, 200));
		contentPane.setLayout(null);
		
		JPanel scherm = new JPanel();
		scherm.setBounds(5, 11, 642, 84);
		scherm.setBorder(new TitledBorder(null, "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scherm.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.add(scherm);
		scherm.setLayout(null);
		
		lblInformation = new JLabel("Information:");
		lblInformation.setBounds(12, 19, 611, 16);
		scherm.add(lblInformation);
		
		answer = new JLabel("Answer:");
		answer.setBounds(12, 36, 611, 44);
		answer.setFont(new Font("Tahoma", Font.PLAIN, 36));
		scherm.add(answer);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(5, 102, 642, 96);
		panel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtInsertNumbersHere = new JTextField();
		txtInsertNumbersHere.setBounds(12, 23, 604, 55);
		txtInsertNumbersHere.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(txtInsertNumbersHere);
		txtInsertNumbersHere.setColumns(10);
		calculator.setJTextField(txtInsertNumbersHere);
		
		JPanel knoppen = new JPanel();
		knoppen.setBackground(UIManager.getColor("CheckBox.light"));
		knoppen.setBounds(5, 202, 642, 115);
		knoppen.setBorder(new TitledBorder(null, "Buttons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(knoppen);
		
		
		JButton plusButton = new JButton("+");
		plusButton.setBackground(UIManager.getColor("Button.background"));
		plusButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		plusButton.setBounds(9, 19, 69, 27);
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plus ++;
				calc.add();
				updateText();
				updateAnswer();
			}
		});
		knoppen.setLayout(null);
		knoppen.add(plusButton);
		
		JButton minusButton = new JButton("-");
		minusButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		minusButton.setBounds(78, 19, 69, 27);
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				min ++;
				calc.subtract();
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(minusButton);
		
		JButton multiplyButton = new JButton("*");
		multiplyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiplyButton.setBounds(147, 46, 69, 27);
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mul ++;
				calc.multiply();
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(multiplyButton);
		
		JButton divideButton = new JButton("/");
		divideButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		divideButton.setBounds(147, 73, 69, 27);
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				div ++;
				calc.divide();
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(divideButton);
		
		JButton octButton = new JButton("Oct");
		octButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		octButton.setBounds(9, 46, 69, 27);
		octButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.setBase(new OctalBase());
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(octButton);
		
		JButton hexButton = new JButton("Hex");
		hexButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		hexButton.setBounds(78, 46, 69, 27);
		hexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.setBase(new HexBase());
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(hexButton);
		
		JButton decButton = new JButton("Dec");
		decButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		decButton.setBounds(9, 73, 69, 27);
		decButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.setBase(new DecimalBase());
				updateText();
				updateAnswer();
			}
		});
		knoppen.add(decButton);
		
		JButton fourButton = new JButton("4");
		fourButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		fourButton.setBounds(492, 46, 69, 27);
		knoppen.add(fourButton);
		
		JButton nineButton = new JButton("9");
		nineButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nineButton.setBounds(492, 73, 69, 27);
		knoppen.add(nineButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		zeroButton.setBounds(216, 46, 69, 27);
		knoppen.add(zeroButton);
		
		JButton dButton = new JButton("D");
		dButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		dButton.setBounds(354, 19, 69, 27);
		knoppen.add(dButton);
		
		JButton eButton = new JButton("E");
		eButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		eButton.setBounds(423, 19, 69, 27);
		knoppen.add(eButton);
		
		JButton binButton = new JButton("Bin");
		binButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		binButton.setBounds(78, 73, 69, 27);
		knoppen.add(binButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{knoppen, contentPane, scherm, lblInformation, answer, panel, txtInsertNumbersHere, plusButton, minusButton, multiplyButton, divideButton, binButton, octButton, hexButton, decButton}));
		
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		addButton.setBounds(564, 19, 64, 81);
		knoppen.add(addButton);
		
		JButton aButton = new JButton("A");
		aButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		aButton.setBounds(147, 19, 69, 27);
		knoppen.add(aButton);
		
		JButton bButton = new JButton("B");
		bButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		bButton.setBounds(216, 19, 69, 27);
		knoppen.add(bButton);
		
		JButton cButton = new JButton("C");
		cButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		cButton.setBounds(285, 19, 69, 27);
		knoppen.add(cButton);
		
		JButton oneButton = new JButton("1");
		oneButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		oneButton.setBounds(285, 46, 69, 27);
		knoppen.add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		twoButton.setBounds(354, 46, 69, 27);
		knoppen.add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		threeButton.setBounds(423, 46, 69, 27);
		knoppen.add(threeButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		fiveButton.setBounds(216, 73, 69, 27);
		knoppen.add(fiveButton);
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton sixButton = new JButton("6");
		sixButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		sixButton.setBounds(285, 73, 69, 27);
		knoppen.add(sixButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		sevenButton.setBounds(354, 73, 69, 27);
		knoppen.add(sevenButton);
		
		JButton eightButton = new JButton("8");
		eightButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		eightButton.setBounds(423, 73, 69, 27);
		knoppen.add(eightButton);
		
		JButton fButton = new JButton("F");
		fButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		fButton.setBounds(492, 19, 69, 27);
		knoppen.add(fButton);
		
		
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 8 );
			}
		});
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 7 );
			    
			}
		});
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 1 );
			}
		});
		
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 2 );
			}
		});
		
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 3 );
			}
		});
		
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 4 );
			}
		});
		
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 5 );
			}
		});
		
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 6 );
			}
		});
		
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 9 );
			}
		});
		
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + 0 );
			}
		});
		
		aButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "A" );
			}
		});
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "C" );
			}
		});
		bButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "B" );
			}
		});
		dButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "D" );
			}
		});
		eButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "E" );
			}
		});
		fButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInsertNumbersHere.setText(txtInsertNumbersHere.getText() + "F" );
			}
		});
		
		
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		        	calc.addOperand(txtInsertNumbersHere.getText());
		        }catch(FormatException e){
		          System.out.println("Wrong operand: " + e.getMessage());
		        } catch (NumberBaseException e) {
		        	System.out.println("Not allowed in this base: " + e.getMessage());
					e.printStackTrace();
				}
				updateText();
			}
		});
		binButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.setBase(new BinaryBase());
				updateText();
				updateAnswer();
			}
		});
	}
	
	public void updateText(){
		lblInformation.setText("Base: " + calculator.getBase().getName()+
							"; Format: " + calculator.getFormat().getName()+
							"; First Operand: " + calculator.firstOperand() + 
							"; Second Operand: " + calculator.secondOperand());
	}
	
	public void updateAnswer(){
		add ++;
		answer.setText("Answer: " + calculator.secondOperand());
	}
	
	public void addVariablePanel(JPanel panel){
		contentPane.add(panel);
	}
}
