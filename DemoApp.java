package com.enes.calculator.app;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class DemoApp {	
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame("App");
		frame.setSize(250, 300);
		frame.setLocation(800, 160);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setContentPane(new Panel());
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);

	}
	
	

}
