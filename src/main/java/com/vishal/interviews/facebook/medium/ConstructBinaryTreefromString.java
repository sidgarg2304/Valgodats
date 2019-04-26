package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.TreeNode;

public class ConstructBinaryTreefromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode str2tree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		int p = s.indexOf("(");
		int val = p == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, p));
		TreeNode root = new TreeNode(val);
		if (p == -1) {
			return root;
		}

		int st = p, bracesCnt = 0;
		for (int i = st; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				bracesCnt++;
			} else if (s.charAt(i) == ')') {
				bracesCnt--;
			}

			if (bracesCnt == 0 && st == p) {
				root.left = str2tree(s.substring(st + 1, i));
				st = i + 1;
			} else if (bracesCnt == 0) {
				root.right = str2tree(s.substring(st + 1, i));
			}
		}
		return root;
	}

}
