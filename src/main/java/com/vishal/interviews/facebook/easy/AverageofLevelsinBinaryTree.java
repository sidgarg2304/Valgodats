package com.vishal.interviews.facebook.easy;

import java.util.*;

/**
 * 637. Average of Levels in Binary Tree
 * 
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *
 */
public class AverageofLevelsinBinaryTree {

	public static void main(String[] args) {

	}
	
	//DFS
	public List < Double > averageOfLevelsDFS(TreeNode root) {
      List < Integer > count = new ArrayList < > ();
      List < Double > res = new ArrayList < > ();
      average(root, 0, res, count);
      for (int i = 0; i < res.size(); i++)
          res.set(i, res.get(i) / count.get(i));
      return res;
  }
  public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
      if (t == null)
          return;
      if (i < sum.size()) {
          sum.set(i, sum.get(i) + t.val);
          count.set(i, count.get(i) + 1);
      } else {
          sum.add(1.0 * t.val);
          count.add(1);
      }
      average(t.left, i + 1, sum, count);
      average(t.right, i + 1, sum, count);
  }
  
	// BFS
	public List < Double > averageOfLevelsBFS(TreeNode root) {
      List < Double > res = new ArrayList < > ();
      Queue < TreeNode > queue = new LinkedList < > ();
      queue.add(root);
      while (!queue.isEmpty()) {
          long sum = 0, count = 0;
          Queue < TreeNode > temp = new LinkedList < > ();
          while (!queue.isEmpty()) {
              TreeNode n = queue.remove();
              sum += n.val;
              count++;
              if (n.left != null)
                  temp.add(n.left);
              if (n.right != null)
                  temp.add(n.right);
          }
          queue = temp;
          res.add(sum * 1.0 / count);
      }
      return res;
  }

}
