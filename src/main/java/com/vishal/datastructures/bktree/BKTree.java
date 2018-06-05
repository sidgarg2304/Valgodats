package com.vishal.datastructures.bktree;

import java.util.*;

/**
 * https://nullwords.wordpress.com/2013/03/13/the-bk-tree-a-data-structure-for-spell-checking/
 *
 */
public class BKTree {

	public static void main(String[] args) {

		
	}

	BKTreeNode root;

	public void addWord(String word) {
		if (root == null) {
			root = new BKTreeNode(word);
			return;
		}

		BKTreeNode cur = root;
		int dist = getDistance(cur.word, word);
		while (cur.children.containsKey(dist)) {
			cur = cur.children.get(dist);
			dist = getDistance(cur.word, word);
		}

		cur.addChild(word, dist);

	}

	public List<String> search(String word, int d) {
		List<String> res = new ArrayList<>();

		addWords(root, word, d, res);
		return res;
	}

	void addWords(BKTreeNode cur, String word, int d, List<String> res) {

		int dist = getDistance(cur.word, word);
		if (dist <= d) {
			res.add(cur.word);
		}

		int l = dist - 1;
		int h = dist + 1;

		for (int k : cur.children.keySet()) {
			if (k >= l && k <= h) {
				addWords(cur.children.get(k), word, d, res);
			}
		}
	}

	int getDistance(String word1, String word2) {
		return 1;
	}

}
