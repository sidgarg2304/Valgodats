package com.vishal.interviews.google.hard;

import java.util.HashMap;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {

	}

	/**
	 * Simple O(n) java solution - easily extend to k characters
	 * 
	 * The main idea is to maintain a sliding window with 2 unique characters.
	 * The key is to store the last occurrence of each character as the value in
	 * the hashmap. This way, whenever the size of the hashmap exceeds 2, we can
	 * traverse through the map to find the character with the left most index,
	 * and remove 1 character from our map. Since the range of characters is
	 * constrained, we should be able to find the left most index in constant
	 * time.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinctUsingMap(String s) {
		if (s.length() < 1)
			return 0;
		HashMap<Character, Integer> index = new HashMap<Character, Integer>();
		int lo = 0;
		int hi = 0;
		int maxLength = 0;
		while (hi < s.length()) {
			if (index.size() <= 2) {
				char c = s.charAt(hi);
				index.put(c, hi);
				hi++;
			}
			if (index.size() > 2) {
				int leftMost = s.length();
				for (int i : index.values()) {
					leftMost = Math.min(leftMost, i);
				}
				char c = s.charAt(leftMost);
				index.remove(c);
				lo = leftMost + 1;
			}
			maxLength = Math.max(maxLength, hi - lo);
		}
		return maxLength;
	}

	/**
	 * Clean 11 lines AC answer, O(1) space, O(n) time.
	 * 
	 * I submitted this solution two months ago and I can't even remember whether
	 * I wrote myself or copied from others. I don't understand it now but find
	 * it AC and much shorter than other posts here.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinctClear(String s) {
		int i = 0, j = -1;
		int maxLen = 0;
		char[] sArr = s.toCharArray();
		for (int k = 1; k < sArr.length; k++) {
			if (sArr[k] == sArr[k - 1])
				continue;
			if (j > -1 && sArr[k] != sArr[j]) {
				maxLen = Math.max(maxLen, k - i);
				i = j + 1;
			}
			j = k - 1;
		}
		return maxLen > (s.length() - i) ? maxLen : s.length() - i;
	}

	/**
	 * O(n) time and O(1) space solution without using HashMap The basic idea is
	 * to store the two characters and keep track of last indices of them. When
	 * third character comes, we set the start_point to 1 + smaller index, in
	 * that way we can always throw away one character. And the length is given
	 * by current_index - start_point.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinctWithoutHashMap(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char charOne = s.charAt(0);
		int charOneIndex = 0;
		while (charOneIndex + 1 < s.length() && s.charAt(charOneIndex + 1) == charOne) { // in
																													// case
																													// of
																													// "aaa"
			charOneIndex++;
		}
		if (charOneIndex == s.length() - 1) {
			return s.length();
		}
		char charTwo = s.charAt(charOneIndex + 1);
		int charTwoIndex = charOneIndex + 1;
		int startIndex = 0;
		int maxLen = charTwoIndex + 1;
		for (int i = charTwoIndex + 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != charOne && c != charTwo) { // new character comes, update
															// index and char
				startIndex = Math.min(charOneIndex, charTwoIndex) + 1;
				charOneIndex = Math.max(charOneIndex, charTwoIndex);
				charOne = charOneIndex == charTwoIndex ? charTwo : charOne;
				charTwoIndex = i;
				charTwo = c;
			} else { // same character comes, update max length
				if (c == charOne) {
					charOneIndex = i;
				} else {
					charTwoIndex = i;
				}
				if (i - startIndex + 1 > maxLen) {
					maxLen = i - startIndex + 1;
				}
			}
		}
		return maxLen;
	}
}
