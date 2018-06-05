package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class SubtreeofAnotherTree {

	public static void main(String[] args) {

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return t == null;
		}

		if (t == null) {
			return true;
		}

		if (s.val == t.val) {
			if (isSame(s, t)) {
				return true;
			}
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		}

		if (s.val != t.val) {
			return false;
		}

		return isSame(s.left, t.left) && isSame(s.right, t.right);

	}

}
