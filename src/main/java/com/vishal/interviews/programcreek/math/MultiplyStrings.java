package com.vishal.interviews.programcreek.math;

public class MultiplyStrings {

	public static void main(String[] args) {

	}

	public String multiply(String num1, String num2) {

		String res = "";
		for (int i = num2.length() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			int val1 = num2.charAt(i) - '0';
			int carry = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				int val2 = num2.charAt(i) - '0';

				int prod = (val1 * val2) + carry;
				sb.append(prod % 10);
				carry = prod / 10;
			}

			if (carry != 0) {
				sb.append(carry);
			}

			sb.reverse();

			for (int z = 0; z < (num1.length() - i - 1); z++) {
				sb.append("0");
			}
			res = addTwoStrings(res, sb.toString());
		}

		int i = 0;
		while (i < res.length() - 1 && res.charAt(i) == '0') {
			i++;
		}

		res = res.substring(i);
		return res;
	}

	String addTwoStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

}
