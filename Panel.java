package com.enes.calculator.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel {
		
	private JButton[] b;
	private JButton[] t;
	private JLabel label;
	private String first = "";
	private String second = "";
	private String equation;
	private Boolean clicked = false;
	private String sym = "";
	private int fN;
	
		public Panel() {
			
			setLayout(new BorderLayout());
			
			JPanel pnl1 = new JPanel();
			add(pnl1, BorderLayout.NORTH);
			
			label = new JLabel("0");
			label.setFont(new Font("Arial", Font.BOLD, 20));
			pnl1.add(label);
			
			JPanel pnl2 = new JPanel();
			add(pnl2, BorderLayout.CENTER);
			
			pnl2.setLayout(new GridLayout(4, 3));
			
			b  = new JButton[10];
			for(int i = 0; i < 10; i++)
			{
			 b[i] = new JButton(Integer.toString(i));
			 b[i].addActionListener(new Listener1());
			 pnl2.add(b[i]);
			}
			
			JButton equal = new JButton("=");
			equal.addActionListener(new Listener3());
			pnl2.add(equal);
			
			JButton clear = new JButton("Clear");
			clear.addActionListener(new Listener4());
			pnl2.add(clear);
			
			JPanel pnl3 = new JPanel();
			add(pnl3, BorderLayout.EAST);
			
			pnl3.setLayout(new GridLayout(4, 1));
			
			t = new JButton[4];
			for(int i = 0; i < 4; i++) {
				t[0] = new JButton("+");
				t[1] = new JButton("-");
				t[2] = new JButton("x");
				t[3] = new JButton("/");
				t[i].addActionListener(new Listener2());
				pnl3.add(t[i]);
			}
		}
			public class Listener1 implements ActionListener {
			 public void actionPerformed(ActionEvent evt) {
				 for(int i = 0; i < 10; i++) {
					if (evt.getSource() == b[i]) {
						if(clicked == false) {
							first = first + i;
							label.setText(first);
						}
						else if(clicked == true) {
							second = second + i;
							label.setText(first + sym + second);
						}
					}
				 }
			  }
			}
			
			public class Listener2 implements ActionListener {
				public void actionPerformed(ActionEvent evt) {
						if(evt.getActionCommand() == "+") {
						  
							  equation = "addition";
				    		  label.setText(first + " + ");
				    		  clicked = true;
				    		  sym = " + ";
						  
						}
						
						else if(evt.getActionCommand() == "-") {
							equation = "subtraction";
				    		  label.setText(first + " - ");
				    		  clicked = true;
				    		  sym = " - ";
						}
						
						else if(evt.getActionCommand() == "x") {
							equation = "multiplication";
				    		  label.setText(first + " x ");
				    		  clicked = true;
				    		  sym = " x ";
						}
						
						else if(evt.getActionCommand() == "/") {
							equation = "division";
				    		  label.setText(first + " / ");
				    		  clicked = true;
				    		  sym = " / ";
						}
				}
			}
			
			public class Listener3 implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					Calculate cal = new Calculate();
					switch (equation) {
						case "addition":
							fN = cal.addition(Integer.parseInt(first), Integer.parseInt(second));
							break;
						case "subtraction":
							fN = cal.subtraction(Integer.parseInt(first), Integer.parseInt(second));
							break;
						case "multiplication":
							fN = cal.multiplication(Integer.parseInt(first), Integer.parseInt(second));
							break;
						case "division":
							fN = cal.division(Integer.parseInt(first), Integer.parseInt(second));
							break;
					}
					label.setText(first + sym + second + " = " + fN);
				}
			}
			
			public class Listener4 implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					first = "";
					second = "";
					equation = "";
					clicked = false;
					
					label.setText("0");
				}
			}
			
}
