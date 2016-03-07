package com.enes.calculator.app;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.enes.calculator.app.Panel.Listener1;

public class Panel2 extends JPanel {
	
	private JButton[] b;
	private JButton[] t;
	private static JLabel label;
	private boolean clicked = false;
	private String first = "";
	private String second = "";
	private String sym = "";
	private boolean con = false;
	private double fN;
	private String equation;
	private double temp;
	
	public Panel2() {
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
	//	clear.addActionListener(new Listener4());
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
	
		public class Listener1 implements ActionListener{
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
			  if(con == false) {
				switch (evt.getActionCommand()) {
				case("+"):
					equation = "addition";
					 clicked = true;
			    	 sym = " + ";
			    	 label.setText(first + sym);
			    	 con = true;
			    	 break;
				case("-"):
					equation = "subtraction";
				 clicked = true;
		    	 sym = " - ";
		    	 label.setText(first + sym);
		    	 con = true;
		    	 break;
				case("x"):
					equation = "multiplication";
				 clicked = true;
		    	 sym = " x ";
		    	 label.setText(first + sym);
		    	 con = true;
		    	 break;
				case("/"):
					equation = "division";
				 clicked = true;
		    	 sym = " / ";
		    	 label.setText(first + sym);
		    	 con = true;
		    	 break;
				}
			  }
			  else if(con == true) {
				  Calculate cal2 = new Calculate();
				  
				  switch (evt.getActionCommand()) {
					case("+"):
						temp = cal2.equ(Double.parseDouble(first), Double.parseDouble(second), equation);
						first = Double.toString(temp);
						equation = "addition";
						 clicked = true;
				    	 sym = " + ";
				    	 label.setText(first + sym);
				    	 second = "";
				    	 con = true;
				    	 break;
					case("-"):
						temp = cal2.equ(Double.parseDouble(first), Double.parseDouble(second), equation);
						first = Double.toString(temp);
						second = "";
						equation = "subtraction";
						 clicked = true;
				    	 sym = " - ";
				    	 label.setText(first + sym);
				    	 con = true;
			    	 break;
					case("x"):
						temp = cal2.equ(Double.parseDouble(first), Double.parseDouble(second), equation);
						first = Double.toString(temp);
						second = "";
						equation = "multiplication";
						 clicked = true;
				    	 sym = " x ";
				    	 label.setText(first + sym);
				    	 con = true;
			    	 break;
					case("/"):
						temp = cal2.equ(Double.parseDouble(first), Double.parseDouble(second), equation);
						first = Double.toString(temp);
						second = "";
						equation = "division";
						 clicked = true;
				    	 sym = " / ";
				    	 label.setText(first + sym);
				    	 con = true;
			    	 break;
					}
			  }
			}
		}
		
		public class Listener3 implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				Calculate cal = new Calculate();
				switch (equation) {
					case "addition":
						fN = cal.addition(Double.parseDouble(first), Double.parseDouble(second));
						break;
					case "subtraction":
						fN = cal.subtraction(Double.parseDouble(first), Double.parseDouble(second));
						break;
					case "multiplication":
						fN = cal.multiplication(Double.parseDouble(first), Double.parseDouble(second));
						break;
					case "division":
						fN = cal.division(Double.parseDouble(first), Double.parseDouble(second));
						break;
				}
				label.setText(first + sym + second + " = " + fN);
			}
		}
}
