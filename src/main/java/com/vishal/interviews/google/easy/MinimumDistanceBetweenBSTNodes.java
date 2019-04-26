package com.vishal.interviews.google.easy;

import java.util.*;

/**
 * 783. Minimum Distance Between BST Nodes
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
 *
 */
public class MinimumDistanceBetweenBSTNodes {

	public static void main(String[] args) {

	}
	
/**
 * Approach #1: Write to Array [Accepted]
Intuition and Algorithm

Write all the values to an array, then sort it. The minimum distance must occur between two adjacent values in the sorted list.
 */
	List<Integer> vals;
   public int minDiffInBST1(TreeNode root) {
       vals = new ArrayList();
       dfs1(root);
       Collections.sort(vals);

       int ans = Integer.MAX_VALUE;
       for (int i = 0; i < vals.size() - 1; ++i)
           ans = Math.min(ans, vals.get(i+1) - vals.get(i));

       return ans;
   }

   public void dfs1(TreeNode node) {
       if (node == null) return;
       vals.add(node.val);
       dfs1(node.left);
       dfs1(node.right);
   }
   
   /**
    * Approach #2: In-Order Traversal [Accepted]
Intuition and Algorithm

In a binary search tree, an in-order traversal outputs the values of the tree in order. By remembering the previous value in this order, we could iterate over each possible difference, keeping the smallest one.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree. We iterate over every node once.

Space Complexity: O(H)O(H), where HH is the height of the tree. This is the space used by the implicit call stack when calling dfs.
    */
   Integer prev, ans;
   public int minDiffInBST2(TreeNode root) {
       prev = null;
       ans = Integer.MAX_VALUE;
       dfs2(root);
       return ans;
   }

   public void dfs2(TreeNode node) {
       if (node == null) return;
       dfs2(node.left);
       if (prev != null)
           ans = Math.min(ans, node.val - prev);
       prev = node.val;
       dfs2(node.right);
   }

}
