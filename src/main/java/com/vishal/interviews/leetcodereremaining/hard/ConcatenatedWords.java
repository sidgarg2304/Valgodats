package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;

/**
 * 472. Concatenated Words
 * 
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.

 *
 */
public class ConcatenatedWords {

	public static void main(String[] args) {

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> res = new ArrayList<>();

		if (words == null || words.length == 0) {
			return res;
		}

		Set<String> preWords = new HashSet<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		for (int i = 0; i < words.length; i++) {
			if (canSplit(words[i], preWords)) {
				res.add(words[i]);
			}
			preWords.add(words[i]);
		}
		return res;
	}

	boolean canSplit(String word, Set<String> dict) {
		if (dict.isEmpty()) {
			return false;
		}

		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i < word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

}
