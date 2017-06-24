package com.vishal.interviews.programcreek.matrix;

import java.util.*;

import com.vishal.interviews.util.TrieNode;

public class WordSearchII {

	public static void main(String[] args) {

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();

		TrieNode root = new TrieNode();
		for (String w : words) {
			insert(w, root);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, "", root, visited, res);
			}
		}

		return res;

	}

	void dfs(char[][] board, int i, int j, String cur, TrieNode root, boolean[][] visited, List<String> res) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}

		cur += board[i][j];
		if (!searchPrefix(cur, root)) {
			return;
		}

		if (search(cur, root)) {
			res.add(cur);
			return;
		}

		visited[i][j] = true;
		dfs(board, i - 1, j, "", root, visited, res);
		dfs(board, i + 1, j, "", root, visited, res);
		dfs(board, i, j - 1, "", root, visited, res);
		dfs(board, i, j + 1, "", root, visited, res);

		visited[i][j] = false;
	}

	void insert(String word, TrieNode root) {

		TrieNode t = root;
		for (int i = 0; i < word.length(); i++) {
			int p = word.charAt(i) - 'a';
			if (t.children[p] == null) {
				t.children[p] = new TrieNode();
			}
			t = t.children[p];
		}
		t.word = word;
	}

	boolean search(String word, TrieNode root) {
		TrieNode t = root;
		for (int i = 0; i < word.length(); i++) {
			int p = word.charAt(i) - 'a';
			if (t.children[p] == null) {
				return false;
			}
			t = t.children[p];
		}
		return t.word.endsWith(word);
	}

	boolean searchPrefix(String prefix, TrieNode root) {
		TrieNode t = root;
		for (int i = 0; i < prefix.length(); i++) {
			int p = prefix.charAt(i) - 'a';
			if (t.children[p] == null) {
				return false;
			}
			t = t.children[p];
		}
		return true;
	}
}
