package com.vishal.interviews.facebook.easy;

public class VerifyinganAlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAlienSorted(String[] words, String order) {

		int[] index = new int[26];

		for (int i = 0; i < order.length(); i++) {
			index[order.charAt(i) - 'a'] = i;
		}

		Outer: for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1];
			String cur = words[i];

			for (int k = 0; k < Math.min(prev.length(), cur.length()); k++) {
				if (prev.charAt(k) != cur.charAt(k)) {
					if (index[prev.charAt(k) - 'a'] > index[cur.charAt(k) - 'a']) {
						return false;
					}
					continue Outer;
				}
			}
			
			if(prev.length() > cur.length()){
				return false;
			}
		}
		return true;
	}

}
