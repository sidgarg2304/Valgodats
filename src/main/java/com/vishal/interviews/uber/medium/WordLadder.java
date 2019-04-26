package com.vishal.interviews.uber.medium;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Map<String, List<String>> map = new HashMap<>();
		for (String w : wordList) {
			char[] arr = w.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				arr[i] = '*';
				String pattern = String.valueOf(arr);
				if (!map.containsKey(pattern)) {
					map.put(pattern, new ArrayList<>());
				}
				map.get(pattern).add(w);
				arr[i] = temp;
			}
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String curWord = queue.poll();

				if (curWord.equals(endWord)) {
					return level;
				}

				char[] arr = curWord.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					arr[i] = '*';
					String newWord = String.valueOf(arr);
					if (map.containsKey(newWord)) {
						List<String> neList = map.get(newWord);
						for (String ne : neList) {
							if (!visited.contains(ne)) {
								visited.add(ne);
								queue.offer(ne);
							}
						}
					}
					arr[i] = temp;
				}
			}
			level++;
		}

		return 0;
	}

}
