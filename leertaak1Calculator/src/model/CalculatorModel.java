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
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * The multiformat calculator
 */
public class CalculatorModel {
  private Rational operand_0 = new Rational();
  private Rational operand_1 = new Rational();
  private Stack<Rational> operands = new Stack();
  private Iterator<Rational> operandIterator;
  private String operator = "";
  
  // The current format of the calculator
  private Format format = new FixedPointFormat();
  // The current numberbase of the calculator
  private Base base = new DecimalBase();
  // The current result string on the result view
  private String text = "";
  
  //Utility field used by event firing machine
  private ArrayList<ActionListener> actionListenerList;
  //Arraylist for keeping track of the used calculations
  private ArrayList<String> history = new ArrayList<String>();

  public void addOperand(String newOperand) throws FormatException {
	  System.out.println(newOperand);
	 // operand_1 = operand_0;
	  try{
		  base.checkBase(newOperand);
		  try{
		  operands.push(format.parse(newOperand, base));
		  }catch (FormatException ex){
			  JOptionPane.showMessageDialog(null, "Wrong operand: " + ex.getMessage());
		  }
	  }	  
	  catch (NumberBaseException ex){
		  JOptionPane.showMessageDialog(null, "Wrong operand: " + ex.getMessage());
		  clearText();
	  }
  }
  
  /**
   * update the string for the view
   * @param keyStroke
   */
  public void updateText(String keyStroke){
	  text = text + keyStroke;
	  processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateText"));
  }
  
  public void clearText(){
	  text = "";
	  processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cleartext"));
	  
  }
  
  /**
   * get the text from te view and run addOperand
   */
  public void updateOperand() {
	  if(text == "") {
		  System.out.println("Can't add empty operand");
	  }else{
		  try{
			  System.out.println("added operand");
			  System.out.println(secondOperand());
			  addOperand(text);
			  clearText();
		  }catch (FormatException ex) {
			  System.out.println("Wrong operand: " + ex.getMessage());
		  }
	  }	
  }

/**
   * @return text
   */
  public String getText(){
	  return text;
  }

  public void add(){

    operand_1 = new Rational();
    Rational op = new Rational();
    while(operands.size() > 0){
    	op = operands.pop();
    	operand_1 = operand_1.plus(op);
    }   
    updateText(firstOperand());
  }
  public void subtract() {
	  operand_1 = new Rational();
	    Rational op = new Rational();
	    operand_1 = operands.get(0);
	    while(operands.size() > 1){
	    	op = operands.pop();
	    	operand_1 = operand_1.minus(op);
	    }   
	    operands.pop();
	    updateText(firstOperand());
  }
  public void multiply() {
	    operand_1 = new Rational();
	    Rational op = new Rational();
	    while(operands.size() > 0){
	    	op = operands.pop();
	    	operand_1 = operand_1.mul(op);
	    }   
	    updateText(firstOperand());
  }
  public void divide() {
	 Stack<Rational> backupStack = new Stack<Rational>();
	 
	 
	 try{
		    Rational op = new Rational();
		    operand_1 = operands.get(0);
		    for(int i = 1; i < operands.size(); i++){
		    	op = operands.get(i);
		    	operand_1 = operand_1.div(op);
		    	backupStack.push(op);
		    }
		    operands = new Stack<Rational>();
	 }
	 catch(IllegalArgumentException zero){
		 System.out.println("Cant devide by zero dummy!");
		 operands = backupStack;
	 }
	 System.out.println(format.toString(operand_1,base));
    updateText(firstOperand());
  }
  public void delete() {
    operand_0 = operand_1;
    operand_1 = new Rational();
    clearText();
  }
  
  public void clear(){
	  operand_0 = new Rational();
	  operand_1 = new Rational();
	  clearText();
	  processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clearoperands"));
  }
  
  public void equals(){
	  String operator = getText();
	  operandIterator = operands.iterator();
	  Rational next = new Rational();
	  String savedOperand = new String();
	  while(operandIterator.hasNext()){
		 next = operandIterator.next();
		 savedOperand += format.toString(next, base) + ", ";
	  }
	  
	  clearText();
	  switch(operator){
	  case "+":
	  	  add();
	  	  break;
	  case "-":
		  subtract();
		  break;
	  case "/":
		  divide();
		  break;
	  case "*":
		  multiply();
		  break;
	  default:
		  System.out.println("Wrong operator");
	  }

	  addCalculation(savedOperand + operator + " = " + firstOperand());
	  
  }

  public String firstOperand(){
    return format.toString(operand_1,base);
  }
  public String secondOperand(){
    return format.toString(operand_0,base);
  }

  public void setBase(Base newBase){
    base = newBase;
    text = secondOperand();
    processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "changed base"));
  }
  
  public Base getBase(){
    return base;
  }
  
  public void setFormat(Format newFormat){
    format = newFormat;
    text = secondOperand();
    processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "changed base"));
    
  }
  public Format getFormat(){
    return format;
  }
  
  /**
   * fire action events
   * @param actionEvent
   */
  private void processEvent(ActionEvent e) {
		ArrayList list;
		
		synchronized (this) {
			if (actionListenerList == null) return;
			list = (ArrayList) actionListenerList.clone();
		}
		
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = (ActionListener) list.get(i);
			listener.actionPerformed(e);
		}
		
	}
  
  /**
   * add a calculation to the history
   * @param calc
   */
  private void addCalculation(String calc) {
	  history.add(calc);
	  processEvent(
			  new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "update history"));
  }
  
  public ArrayList<String> getHistory(){
	  return this.history;
  }

  /**
   * register an actionevent listener
   * @param l
   */
  public synchronized void addActionListener(ActionListener l) {
	  if (actionListenerList == null)
		  actionListenerList = new ArrayList<ActionListener>();
	  
	  actionListenerList.add(l);
  }
  
  /**
   * removen an actioneventlistener
   * @param l
   */
  public synchronized void removeActionListener(ActionEvent l) {
	  if (actionListenerList != null && actionListenerList.contains(l))
	  actionListenerList.remove(l);
  }
}