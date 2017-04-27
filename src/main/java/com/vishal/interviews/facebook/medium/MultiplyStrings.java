package com.vishal.interviews.facebook.medium;

/**
 * 43. Multiply Strings
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {

	}

	public String multiply(String num1, String num2) {
		String res = "";

		for (int i = num1.length() - 1; i >= 0; i--) {

			StringBuilder sb = new StringBuilder();

			int p = num1.charAt(i) - '0';
			int carry = 0;

			for (int j = num2.length() - 1; j >= 0; j--) {
				int q = num2.charAt(i) - '0';
				int prod = (p * q) + carry;
				sb.append(prod % 10);
				carry = prod / 10;
			}

			if (carry != 0) {
				sb.append(carry);
			}

			sb.reverse();

			for (int z = 0; z < (num1.length() - 1 - i); z++) {
				sb.append("0");
			}

			res = addStrings(res, sb.toString());
		}

		int z = 0;
		while (z < res.length() - 1 && res.charAt(z) - '0' == 0) {
			z++;
		}
		res = res.substring(z);
		return res;
	}

	static String addStrings(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int p = i >= 0 ? s1.charAt(i) - '0' : 0;
			int q = j >= 0 ? s1.charAt(j) - '0' : 0;
			int sum = p + q + carry;
			sb.append(sum % 10);
			carry = sum % 10;
			i--;
			j--;
		}
		return sb.reverse().toString();
	}

}
