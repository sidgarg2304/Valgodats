package com.vishal.interviews.programcreek;

public class AddBinary {

	public static void main(String[] args) {

	}

	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0 && b == null || b.length() == 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0) {
			int val1 = i >= 0 ? a.charAt(i) - '0' : 0;
			int val2 = j >= 0 ? b.charAt(j) - '0' : 0;

			int sum = val1 + val2 + carry;
			res.append(sum % 2);

			carry = sum / 2;
		}

		if (carry != 0) {
			res.append(carry);
		}

		return res.reverse().toString();
	}

}
