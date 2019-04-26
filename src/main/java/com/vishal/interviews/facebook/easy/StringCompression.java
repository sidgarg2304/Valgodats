package com.vishal.interviews.facebook.easy;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compress(char[] chars) {
		int cnt = 1;

		int c = 0;
		for (int i = 1; i <= chars.length; i++) {

			if (i < chars.length && chars[i] == chars[i - 1]) {
				cnt++;
			} else {
				chars[c++] = chars[i - 1];

				if (cnt > 1) {
					char[] digits = String.valueOf(cnt).toCharArray();
					for (int d = 0; d < digits.length; d++) {
						chars[c++] = digits[d];
					}
				}
				cnt = 1;
			}
		}
		return c;
	}

}
