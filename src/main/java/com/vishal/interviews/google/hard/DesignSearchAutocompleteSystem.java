package com.vishal.interviews.google.hard;

import java.util.*;

public class DesignSearchAutocompleteSystem {

	public static void main(String[] args) {

	}

	TrieNode root;

	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();

		for (int i = 0; i < sentences.length; i++) {
			insert(sentences[i], times[i]);
		}
	}

	void insert(String s, int times) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = charToInd(s.charAt(i));
			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}
		p.times += times;
	}

	String curSent = "";

	List<String> input(char c) {
		List<String> res = new ArrayList<>();

		if (c == '#') {
			insert(curSent, 1);
			curSent = "";
		} else {
			curSent += c;
			List<Node> nodes = lookupSentencesWithPrefix(curSent);
			Collections.sort(nodes, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
			for (int i = 0; i < Math.min(nodes.size(), 3); i++) {
				res.add(nodes.get(i).sentence);
			}
		}

		return res;
	}

	List<Node> lookupSentencesWithPrefix(String s) {
		List<Node> res = new ArrayList<>();

		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = charToInd(s.charAt(i));
			if (p.children[pos] == null) {
				return res;
			}
			p = p.children[pos];
		}
		findSentences(p, s, res);
		return res;
	}

	void findSentences(TrieNode p, String s, List<Node> nodes) {
		if (p.times > 0) {
			nodes.add(new Node(s, p.times));
		}

		for (char c = 'a'; c <= 'z'; c++) {
			int pos = charToInd(c);
			if (p.children[pos] != null) {
				findSentences(p.children[pos], s + c, nodes);
			}
		}
		if (p.children[26] != null) {
			findSentences(p.children[26], s + ' ', nodes);
		}
	}

	int charToInd(char c) {
		return c == ' ' ? 27 : c - 'a';
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[27];
		int times;
	}

	class Node {
		String sentence;
		int times;

		Node(String s, int t) {
			this.sentence = s;
			this.times = t;
		}
	}

}
