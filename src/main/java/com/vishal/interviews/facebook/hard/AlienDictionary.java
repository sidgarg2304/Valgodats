package com.vishal.interviews.facebook.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 269. Alien Dictionary
 * 
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

someone asked below?
The description is wrong?
The question says:
if the input is [ "wrt", "wrf", "er", "ett", "rftt" ]
The correct order is: "wertf".
but from "rftt", f should be lexicographically smaller than t? How can the result be "wertf"? Correct me if I am wrong.

Wrong test case: for test case ["wrtkj","wrt"], we are doing this based on "Alien" dictionary.
Let's see these two test cases:

for test case ["xz","xy"], the expected answer is xzy. It means that we don't need to care about the position of the letters without dependency, like x. The answer can be like xzy, zyx, zxy. As long as z is in front of y.

But for test case ["wrtkj","wrt"], the expected answer is "". Interesting..
according to test case ["xz","xy"], the result of ["wrtkj","wrt"] can be any order Coz there is no dependency of the letters.

Some people says that because "wrt" is the prefix of "wrtkj", it should appear first.

But I think this question is called "Alien Dictionary" and there are no specific rules for the situation like "wrtkj", "wrt".
I may say that according to this "Alien" lexicography, "a" should appear after "ab", and "ab" should appear after "aba", that's totally possible, Coz it's allowed "Alien" lexicographically.

I think if they want us to solve the problem based on the rule you mentioned, they should make it clear.

If I am wrong about this, please do let me know, thanks guys.
 */
public class AlienDictionary {

	public static void main(String[] args) {

	}

	public String alienOrderBFS(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> degree = new HashMap<Character, Integer>();
		String result = "";
		if (words == null || words.length == 0)
			return result;
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			int length = Math.min(cur.length(), next.length());
			for (int j = 0; j < length; j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					Set<Character> set = new HashSet<Character>();
					if (map.containsKey(c1))
						set = map.get(c1);
					if (!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;
				}
			}
		}
		Queue<Character> q = new LinkedList<Character>();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0)
				q.add(c);
		}
		while (!q.isEmpty()) {
			char c = q.remove();
			result += c;
			if (map.containsKey(c)) {
				for (char c2 : map.get(c)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0)
						q.add(c2);
				}
			}
		}
		if (result.length() != degree.size())
			return "";
		return result;
	}

}

/**
 * 3ms Clean Java Solution (DFS) The key to this problem is:
 * 
 * A topological ordering is possible if and only if the graph has no directed
 * cycles Let's build a graph and perform a DFS. The following states made
 * things easier.
 * 
 * visited[i] = -1. Not even exist.
 * 
 * visited[i] = 0. Exist. Non-visited.
 * 
 * visited[i] = 1. Visiting.
 * 
 * visited[i] = 2. Visited.
 * 
 * Similarly, there is another simple BFS version.
 * 
 * https://discuss.leetcode.com/topic/32900/java-bfs-solution
 *
 */
class AlienDictionaryClean {
	private final int N = 26;

	public String alienOrder(String[] words) {
		boolean[][] adj = new boolean[N][N];
		int[] visited = new int[N];
		buildGraph(words, adj, visited);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) { // unvisited
				if (!dfs(adj, visited, sb, i))
					return "";
			}
		}
		return sb.reverse().toString();
	}

	public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
		visited[i] = 1; // 1 = visiting
		for (int j = 0; j < N; j++) {
			if (adj[i][j]) { // connected
				if (visited[j] == 1)
					return false; // 1 => 1, cycle
				if (visited[j] == 0) { // 0 = unvisited
					if (!dfs(adj, visited, sb, j))
						return false;
				}
			}
		}
		visited[i] = 2; // 2 = visited
		sb.append((char) (i + 'a'));
		return true;
	}

	public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
		Arrays.fill(visited, -1); // -1 = not even existed
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray())
				visited[c - 'a'] = 0;
			if (i > 0) {
				String w1 = words[i - 1], w2 = words[i];
				int len = Math.min(w1.length(), w2.length());
				for (int j = 0; j < len; j++) {
					char c1 = w1.charAt(j), c2 = w2.charAt(j);
					if (c1 != c2) {
						adj[c1 - 'a'][c2 - 'a'] = true;
						break;
					}
				}
			}
		}
	}
}