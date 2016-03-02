package com.enes.calculator.app;
public class Calculate {
	private int sol;
		public int addition(int first, int second) {
			sol = first + second;
			return sol;
		}
		public int subtraction(int first, int second) {
			sol = first - second;
			return sol;
		}
		public int multiplication(int first, int second) {
			sol = first * second;
			return sol;
		}
		public int division(int first, int second) {
			sol = first / second;
			return sol;
		}
}
