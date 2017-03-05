package com.vishal.interviews.google.medium;

import java.util.Stack;

/**
 * 402. Remove K Digits
 * 
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * 
 * The given num does not contain any leading zero.
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * 
 * Output: "1219"
 * 
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * 
 * Output: "200"
 * 
 * Explanation: Remove the leading 1 and the number is 200. Note that the output
 * must not contain leading zeroes.
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * 
 * Output: "0"
 * 
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0
 */
public class RemoveKDigits {

	public static void main(String[] args) {

	}

	public String removeKdigitsGreedy(String num, int k) {
		int digits = num.length() - k;
		char[] stk = new char[num.length()];
		int top = 0;
		// k keeps track of how many characters we can remove
		// if the previous character in stk is larger than the current one
		// then removing it will get a smaller number
		// but we can only do so when k is larger than 0
		for (int i = 0; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (top > 0 && stk[top - 1] > c && k > 0) {
				top -= 1;
				k -= 1;
			}
			stk[top++] = c;
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stk[idx] == '0')
			idx++;
		return idx == digits ? "0" : new String(stk, idx, digits - idx);
	}

	/**
	 * Straightforward Java Solution Using Stack
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	public String removeKdigitsStraightforwardUsingStack(String num, int k) {
		int len = num.length();
		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			// whenever meet a digit which is less than the previous digit, discard
			// the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

	/**
	 * 6ms Java Solution with detailed comment
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	public String removeKdigits6msSolution(String num, int k) {
		int remain = num.length() - k;
		char[] numArray = num.toCharArray(), res = new char[remain];
		int index = 0;
		for (int i = 0; i < numArray.length; i++) {
			// (1) (n - i > remain - index): have enough remaining digits to be
			// compared
			// (2) (res[index - 1] > nums[i]): at this time, the (index-1) is the
			// newest added digit,
			// compare this digit with the current num, if the res is greater and
			// you have enough
			// remaining digits to be compared, decrease the index(it ensures that
			// the future added digit is
			// always smaller than before and the size is remain) until get the
			// right and 'safe' position
			while ((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1]))
				index--;
			if (index < remain)
				res[index++] = numArray[i];
		}

		// check leading zeroes
		index = -1;
		while (++index < remain) {
			if (res[index] != '0')
				break;
		}
		String s = new String(res).substring(index);

		return s.length() == 0 ? "0" : s;
	}

}
