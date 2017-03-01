package com.vishal.interviews.google.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 318. Maximum Product of Word Lengths
 * 
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1:
 * 
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * 
 * Return 16
 * 
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * 
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * 
 * Return 4
 * 
 * The two words can be "ab", "cd".
 * 
 * Example 3:
 * 
 * Given ["a", "aa", "aaa", "aaaa"]
 * 
 * Return 0
 * 
 * No such pair of words.
 */
public class MaximumProductofWordLengths {

	public static void main(String[] args) {

	}

	public static int maxProductEasy(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int len = words.length;
		int[] value = new int[len];
		for (int i = 0; i < len; i++) {
			String tmp = words[i];
			value[i] = 0;
			for (int j = 0; j < tmp.length(); j++) {
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}
		int maxProduct = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
					maxProduct = words[i].length() * words[j].length();
			}
		return maxProduct;
	}

	public int maxProductAC(String[] words) {
		int max = 0;

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return b.length() - a.length();
			}
		});

		int[] masks = new int[words.length]; // alphabet masks

		for (int i = 0; i < masks.length; i++) {
			for (char c : words[i].toCharArray()) {
				masks[i] |= 1 << (c - 'a');
			}
		}

		for (int i = 0; i < masks.length; i++) {
			if (words[i].length() * words[i].length() <= max)
				break; // prunning
			for (int j = i + 1; j < masks.length; j++) {
				if ((masks[i] & masks[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
					break; // prunning
				}
			}
		}

		return max;
	}

	/**
	 * Pre-process the word, use bit to represent the words. We can do this
	 * because we only need to compare if two words contains the same characters.
	 * 
	 * @param words
	 * @return
	 */
	public int maxProductUsingBitManipulation(String[] words) {
		int max = 0;
		int[] bytes = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int val = 0;
			for (int j = 0; j < words[i].length(); j++) {
				val |= 1 << (words[i].charAt(j) - 'a');
			}
			bytes[i] = val;
		}
		for (int i = 0; i < bytes.length; i++) {
			for (int j = i + 1; j < bytes.length; j++) {
				if ((bytes[i] & bytes[j]) == 0)
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}

	/**
	 * @param words
	 * @return
	 * 
	 * 		  The soultion is calcuated by doing a product of the length of each
	 *         string to every other string. Anyhow the constraint given is that
	 *         the two strings should not have any common character. This is
	 *         taken care by creating a unique number for every string. Image a
	 *         an 32 bit integer where 0 bit corresponds to 'a', 1st bit
	 *         corresponds to 'b' and so on.
	 * 
	 *         Thus if two strings contain the same character when we do and
	 *         "AND" the result will not be zero and we can ignore that case.
	 */
	public int maxProduct(String[] words) {
		int[] checker = new int[words.length];
		int max = 0;
		// populating the checker array with their respective numbers
		for (int i = 0; i < checker.length; i++) {
			int num = 0;
			for (int j = 0; j < words[i].length(); j++) {
				num |= 1 << (words[i].charAt(j) - 'a');
			}
			checker[i] = num;
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((checker[i] & checker[j]) == 0) // checking if the two strings
																// have common character
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}
}
