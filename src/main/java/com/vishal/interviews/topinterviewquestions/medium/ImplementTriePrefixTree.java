package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.TrieNode;

public class ImplementTriePrefixTree {

	public static void main(String[] args) {

	}

	TrieNode root;

	public ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	void insert(String s) {
		TrieNode p = root;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int pos = c - 'a';

			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}

			p = p.children[pos];
		}
		p.isWord = true;
		p.word = s;
	}

	boolean search(String s) {
		TrieNode p = root;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int pos = c - 'a';

			if (p.children[pos] == null) {
				return false;
			}

			p = p.children[pos];
		}
		return p.word.equals(s);
	}

	boolean startsWith(String s) {
		TrieNode p = root;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int pos = c - 'a';

			if (p.children[pos] == null) {
				return false;
			}

			p = p.children[pos];
		}
		return true;
	}
}
