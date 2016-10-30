package com.vishal.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vishal.datastructures.trie.Trie;

public class MatrixDFSAlgorithms {

	public static void main(String[] args) {

	}

	public static List<String> findAllWords(Character[][] m, Set<String> dictionary) {
		List<String> result = new ArrayList<>();

		Trie trie = new Trie();
		for (String word : dictionary) {
			trie.insert(word);
		}

		boolean[][] visited = new boolean[m.length][m[0].length];

		int r = m.length;
		int c = m[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dfs(m, dictionary, visited, "", trie, result, i, j);
			}
		}

		return result;
	}

	static void dfs(Character[][] m, Set<String> dictionary, boolean[][] visited, String s, Trie trie,
			List<String> result, int i, int j) {

		if (i < 0 || j < 0 || i >= m.length || j >= m[0].length || visited[i][j]) {
			return;
		}

		if (trie.search(s)) {
			result.add(s);
			return;
		}

		s = s + m[i][j];
		
		visited[i][j] = true;
		
		dfs(m, dictionary, visited, s, trie, result, i + 1, j);
		dfs(m, dictionary, visited, s, trie, result, i - 1, j);
		dfs(m, dictionary, visited, s, trie, result, i, j + 1);
		dfs(m, dictionary, visited, s, trie, result, i, j - 1);
		
		visited[i][j] = false;
	}

}
