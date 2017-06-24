package com.vishal.interviews.programcreek;

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
		int m = s.length();
		int n = t.length();

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			char c = s.charAt(i);
			char p = t.charAt(j);

			if (c == p) {
				i++;
				j++;
			} else {
				diff++;
				if (diff > 1) {
					return false;
				}

				if (m > n) {
					i++;
				} else if (n > m) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		if (i < m || j < n) {
			diff++;
		}

		return diff == 1;
	}

}
