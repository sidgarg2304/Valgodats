package com.vishal.interviews.google.easy;

/**
 * 687. Longest Univalue Path
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 *
 */
public class LongestUnivaluePath {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Recursion [Accepted]
Intuition

We can think of any path (of nodes with the same values) as up to two arrows extending from it's root.

Specifically, the root of a path will be the unique node such that the parent of that node does not appear in the path, and an arrow will be a path where the root only has one child node in the path.

Then, for each node, we want to know what is the longest possible arrow extending left, and the longest possible arrow extending right? We can solve this using recursion.

Algorithm

Let arrow_length(node) be the length of the longest arrow that extends from the node. That will be 1 + arrow_length(node.left) if node.left exists and has the same value as node. Similarly for the node.right case.

While we are computing arrow lengths, each candidate answer will be the sum of the arrows in both directions from that node. We record these candidate answers and return the best one.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree. We process every node once.

Space Complexity: O(H)O(H), where HH is the height of the tree. Our recursive call stack could be up to HH layers deep.
	 */
	
	int ans;
   public int longestUnivaluePath(TreeNode root) {
       ans = 0;
       arrowLength(root);
       return ans;
   }
   public int arrowLength(TreeNode node) {
       if (node == null) return 0;
       int left = arrowLength(node.left);
       int right = arrowLength(node.right);
       int arrowLeft = 0, arrowRight = 0;
       if (node.left != null && node.left.val == node.val) {
           arrowLeft += left + 1;
       }
       if (node.right != null && node.right.val == node.val) {
           arrowRight += right + 1;
       }
       ans = Math.max(ans, arrowLeft + arrowRight);
       return Math.max(arrowLeft, arrowRight);
   }

}
