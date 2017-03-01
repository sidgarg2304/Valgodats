package com.vishal.interviews.google.easy;

/**
 * 415
 * 
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * 
 * Both num1 and num2 contains only digits 0-9.
 * 
 * Both num1 and num2 does not contain any leading zero.
 * 
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * @author vkotha
 *
 */
public class AddStrings {

	public static void main(String[] args) {

	}

	/**
	 * Straightforward Java 8 main lines 25ms
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
	}

	/**
	 * https://ratchapong.com/algorithm-practice/leetcode/add-strings [Full
	 * Solutions]
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStringsSimple(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		char[] num1Array = num1.toCharArray();
		char[] num2Array = num2.toCharArray();
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry == 1) {
			int a = i >= 0 ? (num1Array[i--] - '0') : 0;
			int b = j >= 0 ? (num2Array[j--] - '0') : 0;
			int sum = a + b + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		return sb.toString();
	}

	public String addStringsEasy(String num1, String num2) {
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;

		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0;
		while (len1 >= 0 || len2 >= 0) {
			int first = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
			int second = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
			sum = carry + first + second;
			if (sum <= 9) {
				sb.insert(0, sum);
				sum = 0;
				carry = 0;
			} else {
				sb.insert(0, sum % 10);
				sum = 0;
				carry = 1;
			}
			len1--;
			len2--;
		}
		if (carry == 1)
			sb.insert(0, "1");
		return sb.toString();
	}

}
