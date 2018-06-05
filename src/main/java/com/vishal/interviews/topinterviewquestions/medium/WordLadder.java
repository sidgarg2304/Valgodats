package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();

		beginSet.add(beginWord);
		endSet.add(endWord);

		Set<String> visited = new HashSet<>();
		int level = 1;
		while (!beginSet.isEmpty() || !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> temp = beginSet;
				beginSet = endSet;
				endSet = temp;
			}

			Set<String> children = new HashSet<>();
			for (String cur : beginSet) {
				char[] arr = cur.toCharArray();

				for (int i = 0; i < arr.length; i++) {
					char t = arr[i];
					for (char a = 'a'; a <= 'z'; a++) {
						arr[i] = a;

						String newStr = String.valueOf(arr);
						if (endSet.contains(newStr)) {
							return level + 1;
						}
						if (!visited.contains(newStr) && wordList.contains(newStr)) {
							children.add(newStr);
							visited.add(newStr);
						}
						arr[i] = t;
					}

				}
			}
			beginSet = children;
			level++;
		}
		return -1;
	}

}
