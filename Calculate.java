package com.enes.calculator.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {
	private double sol;
	

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
		public double addition(double first, double second) {
			sol = first + second;
			sol = round(sol, 2);
			return sol;
		}
		public double subtraction(double first, double second) {
			sol = first - second;
			sol = round(sol, 2);
			return sol;
		}
		public double multiplication(double first, double second) {
			sol = first * second;
			sol = round(sol, 2);
			return sol;
		}
		public double division(double first, double second) {
			sol = first / second;
			sol = round(sol, 2);
			return sol;
		}
		
		public double equ(double first, double second, String equation) {
			if(equation == "addition") {
				sol = first + second;
				sol = round(sol, 2);
			}
			
			else if(equation == "subtraction") {
				sol = first - second;
				sol = round(sol, 2);
			}
			
			else if(equation == "multiplication") {
				sol = first * second;
				sol = round(sol, 2);
			}
			
			else if(equation == "division") {
				sol = first / second;
				sol = round(sol, 2);
			}
				
			return sol;
					
		}
}
