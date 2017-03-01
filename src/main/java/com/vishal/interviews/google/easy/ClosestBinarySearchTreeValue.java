package com.vishal.interviews.google.easy;

/**
 * 270 Given a non-empty binary search tree and a target value, find the value
 * in the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 * 
 * @author vkotha
 *
 */
public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closestValueRecursive(TreeNode root, double target) {
		int a = root.val;
		TreeNode kid = target < a ? root.left : root.right;
		if (kid == null)
			return a;
		int b = closestValueRecursive(kid, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;

	}

	public int closestValueIterative(TreeNode root, double target) {
		int closestVal = root.val;
		while (root != null) {
			// update closestVal if the current value is closer to target
			closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal)) ? root.val : closestVal;
			if (closestVal == target) { // already find the best result
				return closestVal;
			}
			root = (root.val > target) ? root.left : root.right; // binary search
		}
		return closestVal;
	}

	public int closestValueClean(TreeNode root, double target) {
		int ret = root.val;
		while (root != null) {
			if (Math.abs(target - root.val) < Math.abs(target - ret)) {
				ret = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		return ret;
	}

	public int closestValueIterative2(TreeNode root, double target) {
		double closest = Integer.MAX_VALUE;
		int value = 0;
		TreeNode current = root;
		while (current != null) {
			if (closest > Math.abs(current.val - target)) {
				closest = Math.abs(current.val - target);
				value = current.val;
			}

			if (current.val < target) {
				current = current.right;
			} else if (current.val > target) {
				current = current.left;
			} else {
				break;
			}
		}
		return value;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
}
