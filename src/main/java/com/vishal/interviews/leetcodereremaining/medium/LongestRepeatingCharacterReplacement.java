package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 424. Longest Repeating Character Replacement
 * 
 * Given a string that consists of only upper case English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 *
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {

	}

	public int characterReplacement(String s, int k) {

		int[] count = new int[26];
		int res = 1;
		int st = 0;		
		int maxCharCount = 0;
		for (int i = 0; i < s.length(); i++) {
			maxCharCount = Math.max(maxCharCount, ++count[s.charAt(i) - 'a']);

			while ((i - st + 1 - maxCharCount) > k) {
				count[s.charAt(st) - 'a']--;
				maxCharCount = Math.max(maxCharCount, count[s.charAt(st) - 'a']);
				st++;
			}

			res = Math.max(res, (i - st + 1));
		}

		return res;
	}

}
