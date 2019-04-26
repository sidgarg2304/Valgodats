package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 834. Sum of Distances in Tree

An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

Example 1:

Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
Note: 1 <= N <= 10000
 *
 */
public class SumofDistancesinTree {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Subtree Sum and Count [Accepted]
Intuition and Algorithm

Root the tree. For each node, consider the subtree of that node plus all descendants, and consider count[node] and stsum[node], the number of nodes and the sum of the value of those nodes.

We can calculate this using a post-order traversal, where on exiting some node, the count and stsum of all descendants of this node is correct, and we now calculate count[node] += count[child] and stsum[node] += stsum[child] + count[child].

This will give us the right answer for the root: ans[root] = stsum[root].

Now for the insight: if we have a node parent and it's child child, then ans[child] = ans[parent] - count[child] + (N - count[child]). This is because there are count[child] nodes that are 1 easier to get to from child than parent, and N-count[child] nodes that are 1 harder to get to from child than parent.

Using a second, pre-order traversal, we can update our answer in linear time for all of our nodes.
	 */
	int[] ans, count;
   List<Set<Integer>> graph;
   int N;
   public int[] sumOfDistancesInTree(int N, int[][] edges) {
       this.N = N;
       graph = new ArrayList<Set<Integer>>();
       ans = new int[N];
       count = new int[N];
       Arrays.fill(count, 1);

       for (int i = 0; i < N; ++i)
           graph.add(new HashSet<Integer>());
       for (int[] edge: edges) {
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
       }
       dfs(0, -1);
       dfs2(0, -1);
       return ans;
   }

   public void dfs(int node, int parent) {
       for (int child: graph.get(node))
           if (child != parent) {
               dfs(child, node);
               count[node] += count[child];
               ans[node] += ans[child] + count[child];
           }
   }

   public void dfs2(int node, int parent) {
       for (int child: graph.get(node))
           if (child != parent) {
               ans[child] = ans[node] - count[child] + N - count[child];
               dfs2(child, node);
           }
   }

}
