package leertaak2Tree;
import java.util.Enumeration;

import javax.swing.tree.*;
public class BoomDing {
	private String postfix;
	private DefaultMutableTreeNode root;
	public BoomDing(){
		root = new DefaultMutableTreeNode("person");
	}
	
	public static void main(String[] args){
		BoomDing b = new BoomDing();
		DefaultMutableTreeNode root = b.getRoot();
		String[] nodes = {"employee","sales_rep","engineer","customer","us_customer","non_us_customer","local_customer","regional_customer"};
		DefaultMutableTreeNode[] treeNodes = new DefaultMutableTreeNode[nodes.length];
		for(int i = 0; i < nodes.length; i++){
			treeNodes[i] = new DefaultMutableTreeNode(nodes[i]);
		}
		//Person
		root.add(treeNodes[0]); // Employee
		root.add(treeNodes[3]); // Customer
		//Employee
		treeNodes[0].add(treeNodes[1]); // Sales_Rep
		treeNodes[0].add(treeNodes[2]); // Engineer
		// Customer
		treeNodes[3].add(treeNodes[4]); // US_Customer
		treeNodes[3].add(treeNodes[5]); // NON_US
		// US_Customer
		treeNodes[4].add(treeNodes[6]); // Local
		treeNodes[4].add(treeNodes[7]); // Regional
		
		System.out.println("--------------BREADTHFIRST----------");
		Enumeration<DefaultMutableTreeNode> breadth = root.breadthFirstEnumeration();
		for(Enumeration<DefaultMutableTreeNode> br = breadth; br.hasMoreElements();){
			System.out.println(br.nextElement().getUserObject());
		}
		System.out.println("--------------PREORDER-----------");
		breadth = root.preorderEnumeration();
		for(Enumeration<DefaultMutableTreeNode> br = breadth; br.hasMoreElements();){
			System.out.println(br.nextElement().getUserObject());
		}
		System.out.println("--------------POSTORDER-----------");
		breadth = root.postorderEnumeration();
		for(Enumeration<DefaultMutableTreeNode> br = breadth; br.hasMoreElements();){
			System.out.println(br.nextElement().getUserObject());
		}
		//super netjes dit
	}
	public DefaultMutableTreeNode getRoot(){
		return root;
	}
}
