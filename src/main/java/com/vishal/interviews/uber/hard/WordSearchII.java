package com.vishal.interviews.uber.hard;

import java.util.*;

public class WordSearchII {

	public static void main(String[] args) {

	}

	TrieNode root = new TrieNode();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();

		for (String w : words) {
			insert(w);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, "", i, j, visited, res);
			}
		}
		return res;

	}

	void dfs(char[][] board, String cur, int i, int j, boolean[][] visited, List<String> res) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}

		cur += board[i][j];

		if (!startsWith(cur)) {
			return;
		}

		if (search(cur) && !res.contains(cur)) {
			res.add(cur);
		}

		visited[i][j] = true;
		dfs(board, cur, i - 1, j, visited, res);
		dfs(board, cur, i + 1, j, visited, res);
		dfs(board, cur, i, j - 1, visited, res);
		dfs(board, cur, i, j + 1, visited, res);
		visited[i][j] = false;

	}

	void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (p.children[pos] == null) {
				p.children[pos] = new TrieNode();
			}
			p = p.children[pos];
		}
		p.word = word;
	}

	boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}
		return word.equals(p.word);
	}

	boolean startsWith(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (p.children[pos] == null) {
				return false;
			}
			p = p.children[pos];
		}
		return true;
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

}
