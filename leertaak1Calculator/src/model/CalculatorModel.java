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

/**
 * The multiformat calculator
 */
public class CalculatorModel {
  private Rational operand_0 = new Rational();
  private Rational operand_1 = new Rational();
  
  // The current format of the calculator
  private Format format = new FixedPointFormat();
  // The current numberbase of the calculator
  private Base base = new DecimalBase();
  // The current result string on the result view
  private String text = new String();
  
  //Utility field used by event firing machine
  private ArrayList<ActionListener> actionListenerList;

  public void addOperand(String newOperand) throws FormatException {
	  operand_1 = operand_0;
	  try{
		  base.checkBase(newOperand);
		  operand_0 = format.parse(newOperand, base);
	  }	  
	  catch (NumberBaseException ex){
		  System.out.println("Wrong operand: " + ex.getMessage());
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

/**
   * @return text
   */
  public String getText(){
	  return text;
  }

  public void add(){
    operand_0 = operand_1.plus(operand_0);
    operand_1 = new Rational();
  }
  public void subtract() {
    operand_0 = operand_1.minus(operand_0);
    operand_1 = new Rational();
  }
  public void multiply() {
    operand_0 = operand_1.mul(operand_0);
    operand_1 = new Rational();
  }
  public void divide() {
	 Rational tempOperand = operand_1;
	 try{
		 operand_0 = operand_1.div(operand_0);
	 }
	 catch(IllegalArgumentException zero){
		 System.out.println("Cant devide by zero dummy!");
		 operand_0 = tempOperand;
	 }
    operand_1 = new Rational();
  }
  public void delete() {
    operand_0 = operand_1;
    operand_1 = new Rational();
  }

  public String firstOperand(){
    return format.toString(operand_1,base);
  }
  public String secondOperand(){
    return format.toString(operand_0,base);
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