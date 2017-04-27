package com.vishal.interviews.linkedin.medium;

/**
 * 245. Shortest Word Distance III
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * For example,
 * 
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * 
 * Given word1 = "makes", word2 = "makes", return 3.
 * 
 * Note:
 * 
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {

	public static void main(String[] args) {

	}

	/**
	 * Solution 1 ... Java "short"
	 * 
	 * i1 and i2 are the indexes where word1 and word2 were last seen. Except if
	 * they're the same word, then i1 is the previous index.
	 * 
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistanceShort(String[] words, String word1, String word2) {
		long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				i1 = i;
			if (words[i].equals(word2)) {
				if (word1.equals(word2))
					i1 = i2;
				i2 = i;
			}
			dist = Math.min(dist, Math.abs(i1 - i2));
		}
		return (int) dist;
	}

	/**
	 * Solution 2 ... Java "fast"
	 * 
	 * Same as solution 1, but minimizing the number of string comparisons.
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistanceFast(String[] words, String word1, String word2) {
		long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
		boolean same = word1.equals(word2);
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (same) {
					i1 = i2;
					i2 = i;
				} else {
					i1 = i;
				}
			} else if (words[i].equals(word2)) {
				i2 = i;
			}
			dist = Math.min(dist, Math.abs(i1 - i2));
		}
		return (int) dist;
	}

	public int shortestWordDistanceISolution(String[] words, String word1, String word2) {
		int index = -1;
		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && !words[index].equals(words[i])) {
					min = Math.min(i - index, min);
				}
				index = i;
			}
		}
		return min;
	}

	public int shortestWordDistanceIIISolution(String[] words, String word1, String word2) {
		int index = -1;
		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
					min = Math.min(i - index, min);
				}
				index = i;
			}
		}
		return min;
	}

	public int shortestWordDistanceConcise(String[] words, String word1, String word2) {
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (word1.equals(word2)) {
					if (p1 != -1 && i - p1 < min) {
						min = i - p1;
					}
					p1 = i;
				} else {
					p1 = i;
					if (p2 != -1 && p1 - p2 < min) {
						min = p1 - p2;
					}
				}
			} else if (words[i].equals(word2)) {
				p2 = i;
				if (p1 != -1 && p2 - p1 < min) {
					min = p2 - p1;
				}
			}
		}
		return min;
	}

	/**
	 * Do we prefer cleaner code or faster solution if we cannot achieve both
	 * with one solution? (280ms java solution)
	 * 
	 * In this post https://discuss.leetcode.com/topic/20887/12-16-lines-java-c,
	 * Stefan's solutions are very concise. However, I found that the following
	 * solution only runs 280ms on OJ, which beats all other java solutions so
	 * far. It is fast because it only checks word1.equals(word2) once at the
	 * beginning. I wonder in real practice, do we prefer cleaner code or faster
	 * solution if we cannot achieve both with one solution? I hope people who
	 * have more industrial experience could give some adivce.
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistanceClean(String[] words, String word1, String word2) {
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;

		if (word1.equals(word2)) {
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i])) {
					if (p1 == -1) {
						p1 = i;
					} else {
						min = Math.min(min, i - p1);
						p1 = i;
					}
				}
			}
		} else {
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i])) {
					p1 = i;
				}
				if (word2.equals(words[i])) {
					p2 = i;
				}
				if (p1 != -1 && p2 != -1) {
					min = Math.min(min, Math.abs(p1 - p2));
				}
			}
		}
		return min;
	}

	/**
	 * Approach: two case:
	 * 
	 * 1: word1 != word2 , it is simple, some are using i1 = -1, i2 = -1 to
	 * check, here I used the distance. Because when checking the min distance, I
	 * dont want fake min distance in my result, so I try to expand the initial
	 * distance of i1 and i2 be greater than words.length, (but we also cannot
	 * use i1 = -1 and i2 = words.length, because the target word might give i2 =
	 * 0, then mindistance is 1, which is also fake)
	 * 
	 * 2: word1 == word2, the question becomes how to find the min distance of
	 * the indices of a single word. Such as "make" has indices of 0, 3,
	 * 5,xxxxx...how to find the min distance. Just use use current i minus last
	 * index and keep the global min value.
	 * 
	 * If you like this solution, please thumb up : )
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistance3msSolution(String[] words, String word1, String word2) {
		if (words == null || words.length == 0)
			return 0;
		int i1 = -words.length; // here is to guarantee mindistance will be
										// greater than the word.length
		int i2 = words.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (!word1.equals(word2)) {
				if (words[i].equals(word1))
					i1 = i;
				if (words[i].equals(word2))
					i2 = i;
				min = Math.min(min, Math.abs(i1 - i2)); // so we don't have to check
																	 // if (i1 != -1 && i2 != -1
																	 // in other solutions)
			} else {
				if (words[i].equals(word1)) { // this the question on how to find
														// the shortest distance of indices of
														// the word
					min = Math.min(min, Math.abs(i - i1)); // you can change to i -
																		// i1, it is also correct
					i1 = i; // update the i1 with current i for incoming distance
							  // checking
				}
			}
		}
		return min;
	}
}
