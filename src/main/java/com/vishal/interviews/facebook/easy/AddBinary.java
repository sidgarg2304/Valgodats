package com.vishal.interviews.facebook.easy;

/**
 * 67. Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 *
 */
public class AddBinary {

	public static void main(String[] args) {

	}

	public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();

		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;

		while (i >= 0 || j >= 0) {
			int v1 = i < 0 ? 0 : (a.charAt(i) - '0');
			int v2 = j < 0 ? 0 : (b.charAt(j) - '0');
			
			int sum = v1 + v2 + carry;
			
			sb.append(sum % 2);
			carry = sum /2;
			j--;
			i--;
		}
		
		if(carry != 0){
			sb.append(carry);
		}
		return sb.reverse().toString();
  }
}
