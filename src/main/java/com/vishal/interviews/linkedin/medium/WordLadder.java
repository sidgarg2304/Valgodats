package com.vishal.interviews.linkedin.medium;

import java.util.*;

/**
 * 127. Word Ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class WordLadder {

	public static void main(String[] args) {

		Set<String> dictionary = new HashSet<>();
		dictionary.add("hit");
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("log");
		dictionary.add("lot");
		dictionary.add("cog");
		
		System.out.println(shortest(dictionary, "hit", "cog"));
	}
	
	static int shortest(Set<String> dictionary, String startWord, String endWord) {

		Queue<String> queue = new LinkedList<>();

		queue.offer(startWord);
		dictionary.remove(startWord);
		int level = 1;
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				System.out.println("level " + level + " for the word " + queue.peek());
				if (queue.peek().equals(endWord)) {
					return level;
				}

				char[] cur = queue.poll().toCharArray();

				for (int j = 0; j < cur.length; j++) {
					for (int a = 0; a < 26; a++) {
						char temp = cur[j];
						cur[j] = (char) ('a' + a);
						String newWord = String.valueOf(cur);
						if (dictionary.contains(newWord)) {
							queue.offer(newWord);
							dictionary.remove(newWord);
						}
						cur[j] = temp;

					}
				}
			}
			level++;
		}
		return -1;

	}

}
