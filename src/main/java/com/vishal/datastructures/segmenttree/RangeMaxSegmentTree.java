package com.vishal.datastructures.segmenttree;

public class RangeMaxSegmentTree {

	public static void main(String[] args) {

	}

	SegmentTreeNode root;

	RangeMaxSegmentTree(int[] nums) {

		root = buildTree(nums, 0, nums.length - 1);
	}

	SegmentTreeNode buildTree(int[] nums, int st, int en) {

		if (st > en) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(st, en);

		if (st == en) {
			root.sum = nums[st];
			return root;
		}

		int m = st + (en - st) / 2;
		root.left = buildTree(nums, st, m);
		root.right = buildTree(nums, m + 1, en);

		root.sum = root.left.sum + root.right.sum;

		return root;
	}

	void update(int[] nums, int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int i, int val) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null && root.st == i) {
			root.sum = val;
			return;
		}

		int m = root.st + (root.en - root.st) / 2;
		if (m <= i) {
			update(root.left, i, val);
		} else {
			update(root.right, i, val);
		}

		root.sum = root.left.sum + root.right.sum;
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	public int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.st == start && root.en == end) {
			return root.sum;
		}

		int m = root.st + (root.en - root.st) / 2;

		if (end <= m) {
			return sumRange(root.left, start, end);
		} else if (start > m) {
			return sumRange(root.right, start, end);
		} else {
			return sumRange(root.left, start, m) + sumRange(root.right, m + 1, end);
		}

	}
}
