package com.vishal.interviews.google.medium;

import java.util.*;

/**
 * 652. Find Duplicate Subtrees
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 *
 */
public class FindDuplicateSubtrees {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Depth-First Search [Accepted]
Intuition

We can serialize each subtree. For example, the tree

   1
  / \
 2   3
    / \
   4   5
can be represented as the serialization 1,2,#,#,3,4,#,#,5,#,#, which is a unique representation of the tree.

Algorithm

Perform a depth-first search, where the recursive function returns the serialization of the tree. At each node, record the result in a map, and analyze the map after to determine duplicate subtrees.

Complexity Analysis

Time Complexity: O(N^2)O(N
​2
​​ ), where NN is the number of nodes in the tree. We visit each node once, but each creation of serial may take O(N)O(N) work.

Space Complexity: O(N^2)O(N
​2
​​ ), the size of count.
	 */
	Map<String, Integer> count;
   List<TreeNode> ans;
   public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       count = new HashMap();
       ans = new ArrayList();
       collect(root);
       return ans;
   }

   public String collect(TreeNode node) {
       if (node == null) return "#";
       String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
       count.put(serial, count.getOrDefault(serial, 0) + 1);
       if (count.get(serial) == 2)
           ans.add(node);
       return serial;
   }
   
   /**
    * Approach #2: Unique Identifier [Accepted]
Intuition

Suppose we have a unique identifier for subtrees: two subtrees are the same if and only if they have the same id.

Then, for a node with left child id of x and right child id of y, (node.val, x, y) uniquely determines the tree.

Algorithm

If we have seen the triple (node.val, x, y) before, we can use the identifier we've remembered. Otherwise, we'll create a new one.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree. We visit each node once.

Space Complexity: O(N)O(N). Every structure we use is using O(1)O(1) storage per node.


    */
   int t;
   Map<String, Integer> trees;
   Map<Integer, Integer> count1;
   List<TreeNode> ans1;

   public List<TreeNode> findDuplicateSubtreesUniqueIdentifier(TreeNode root) {
       t = 1;
       trees = new HashMap();
       count1 = new HashMap();
       ans1 = new ArrayList();
       lookup(root);
       return ans;
   }

   public int lookup(TreeNode node) {
       if (node == null) return 0;
       String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
       int uid = trees.computeIfAbsent(serial, x-> t++);
       count1.put(uid, count.getOrDefault(uid, 0) + 1);
       if (count1.get(uid) == 2)
           ans1.add(node);
       return uid;
   }

}
