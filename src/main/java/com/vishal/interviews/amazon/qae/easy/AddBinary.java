package com.vishal.interviews.amazon.qae.easy;

/**
 * 67. Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;

		while (i >= 0 || j >= 0) {
			int v1 = i < 0 ? 0 : (a.charAt(i) - '0');
			int v2 = j < 0 ? 0 : (b.charAt(j) - '0');

			int sum = v1 + v2 + carry;

			sb.append(sum % 2);
			carry = sum / 2;
			j--;
			i--;
		}

		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}
