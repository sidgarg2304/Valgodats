package com.vishal.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vishal.datastructures.trie.Trie;

public class MatrixDFSAlgorithms {

	public static void main(String[] args) {
		testFindNumOfIsle();
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

	public static void testFindNumOfIsle() {
		char[][] m = new char[3][3];

		m[0] = new char[] { 'x', 'x', 'o' };
		m[1] = new char[] { 'o', 'x', 'x' };
		m[2] = new char[] { 'o', 'x', 'o' };		

		System.out.println("num of isles is " + findNumOfIsle(m));
	}

	/**
	 * Isle is defined as 'x' surrounded horizontally and vertically with 'o'
	 * 
	 * @param m
	 * @return
	 */
	public static int findNumOfIsle(char[][] m) {

		int count = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 'x') {

					System.out.println("processing " + i + "," + j);
					// if (i > 0 && j > 0 && m[i - 1][j] == 'o' && m[i - 1][j - 1] ==
					// 'o' && m[i][j - 1] == 'o') {
					// count++;
					// }else if(m[i][j-1] == 'o' && m[i+1][j+1] == 'o' && m[i+1][j]
					// == 'o'){
					// count++;
					// }else if(m[i][j+1] == 'o' && m[i+1][j+1] == 'o' && m[i+1][j]
					// == 'o'){
					// count++;
					// }else if(m[i-1][j] == 'o' && m[i+1][j+1] == 'o' && m[i][j+1]
					// == 'o'){
					// count++;
					// }

					if (i > 0 && j > 0 && m[i - 1][j] == 'o' && m[i][j - 1] == 'o') {
						System.out.println("1incrementing " + (i - 1) + "," + (j - 1));
						count++;
					} else if (i < m.length - 1 && j > 0 && m[i][j - 1] == 'o' && m[i + 1][j] == 'o') {
						System.out.println("2incrementing " + (i + 1) + "," + (j - 1));
						count++;
					} else if (j < m[0].length - 1 && i < m.length - 1 && m[i][j + 1] == 'o' && m[i + 1][j] == 'o') {
						System.out.println("3incrementing " + (i + 1) + "," + (j + 1));
						count++;
					} else if (i > 0 && j < m[0].length - 1 && m[i - 1][j] == 'o' && m[i][j + 1] == 'o') {
						System.out.println("4incrementing " + (i - 1) + "," + (j + 1));
						count++;
					}

				}
			}
		}
		return count;
	}

}
