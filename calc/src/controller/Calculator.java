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

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.DivideException;
import exception.FormatException;
import exception.NumberBaseException;
import model.Base;
import model.DecimalBase;
import model.FixedPointFormat;
import model.Format;
import model.Rational;

/**
 * The multiformat calculator
 */
public class Calculator {
  private Rational operand_0 = new Rational();
  private Rational operand_1 = new Rational();
  private Stack stack = new Stack();
  private Map<String, Rational> variables = new HashMap<String, Rational>();
  private JTextField textfield;
  private int addVariable;
  
  // The current format of the calculator
  private Format format = new FixedPointFormat();
  // The current numberbase of the calculator
  private Base base = new DecimalBase();

  public Calculator(){
	  stack.push(operand_0);
	  stack.push(operand_1);
  }
  public void addOperand(String newOperand) throws FormatException, NumberBaseException {
	  String base_chars = this.base.getBaseChars();
	  base_chars += "+-.";
	  base_chars = base_chars.toLowerCase();
	  newOperand = newOperand.toLowerCase();
	  checkValidOperand(newOperand, base_chars);
//	  operand_1 = operand_0;
//      operand_0 = format.parse(newOperand.toUpperCase(), base);
      stack.push(format.parse(newOperand.toUpperCase(), base));
  }
  
  public void checkValidOperand(String operand, String base) throws NumberBaseException{

	  for (int i=0; i<operand.length(); i++) {
		    if(!(base.indexOf(operand.charAt(i)) >= 0)){
		    	throw new NumberBaseException(base);
			    
		    }
	  }
  }
  
  public void addVariable(String name, String value) throws NumberBaseException, FormatException{
	  String base_chars = this.base.getBaseChars();
	  base_chars += "+-.";
	  base_chars = base_chars.toLowerCase();
	  value = value.toLowerCase();
	  checkValidOperand(value, base_chars);

	 variables.put(name, format.parse(value.toUpperCase(), base));
  }

  public void add(){
	operand_0 = (Rational) stack.pop();
	operand_1 = (Rational) stack.pop();
    operand_0 = operand_1.plus(operand_0);
    operand_1 = new Rational();
    stack.push(operand_0);
  }
  public void subtract() {
	operand_0 = (Rational) stack.pop();
	operand_1 = (Rational) stack.pop();
    operand_0 = operand_1.minus(operand_0);
    operand_1 = new Rational();
    stack.push(operand_0);
  }
  public void multiply() {
	operand_0 = (Rational) stack.pop();
	operand_1 = (Rational) stack.pop();
    operand_0 = operand_1.mul(operand_0);
    operand_1 = new Rational();
    stack.push(operand_0);
  }
  public void divide() {
	operand_0 = (Rational) stack.pop();
	operand_1 = (Rational) stack.pop();
	  
    try {
		operand_0 = operand_1.div(operand_0);
	} catch (DivideException e) {
		e.printStackTrace();
	}
    operand_1 = new Rational();
    stack.push(operand_0);
    
  }
  public void delete() {
    operand_0 = operand_1;
    operand_1 = new Rational();
  }

  public String firstOperand(){
	  	operand_0 = (Rational) stack.pop();
		operand_1 = (Rational) stack.pop();
		stack.push(operand_1);
		stack.push(operand_0);
    return format.toString(operand_1,base);
  }
  public String secondOperand(){
	  operand_0 = (Rational) stack.pop();
	  stack.push(operand_0);
    return format.toString(operand_0,base);
  }
  
  public void addVariableTextfield(String variableName){
	  Rational value = variables.get(variableName);
	  textfield.setText(format.toString(value,base));
	  addVariable--;
	  
  }
  
  public void setAddVariable(int add){
	  this.addVariable = add;
  }
  
  public void setJTextField(JTextField textfield){
	  this.textfield = textfield;
  }

  public void setBase(Base newBase){
    base = newBase;
  }
  public Base getBase(){
    return base;
  }
  public void setFormat(Format newFormat){
    format = newFormat;
  }
  public Format getFormat(){
    return format;
  }
}