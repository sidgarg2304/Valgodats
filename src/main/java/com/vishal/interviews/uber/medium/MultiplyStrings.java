package com.vishal.interviews.uber.medium;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String multiply(String num1, String num2) {
		String res = "";

		for (int i = num2.length() - 1; i >= 0; i--) {
			int val1 = num2.charAt(i) - '0';
			int carry = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = num1.length() - 1; j >= 0; j--) {
				int val2 = num1.charAt(j) - '0';
				int prod = (val1 * val2) + carry;
				sb.append(prod % 10);
				carry = prod / 10;
			}
			if (carry != 0) {
				sb.append(carry);
			}
			sb = sb.reverse();
			for (int z = 0; z < num2.length() - i - 1; z++) {
				sb.append("0");
			}
			res = add(res, sb.toString());
		}

		int i = 0;
		while (i < res.length() && res.charAt(i) == 0) {
			i++;
		}
		if(i == res.length()){
			return "0";
		}
		return res.substring(i);

	}

	String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();

		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = val1 + val2 + carry;

			sb.append(sum % 10);
			carry = sum / 10;
			i--;
			j--;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

}
