package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 839. Similar String Groups

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

Example 1:

Input: ["tars","rats","arts","star"]
Output: 2
Note:

A.length <= 2000
A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.
 *
 */
public class SimilarStringGroups {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Piecewise [Accepted]
Intuition

Let W = A[0].length. It is clear that we can determine in O(W)O(W) time, whether two words from A are similar.

One attempt is a standard kind of brute force: for each pair of words, let's draw an edge between these words if they are similar. We can do this in O(N^2 W)O(N
​2
​​ W) time. After, finding the connected components can be done in O(N^2)O(N
​2
​​ ) time naively (each node may have up to N-1N−1 edges), (or O(N)O(N) with a union-find structure.) The total complexity is O(N^2 W)O(N
​2
​​ W).

Another attempt is to enumerate all neighbors of a word. A word has up to \binom{W}{2}(
​2
​W
​​ ) neighbors, and if that neighbor is itself a given word, we know that word and neighbor are connected by an edge. In this way, we can build the graph in O(N W^3)O(NW
​3
​​ ) time, and again take O(N^2)O(N
​2
​​ ) or O(N)O(N) time to analyze the number of connected components.

One insight is that between these two approaches, we can choose which approach works better. If we have very few words, we want to use the first approach; if we have very short words, we want to use the second approach. We'll piecewise add these two approaches (with complexity O(N^2 W)O(N
​2
​​ W) and O(N W^3)O(NW
​3
​​ )), to create an approach with O(NW\min(N, W^2))O(NWmin(N,W
​2
​​ )) complexity.

Algorithm

We will build some underlying graph with N nodes, where nodes i and j are connected if and only if A[i] is similar to A[j], then look at the number of connected components.

There are a few challenges involved in this problem, but each challenge is relatively straightforward.

Use a helper function similar(word1, word2) that is true if and only if two given words are similar.

Enumerate all neighbors of a word, and discover when it is equal to a given word.

Use either a union-find structure or a depth-first search, to calculate the number of connected components of the underlying graph. We've showcased a union-find structure in this solution, with notes of a depth-first search in the comments.

For more details, see the implementations below.

Complexity Analysis

Time Complexity: O(NW \min(N, W^2))O(NWmin(N,W
​2
​​ )), where NN is the length of A, and WW is the length of each given word.

Space Complexity: O(NW^3)O(NW
​3
​​ ). If N < W^2N<W
​2
​​ , the space complexity is O(N)O(N). Otherwise, the space complexity is O(NW^3)O(NW
​3
​​ ): for each of NW^2NW
​2
​​  neighbors we store a word of length WW. (Plus, we store O(NW^2)O(NW
​2
​​ ) node indices ("buckets") which is dominated by the O(NW^3)O(NW
​3
​​ ) term.) Because W^2 <= NW
​2
​​ <=N in this case, we could also write the space complexity as O(N^2 W)O(N
​2
​​ W).

	 */
	public int numSimilarGroups(String[] A) {
      int N = A.length;
      int W = A[0].length();
      DSU dsu = new DSU(N);

      if (N < W*W) { // If few words, then check for pairwise similarity: O(N^2 W)
          for (int i = 0; i < N; ++i)
              for (int j = i+1; j < N; ++j)
                  if (similar(A[i], A[j]))
                      dsu.union(i, j);

      } else { // If short words, check all neighbors: O(N W^3)
          Map<String, List<Integer>> buckets = new HashMap();
          for (int i = 0; i < N; ++i) {
              char[] L = A[i].toCharArray();
              for (int j0 = 0; j0 < L.length; ++j0)
                  for (int j1 = j0 + 1; j1 < L.length; ++j1) {
                      swap(L, j0, j1);
                      StringBuilder sb = new StringBuilder();
                      for (char c: L) sb.append(c);
                      buckets.computeIfAbsent(sb.toString(),
                              x-> new ArrayList<Integer>()).add(i);
                      swap(L, j0, j1);
                  }
          }

          for (int i1 = 0; i1 < A.length; ++i1)
              if (buckets.containsKey(A[i1]))
                  for (int i2: buckets.get(A[i1]))
                      dsu.union(i1, i2);
      }

      int ans = 0;
      for (int i = 0; i < N; ++i)
          if (dsu.parent[i] == i) ans++;

      return ans;
  }

  public boolean similar(String word1, String word2) {
      int diff = 0;
      for (int i = 0; i < word1.length(); ++i)
          if (word1.charAt(i) != word2.charAt(i))
              diff++;
      return diff <= 2;
  }

  public void swap(char[] A, int i, int j) {
      char tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
  }
}

class DSU {
  int[] parent;
  public DSU(int N) {
      parent = new int[N];
      for (int i = 0; i < N; ++i)
          parent[i] = i;
  }
  public int find(int x) {
      if (parent[x] != x) parent[x] = find(parent[x]);
      return parent[x];
  }
  public void union(int x, int y) {
      parent[find(x)] = find(y);
  }
}
