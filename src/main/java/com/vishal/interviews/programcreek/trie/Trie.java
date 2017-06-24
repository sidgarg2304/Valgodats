package com.vishal.interviews.programcreek.trie;

import com.vishal.interviews.util.TrieNode;

public class Trie {

	TrieNode root;

	void addWord(String word) {

		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';

			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}

		p.word = word;
		p.isWord = true;
	}

	boolean search(String word) {

		return search(word, 0, root);
	}

	boolean search(String word, int p, TrieNode root) {

		if (root == null) {
			return false;
		}

		if (p == word.length()) {
			return root.isWord;
		}

		char c = word.charAt(p);
		if (c == '.') {
			for (TrieNode ch: root.children) {
				if (search(word, p + 1, ch)) {
					return true;
				}
			}
			return false;
		} else {
			int pos = c - 'a';
			return search(word, p + 1, root.children[pos]);
		}

	}
}
