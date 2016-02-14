/*
 * (C) Copyright 2005 Davide Brugali, Marco Torchiano
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307  USA
 */
package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import view.*;

/**
 * De main-klasse die leest en schrijft naar de console.
 * 
 * @author Brugali
 * @author Baljé
 */
public class Command{
	Calculator calc = new Calculator();
	CalculatorJFrame frame = new CalculatorJFrame(calc);
	VariableView variableView = new VariableView(calc);
	ButtonView buttonView = new ButtonView(calc);
	TextfieldView textfieldView = new TextfieldView(calc);
	AnswerView answerView = new AnswerView(calc);
	BufferedReader prevReader=null;
	BufferedReader lineReader = new  BufferedReader( new InputStreamReader( System.in ) );

  public Command(){
	  frame.addVariablePanel(variableView);
	  frame.setEnabled(true);
	  frame.setVisible(true);
  }

  public static void main(String[] args)  {
	  Command command = new Command();
  }

}