package com.vishal.interviews.programcreek;

public class LengthofLastWord {

	public static void main(String[] args) {

		System.out.println(lengthOfLastWord("a "));
	}

	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int i = s.length() - 1;
		int cnt = 0;

		boolean flag = false;
		while (i >= 0) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				cnt++;
				flag = true;
			} else {
				if (flag) {
					break;
				}
			}
			i--;
		}
		return cnt;
	}

}
