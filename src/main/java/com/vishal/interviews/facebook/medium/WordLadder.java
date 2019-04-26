package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<>();
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("lot");
		dictionary.add("log");
		dictionary.add("cog");

		System.out.println(ladderLengthWithPatternMatching("hit", "cog", dictionary));
	}

	public static int ladderLengthWithPatternMatching(String beginWord, String endWord, List<String> wordList) {

		Map<String, List<String>> map = new HashMap<>();
		for (String w : wordList) {
			char[] arr = w.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char t = arr[i];
				arr[i] = '*';
				String newWord = String.valueOf(arr);
				if (!map.containsKey(newWord)) {
					map.put(newWord, new ArrayList<>());
				}
				map.get(newWord).add(w);
				arr[i] = t;
			}
		}
		

		int level = 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String curWord = queue.poll();

				char[] arr = curWord.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char t = arr[i];
					arr[i] = '*';
					List<String> possWords = map.get(String.valueOf(arr));					
					if (possWords != null) {
						for (String newWord : possWords) {
							if (curWord.equals(endWord)) {
								return level + 1;
							}
							if (!newWord.equals(curWord) && !visited.contains(newWord) && wordList.contains(newWord)) {
								queue.offer(newWord);
							}
						}
					}
					arr[i] = t;
				}
			}
			level++;
		}

		return 0;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int l = 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String curWord = queue.poll();

				char[] arr = curWord.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char t = arr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String newWord = String.valueOf(arr);
						if (curWord.equals(endWord)) {
							return l + 1;
						}
						if (!visited.contains(newWord) && wordList.contains(newWord)) {
							queue.offer(newWord);
						}
					}
					arr[i] = t;
				}
			}
			l++;
		}

		return -1;
	}

}

class WordNode {
	String word;
	WordNode parent;
}