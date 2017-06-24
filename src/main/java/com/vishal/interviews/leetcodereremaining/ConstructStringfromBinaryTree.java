package com.vishal.interviews.leetcodereremaining;

import com.vishal.interviews.util.TreeNode;

public class ConstructStringfromBinaryTree {

	public static void main(String[] args) {

	}

	public String tree2str(TreeNode t) {

		if (t == null) {
			return "";
		}

		String left = tree2str(t.left);
		String right = tree2str(t.right);

		StringBuilder sb = new StringBuilder();
		sb.append(t.val);

		if(left.length() == 0 && right.length() == 0){
			return sb.toString();
		}
		
		sb.append("(").append(left).append(")");
		if(right.length() == 0){
			return sb.toString();
		}			
		
		if (right.length() != 0) {
			sb.append("(").append(right).append(")");
		}

		return sb.toString();

	}

}
