package com.vishal.interviews.leetcodereremaining.medium;

public class ComplexNumberMultiplication {

	public static void main(String[] args) {

	}

	public String complexNumberMultiply(String a, String b) {

		int[] val1 = getValue(a);
		int[] val2 = getValue(b);

		int real = val1[0] * val2[0] - val1[1] * val2[1];
		int imag = val1[0] * val2[1] + val1[1] * val2[0];

		return real + "+" + imag + "i";
	}

	int[] getValue(String a) {
		int[] res = new int[2];

		String[] s = a.split("\\+");
		res[0] = Integer.parseInt(s[0]);

		res[1] = Integer.parseInt(s[1].replace("i", ""));
		return res;
	}

}
