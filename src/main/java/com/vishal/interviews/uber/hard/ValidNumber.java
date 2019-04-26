package com.vishal.interviews.uber.hard;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isNumber(String s) {

		if (s == null || s.length() == 0) {
			return false;
		}
		s = s.trim();
		
		boolean eSeen = false;
		boolean numSeen = false;
		boolean numAfterESeen = true;
		boolean pointSeen = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				numSeen = true;
				numAfterESeen = true;
			} else if (c == '.') {
				if (pointSeen || eSeen) {
					return false;
				}
				pointSeen = true;
			} else if (c == 'e') {
				if (eSeen || !numAfterESeen) {
					return false;
				}
				eSeen = true;
				numAfterESeen = false;
			} else if (c == '+' || c == '-') {
				if (i > 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return numSeen && numAfterESeen;
	}

}
