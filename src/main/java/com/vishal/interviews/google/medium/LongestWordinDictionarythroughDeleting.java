package com.vishal.interviews.google.medium;

import java.util.Collections;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 * 
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordinDictionarythroughDeleting {

	public static void main(String[] args) {

	}

	/**
	 * Short Java Solutions - Sorting Dictionary and Without Sorting
	 * 
	 * We sort the input dictionary by longest length and lexicography. Then, we
	 * iterate through the dictionary exactly once. In the process, the first
	 * dictionary word in the sorted dictionary which appears as a subsequence in
	 * the input string s must be the desired solution.
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public String findLongestWordUsingSorting(String s, List<String> d) {
		Collections.sort(d,
				(a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
		for (String dictWord : d) {
			int i = 0;
			for (char c : s.toCharArray())
				if (i < dictWord.length() && c == dictWord.charAt(i))
					i++;
			if (i == dictWord.length())
				return dictWord;
		}
		return "";
	}

	/**
	 * An alternate, more efficient solution which avoids sorting the dictionary:
	 * 
	 * Time Complexity: O(nk), where n is the length of string s and k is the
	 * number of words in the dictionary.
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public String findLongestWord(String s, List<String> d) {
		String longest = "";
		for (String dictWord : d) {
			int i = 0;
			for (char c : s.toCharArray()) {
				if (i < dictWord.length() && c == dictWord.charAt(i)) {
					i++;
				}
			}
			if (i == dictWord.length() && dictWord.length() >= longest.length()) {
				if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
					longest = dictWord;
				}
			}
		}
		return longest;
	}

	/**
	 * Easy Java Solution, isSubSequence 
	 * 
	 * Idea is sort the dictionary d first by
	 * length DESC then lexicographical ASC and test if p is SubSequence of s.
	 * The first match is the answer.
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public String findLongestWordEasy(String s, List<String> d) {
		if (s.length() == 0 || d.size() == 0)
			return "";

		Collections.sort(d, (a, b) -> {
			if (a.length() != b.length())
				return b.length() - a.length();
			return a.compareTo(b);
		});

		for (String p : d) {
			if (s.length() < p.length())
				continue;
			if (isSubSeq(s, p))
				return p;
		}

		return "";
	}

	private boolean isSubSeq(String s, String p) {
		int i = 0, j = 0;
		while (i < s.length() && j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return j == p.length();
	}

}
