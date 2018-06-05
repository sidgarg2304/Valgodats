package com.vishal.interviews.top100linkedquestions.medium;

import com.vishal.interviews.util.TrieNode;

public class ImplementTriePrefixTree {

	public static void main(String[] args) {

	}

	TrieNode root;

	public ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	public void insert(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}

		p.isWord = true;
		p.word = s;
	}
	
	public boolean search(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}

		return p.isWord;
	}
	
	public boolean startsWith(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}

		return true;
	}

}
