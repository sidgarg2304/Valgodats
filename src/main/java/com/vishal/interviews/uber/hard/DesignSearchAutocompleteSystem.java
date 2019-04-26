package com.vishal.interviews.uber.hard;

import java.util.*;

import jdk.nashorn.internal.runtime.regexp.joni.ast.Node;

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

	void insert(String word, int times) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = charToPos(word.charAt(i));
			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}

		p.times += times;
	}

	String cur = "";

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if (c == '#') {
			insert(cur, 1);
			return res;
		}

		cur += c;
		List<Node> nodes = findNodes(cur);
		Collections.sort(nodes, (a, b) -> b.times - a.times);

		for (int i = 0; i < Math.min(nodes.size(), 3); i++) {
			res.add(nodes.get(i).sentence);
		}

		return res;
	}

	List<Node> findNodes(String prefix) {
		List<Node> nodes = new ArrayList<>();
		TrieNode p = root;
		for (int i = 0; i < prefix.length(); i++) {
			int pos = charToPos(prefix.charAt(i));
			if (p.children[pos] == null) {
				return nodes;
			}
			p = p.children[pos];
		}
		updateNodes(p, prefix, nodes);
		
		return nodes;
	}

	void updateNodes(TrieNode t, String word, List<Node> nodes) {
		if (t.times > 0) {
			nodes.add(new Node(word, t.times));
		}

		for(char a = 'a' ; a<= 'z'; a++) {
			int pos = charToPos(a);
			if(t.children[pos] != null) {
				updateNodes(t.children[pos], word + a, nodes);
			}
		}
		
		if(t.children[26] != null) {
			updateNodes(t.children[26], word + ' ', nodes);
		}
	}

	int charToPos(char c) {
		return c == ' ' ? 26 : c - 'a';
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
