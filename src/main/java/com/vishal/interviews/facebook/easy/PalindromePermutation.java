package com.vishal.interviews.facebook.easy;

import java.util.*;

public class PalindromePermutation {

	public static void main(String[] args) {

	}

	public boolean canPermutePalindrome(String s) {

		if(s == null){
			return true;
		}
		Set<Character> set = new HashSet<>();

		for (char c : s.toCharArray()) {
			if (!set.add(c)) {
				set.remove(c);
			}
		}
		return set.size() <= 1;
	}

}
