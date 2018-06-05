package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

import com.vishal.interviews.util.TrieNode;

public class WordSearchII {

	public static void main(String[] args) {

	}

	public List<String> findWords(char[][] board, String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		List<String> res = new ArrayList<>();

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, "", trie, visited, res);
			}
		}

		return res;
	}

	void dfs(char[][] board, int i, int j, String cur, Trie trie, boolean[][] visited, List<String> res) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}

		cur += board[i][j];
		if (!trie.startsWith(cur)) {
			return;
		}

		if (trie.search(cur)) {
			res.add(cur);
		}

		visited[i][j] = true;
		dfs(board, i - 1, j, "", trie, visited, res);
		dfs(board, i + 1, j, "", trie, visited, res);
		dfs(board, i, j - 1, "", trie, visited, res);
		dfs(board, i, j + 1, "", trie, visited, res);
		visited[i][j] = false;
	}

}

class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String word) {

		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int p = word.charAt(i) - 'a';
			if (cur.children[p] == null) {
				cur.children[p] = new TrieNode();
			}
			cur = cur.children[p];
		}
		cur.isWord = true;
		cur.word = word;
	}

	boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int p = word.charAt(i) - 'a';
			if (cur.children[p] == null) {
				return false;
			}
			cur = cur.children[p];
		}
		return cur.isWord;
	}

	boolean startsWith(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int p = word.charAt(i) - 'a';
			if (cur.children[p] == null) {
				return false;
			}
			cur = cur.children[p];
		}
		return true;
	}
}
