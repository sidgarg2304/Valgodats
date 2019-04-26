package com.vishal.interviews.uber.medium;

public class ImplementTriePrefixTree {

	public static void main(String[] args) {

	}

	TrieNode root;

	/** Initialize your data structure here. */
	public ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}
		p.isWord = true;

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}
		return p.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for (int i = 0; i < prefix.length(); i++) {
			int pos = prefix.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}
		return true;
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isWord;
	}

}
