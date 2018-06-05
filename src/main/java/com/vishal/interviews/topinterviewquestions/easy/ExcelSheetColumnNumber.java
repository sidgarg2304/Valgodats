package com.vishal.interviews.topinterviewquestions.easy;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {

	}

	public int titleToNumber(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int res = 0;

		int base = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			res += base * (c - 'A' + 1);
			base *= 26;
		}
		return res;
	}

}
