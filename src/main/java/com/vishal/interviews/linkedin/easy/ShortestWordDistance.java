package com.vishal.interviews.linkedin.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 243. Shortest Word Distance
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * For example,
 * 
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * 
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note:
 * 
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 */
public class ShortestWordDistance {

	public static void main(String[] args) {

	}

	public int shortestDistanceClean(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				p1 = i;

			if (words[i].equals(word2))
				p2 = i;

			if (p1 != -1 && p2 != -1)
				min = Math.min(min, Math.abs(p1 - p2));
		}

		return min;
	}

	public int shortestDistanceSingleIndex(String[] words, String word1, String word2) {
		int index = -1, minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && !words[index].equals(words[i])) {
					minDistance = Math.min(minDistance, i - index);
				}
				index = i;
			}
		}
		return minDistance;
	}

	/**
	 * Java solution using minimum difference between 2 sorted arrays
	 * 
	 * Creating two lists storing indexes of each occurrence of the word1 and
	 * word2 accordingly. After that finding minimum difference between two
	 * elements from these lists.
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestDistanceUsingMinDistBetweenTwoArrays(String[] words, String word1, String word2) {
		List<Integer> w1occ = new ArrayList<Integer>();
		List<Integer> w2occ = new ArrayList<Integer>();

		for (int i = 0; i < words.length; ++i) {
			if (words[i].equals(word1)) {
				w1occ.add(i);
			}
			if (words[i].equals(word2)) {
				w2occ.add(i);
			}
		}

		int min = words.length;
		int p1 = 0;
		int p2 = 0;
		while (p1 < w1occ.size() && p2 < w2occ.size()) {
			min = Math.min(Math.abs(w1occ.get(p1) - w2occ.get(p2)), min);
			if (w1occ.get(p1) < w2occ.get(p2)) {
				p1++;
			} else
				p2++;
		}
		return min;
	}

	/**
	 * Java Solution with one for loop
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestDistanceWithOneForLoop(String[] words, String word1, String word2) {
		int ret = Integer.MAX_VALUE, index1 = -1, index2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				index1 = i;
				if (index2 >= 0)
					ret = Math.min(ret, i - index2);
			} else if (words[i].equals(word2)) {
				index2 = i;
				if (index1 >= 0)
					ret = Math.min(ret, i - index1);
			}
		}
		return ret;
	}
}
