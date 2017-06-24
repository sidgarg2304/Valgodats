package com.vishal.interviews.programcreek.math;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {

		System.out.println(titleToNumber("Z"));
	}

	public static int titleToNumber(String s) {

		int x = 1;
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			int val = c - 'A' + 1;

			res += x * val;
			x *= 26;
		}
		
		return res;
	}

}
