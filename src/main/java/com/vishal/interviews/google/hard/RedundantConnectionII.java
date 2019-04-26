package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 685. Redundant Connection II

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 */
public class RedundantConnectionII {

	public static void main(String[] args) {

		

	}
	
	/**
	 * Approach #1: Depth-First Search [Accepted]
Intuition

Starting from a rooted tree with N-1 edges and N vertices, let's enumerate the possibilities for the added "redundant" edge. If there is no loop, then either one vertex must have two parents (or no edge is redundant.) If there is a loop, then either one vertex has two parents, or every vertex has one parent.

In the first two cases, there are only two candidates for deleting an edge, and we can try removing the last one and seeing if that works. In the last case, the last edge of the cycle can be removed: for example, when 1->2->3->4->1->5, we want the last edge (by order of occurrence) in the cycle 1->2->3->4->1 (but not necessarily 1->5).

Algorithm

We'll first construct the underlying graph, keeping track of edges coming from nodes with multiple parents. After, we either have 2 or 0 candidates.

If there are no candidates, then every vertex has one parent, such as in the case 1->2->3->4->1->5. From any node, we walk towards it's parent until we revisit a node - then we must be inside the cycle, and any future seen nodes are part of that cycle. Now we take the last edge that occurs in the cycle.

Otherwise, we'll see if the graph induced by parent is a rooted tree. We again take the root by walking from any node towards the parent until we can't, then we perform a depth-first search on this root. If we visit every node, then removing the last of the two edge candidates is acceptable, and we should. Otherwise, we should remove the first of the two edge candidates.

In our solution, we use orbit to find the result upon walking from a node x towards it's parent repeatedly until you revisit a node or can't walk anymore. orbit(x).node (or orbit(x)[0] in Python) will be the resulting node, while orbit(x).seen (or orbit(x)[1]) will be all the nodes visited.

Complexity Analysis

Time Complexity: O(N)O(N) where NN is the number of vertices (and also the number of edges) in the graph. We perform a depth-first search.

Space Complexity: O(N)O(N), the size of the graph.
	 */
	public int[] findRedundantDirectedConnection(int[][] edges) {
      int N = edges.length;
      Map<Integer, Integer> parent = new HashMap();
      List<int[]> candidates = new ArrayList();
      for (int[] edge: edges) {
          if (parent.containsKey(edge[1])) {
              candidates.add(new int[]{parent.get(edge[1]), edge[1]});
              candidates.add(edge);
          } else {
              parent.put(edge[1], edge[0]);
          }
      }

      int root = orbit(1, parent).node;
      if (candidates.isEmpty()) {
          Set<Integer> cycle = orbit(root, parent).seen;
          int[] ans = new int[]{0, 0};
          for (int[] edge: edges) {
              if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                  ans = edge;
              }
          }
          return ans;
      }

      Map<Integer, List<Integer>> children = new HashMap();
      for (int v: parent.keySet()) {
          int pv = parent.get(v);
          if (!children.containsKey(pv))
              children.put(pv, new ArrayList<Integer>());
          children.get(pv).add(v);
      }

      boolean[] seen = new boolean[N+1];
      seen[0] = true;
      Stack<Integer> stack = new Stack();
      stack.add(root);
      while (!stack.isEmpty()) {
          int node = stack.pop();
          if (!seen[node]) {
              seen[node] = true;
              if (children.containsKey(node)) {
                  for (int c: children.get(node))
                      stack.push(c);
              }
          }
      }
      for (boolean b: seen) if (!b)
          return candidates.get(0);
      return candidates.get(1);
  }

  public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
      Set<Integer> seen = new HashSet();
      while (parent.containsKey(node) && !seen.contains(node)) {
          seen.add(node);
          node = parent.get(node);
      }
      return new OrbitResult(node, seen);
  }

}
class OrbitResult {
  int node;
  Set<Integer> seen;
  OrbitResult(int n, Set<Integer> s) {
      node = n;
      seen = s;
  }
}
