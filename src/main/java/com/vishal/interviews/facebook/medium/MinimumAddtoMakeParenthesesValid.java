package com.vishal.interviews.facebook.medium;

public class MinimumAddtoMakeParenthesesValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minAddToMakeValid(String S) {

		if (S == null || S.length() == 0) {
			return 0;
		}
		int leftCnt = 0;
		int rightCnt = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				leftCnt++;
			} else {
				if (leftCnt > 0) {
					leftCnt--;
				} else {
					rightCnt++;
				}
			}
		}
		return leftCnt + rightCnt;
	}

}
