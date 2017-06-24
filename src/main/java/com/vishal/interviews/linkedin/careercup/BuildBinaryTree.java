package com.vishal.interviews.linkedin.careercup;

import java.util.*;

import com.vishal.interviews.util.Relation;
import com.vishal.interviews.util.TreeNode;
/**
 * Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are unique. 

Example: 

Given the following relationships: 

Child Parent IsLeft 
15 20 true 
19 80 true 
17 20 false 
16 80 false 
80 50 false 
50 null false 
20 50 true 


You should return the following tree: 
50 
/ \ 
20 80 
/ \ / \ 
15 17 19 16 

 */
public class BuildBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(List<Relation> data) {
		Map<Integer, TreeNode> map = new HashMap<>();

		TreeNode root = null;
		for (Relation r : data) {
			Integer pVal = r.parent;
			Integer cVal = r.child;

			TreeNode p = null;
			if (!map.containsKey(pVal)) {
				p = pVal != null ? new TreeNode(pVal) : null;
				map.put(pVal, p);
			} else {
				p = map.get(pVal);
			}

			TreeNode c = null;
			if (!map.containsKey(cVal)) {
				c = new TreeNode(cVal);
				map.put(cVal, c);
			} else {
				c = map.get(cVal);
			}

			if (p != null) {
				if (r.isLeft) {
					p.left = c;
				} else {
					p.right = c;
				}
			} else {
				root = c;
			}

		}

		return root;
	}

}
