package com.vishal.interviews.facebook.medium;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	SegmentTreeNode root = null;

	public RangeSumQueryMutable(int[] nums) {
		root = constructTree(nums, 0, nums.length - 1);
	}

	SegmentTreeNode constructTree(int[] nums, int st, int en) {
		if (st > en) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(st, en);
		if (st == en) {
			root.sum = nums[st];
			return root;
		}

		int m = st + (en - st) / 2;
		root.left = constructTree(nums, st, m);
		root.right = constructTree(nums, m + 1, en);

		root.sum = root.left.sum + root.right.sum;

		return root;
	}

	public void update(int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int i, int val) {

		if (root == null) {
			return;
		}

		if (root.st == root.en && root.st == i) {
			root.sum = val;
			return;
		}

		int m = root.st + (root.en - root.st) / 2;
		if (i <= m) {
			update(root.left, i, val);
		} else {
			update(root.right, i, val);
		}

		root.sum = root.left.sum + root.right.sum;
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	int sumRange(SegmentTreeNode root, int i, int j) {
		if (i > j) {
			return -1;
		}

		if (root.st == i && root.en == j) {
			return root.sum;
		}

		int m = root.st + (root.en - root.st) / 2;
		if (j <= m) {
			return sumRange(root.left, i, j);
		} else if (i > m) {
			return sumRange(root.right, i, j);
		} else {
			return sumRange(root.left, i, m) + sumRange(root.right, m + 1, j);
		}
	}

}

class SegmentTreeNode {
	int st;
	int en;
	int sum;

	SegmentTreeNode left;
	SegmentTreeNode right;

	SegmentTreeNode(int st, int en) {
		this.st = st;
		this.en = en;
	}
}

