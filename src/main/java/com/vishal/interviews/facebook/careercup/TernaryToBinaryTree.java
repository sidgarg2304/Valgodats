package com.vishal.interviews.facebook.careercup;

import java.util.*;
import com.vishal.interviews.util.TreeNode;

/**
 * convert a ternary expression into a Binary tree structure.

     a?b:c 

       a
      / \
     b   c

  a?b?c:d:e

     a
    / \
   b   e
  / \
 c   d
 
 a?b?c:d:e


a?b?c:d:e?f:g
     a
    / \
   b   e
  / \  /\
 c   df  g
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}
 
try to do it in o(n) time complexity, n is the size of the string
 *
 */
public class TernaryToBinaryTree {

	public static void main(String[] args) {
		TreeNode root = build("1?2?3:4:5?6:7");
		System.out.println(preorder(root));
	}

	static List<Integer> preorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}

		return res;
	}

	static int idx = 0;

	public static TreeNode build(String s) {
		
		TreeNode cur = new TreeNode(s.charAt(idx) - '0');
		idx += 2;
		if (idx < s.length() && s.charAt(idx - 1) != ':') {
			cur.left = build(s);
			cur.right = build(s);
		}

		return cur;
	}

}
