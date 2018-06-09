package com.vishal.interviews.amazon.qae.easy;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {

	}

	public boolean isAnagram(String s, String t) {

		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

}
