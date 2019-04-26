package com.vishal.interviews.facebook.medium;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubsequence(String s, String t) {

		if (t == null || t.length() == 0) {
			return s == null || s.length() == 0;
		}
		
		if(s == null || s.length() == 0) {
            return true;
        }

		int tIndex = 0;
		int sIndex = 0;
		while (tIndex < t.length()) {
			char a = t.charAt(tIndex);
			char b = s.charAt(sIndex);

			if (a == b) {
				sIndex++;
				if (sIndex == s.length()) {
					return true;
				}
			}
			tIndex++;
		}
		return false;

	}
}
