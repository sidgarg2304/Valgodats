package com.vishal.interviews.uber.hard;

import java.util.*;

public class WordLadderII {

	public static void main(String[] args) {

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();

		int minDist = Integer.MAX_VALUE;
		Map<String, List<String>> patternMap = new HashMap<>();
		for (String w : wordList) {
			char[] arr = w.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				arr[i] = '*';
				String pattern = String.valueOf(arr);
				if (!patternMap.containsKey(pattern)) {
					patternMap.put(pattern, new ArrayList<>());
				}
				patternMap.get(pattern).add(w);
				arr[i] = temp;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> unVisited = new HashSet<>();
		unVisited.addAll(wordList);

		visited.add(beginWord);
		queue.offer(new Node(beginWord, null));

		int dist = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Node cur = queue.poll();

				if (cur.word == endWord) {
					if (dist < minDist) {
						dist = minDist;
					}

					if (dist == minDist) {
						List<String> temp = new ArrayList<>();
						Node p = cur;
						while (p != null) {
							temp.add(0, p.word);
							p = p.parent;
						}
						res.add(temp);
					}
				} else {
					char[] arr = cur.word.toCharArray();

					for (int i = 0; i < arr.length; i++) {
						char temp = arr[i];
						arr[i] = '*';
						String pattern = String.valueOf(arr);
						if (patternMap.containsKey(pattern)) {
							List<String> dictWords = patternMap.get(pattern);							
							for (String ne : dictWords) {
								if (unVisited.contains(ne)) {
									visited.add(ne);
									queue.offer(new Node(ne, cur));
								}
							}
						}
						arr[i] = temp;
					}
				}
			}
			unVisited.removeAll(visited);
			dist++;
		}

		return res;
	}

	class Node {
		String word;
		int dist;
		Node parent;

		Node(String word, Node parent) {
			this.parent = parent;
			this.word = word;
		}
	}

}
