package com.vishal.interviews.uber.medium;

public class OneEditDistance {

	public static void main(String[] args) {

	}

	public boolean isOneEditDistance(String s, String t) {

		if (s == null && t == null) {
			return false;
		}

		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}

		int diff = 0;

		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			char a = s.charAt(i);
			char b = t.charAt(j);

			if (a == b) {
				i++;
            j++;
				continue;
			}

			if (diff > 1) {
				return false;
			}

			diff++;
			if (s.length() > t.length()) {
				i++;
			} else if (s.length() < t.length()) {
				j++;
			} else {
				i++;
				j++;
			}
		}

		if (i < s.length() || j < t.length()) {
			diff++;
		}

		return diff == 1;
	}

}
