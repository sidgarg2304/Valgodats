package com.vishal.datastructures.trie;

public class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (p.childern[c - 'a'] == null) {
				p.childern[c - 'a'] = new TrieNode();
			}
			p = p.childern[c - 'a'];
		}
		p.word = word;
	}

	public boolean search(String word) {

		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (p.childern[c - 'a'] == null) {
				return false;
			}
			p = p.childern[c - 'a'];
		}
		return p.word.equals(word);
	}
}
