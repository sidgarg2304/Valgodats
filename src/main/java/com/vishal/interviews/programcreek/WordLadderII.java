package com.vishal.interviews.programcreek;

import java.util.*;

public class WordLadderII {

	public static void main(String[] args) {

		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		wordList.add("dog");

		System.out.println(findLadders("hit", "cog", wordList));

	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<List<String>> res = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(beginWord, null, 1));

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		Set<String> unVisited = new HashSet<>();
		unVisited.addAll(wordList);

		int minSteps = 0;
		while (!queue.isEmpty()) {
			int s = queue.size();
			for (int k = 0; k < s; k++) {
				Node curNode = queue.poll();
				String cur = curNode.word;
				System.out.println("processing " + cur);

				if (cur.equals(endWord)) {
					if (minSteps == 0) {
						minSteps = curNode.numSteps;
					}
					if (curNode.numSteps == minSteps) {
						List<String> curRes = new ArrayList<>();
						Node t = curNode;
						while (t != null) {
							curRes.add(0, t.word);
							t = t.parent;
						}

						res.add(curRes);
						continue;
					}
				}
				char[] arr = cur.toCharArray();

				for (int i = 0; i < arr.length; i++) {
					char t = arr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String newWord = String.valueOf(arr);
						if (unVisited.contains(newWord)) {
							visited.add(newWord);
							queue.offer(new Node(newWord, curNode, curNode.numSteps + 1));
						}
						arr[i] = t;
					}
				}
			}
			unVisited.removeAll(visited);
		}
		return res;
	}
}

class Node {
	Node parent;
	String word;
	int numSteps;

	public Node(String word, Node parent, int numSteps) {
		this.word = word;
		this.parent = parent;
		this.numSteps = numSteps;
	}
}
