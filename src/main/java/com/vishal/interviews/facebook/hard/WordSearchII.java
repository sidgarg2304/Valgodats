package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.List;


public class WordSearchII {

	Trie trie = new Trie();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();

		for (String word : words) {
			trie.insert(word);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, 0, "", i, j, visited, res);
			}
		}

		return res;
	}

	void dfs(char[][] board, int pos, String cur, int i, int j, boolean[][] visited, List<String> res) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}

		cur += board[i][j];
		if (!trie.startsWith(cur)) {
			return;
		}

		if (trie.search(cur)) {
			if (!res.contains(cur)) {
				res.add(cur);
			}
		}

		visited[i][j] = true;
		dfs(board, pos + 1, cur, i + 1, j, visited, res);
		dfs(board, pos + 1, cur, i - 1, j, visited, res);
		dfs(board, pos + 1, cur, i, j + 1, visited, res);
		dfs(board, pos + 1, cur, i, j - 1, visited, res);
		visited[i][j] = false;
	}

	class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		void insert(String word) {
			TrieNode c = root;
			for (int i = 0; i < word.length(); i++) {
				int p = word.charAt(i) - 'a';
				if (c.children[p] == null) {
					c.children[p] = new TrieNode();
				}
				c = c.children[p];
			}
			c.word = word;
		}

		boolean startsWith(String word) {
			TrieNode c = root;
			for (int i = 0; i < word.length(); i++) {
				int p = word.charAt(i) - 'a';
				if (c.children[p] == null) {
					return false;
				}
				c = c.children[p];
			}
			return true;
		}
		
		boolean search(String word) {
			TrieNode c = root;
			for (int i = 0; i < word.length(); i++) {
				int p = word.charAt(i) - 'a';
				if (c.children[p] == null) {
					return false;
				}
				c = c.children[p];
			}
			return word.equals(c.word);
		}
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

}
