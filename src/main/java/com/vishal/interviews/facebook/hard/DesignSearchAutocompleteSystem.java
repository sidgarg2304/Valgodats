package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

		TrieNode r = root;

		for (int i = 0; i < s.length(); i++) {
			int pos = charToPos(s.charAt(i));
			if (r.children[pos] == null) {
				r.children[pos] = new TrieNode();
			}
			r = r.children[pos];
		}
		r.times += times;
	}

	int charToPos(char c) {
		return c == ' ' ? 26 : c - 'a';
	}

	String curSent = "";

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();

		if (c == '#') {
			insert(curSent, 1);
			curSent = "";
			return res;
		}

		curSent += c;
		List<Node> nodes = lookup(curSent);
		Collections.sort(nodes, (a, b) -> a.times == b.times ? b.times - a.times : a.sentence.compareTo(b.sentence));
		for (int i = 0; i < Math.min(nodes.size(), 3); i++) {
			res.add(nodes.get(i).sentence);
		}

		return res;
	}

	List<Node> lookup(String s) {

		List<Node> res = new ArrayList<>();
		TrieNode r = root;
		for (int i = 0; i < s.length(); i++) {
			int pos = charToPos(s.charAt(i));
			if (r.children[pos] == null) {
				return res;
			}
			r = r.children[pos];
		}

		traverse(res, s, r);
		return res;
	}

	void traverse(List<Node> nodes, String s, TrieNode t) {
		if (t.times > 0) {
			nodes.add(new Node(s, t.times));
		}

		for (char c = 'a'; c <= 'z'; c++) {
			int pos = charToPos(c);
			if (t.children[pos] != null) {
				traverse(nodes, s + c, t.children[pos]);
			}
		}

		if (t.children[26] != null) {
			traverse(nodes, s + ' ', t.children[27]);
		}

	}

	class TrieNode {
		TrieNode[] children = new TrieNode[27];
		int times;
	}

	class Node {
		String sentence;
		int times;

		Node(String s, int t) {
			sentence = s;
			times = t;
		}
	}

}
