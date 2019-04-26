package com.vishal.interviews.uber.medium;

import java.util.*;

public class SolvetheEquation {

	public static void main(String[] args) {
		SolvetheEquation s = new SolvetheEquation();
		System.out.println(s.solveEquation("2x=x"));
	}

	public String solveEquation(String equation) {

		if (equation == null || equation.length() == 0) {
			return "";
		}

		int side = 1;
		int xCoEff = 0;
		int val = 0;

		int sign = 1;
		Stack<Integer> stack = new Stack<>();
		equation = equation.replaceAll("\\s", "");

		int i = 0;
		while (i < equation.length()) {
			char c = equation.charAt(i);

			if (c == '=') {
				side = -1;
				sign = 1;
				i++;
			} else if (c == 'x') {
				xCoEff += side * sign;
				i++;
			} else if (Character.isDigit(c)) {
				int en = i;
				int curVal = 0;
				while (en < equation.length() && Character.isDigit(equation.charAt(en))) {
					curVal *= 10;
					curVal += equation.charAt(en) - '0';
					en++;
				}
				if (en < equation.length() && equation.charAt(en) == 'x') {
					en++;
					xCoEff += curVal * side * sign;
				} else {
					stack.push(sign * side * curVal);
				}
				i = en;
			} else {
				sign = c == '-' ? -1 : 1;
				i++;
			}
		}

		while (!stack.isEmpty()) {
			val += stack.pop();
		}

		if (xCoEff == 0 && val != 0) {
			return "No solution";
		}
		if (xCoEff == 0 && val == 0) {
			return "Infinite solutions";
		}

		val = val / xCoEff;
		return "x=" + String.valueOf(val * (-1));
	}

}
