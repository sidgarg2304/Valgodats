package com.vishal.datastructures.segmenttree;

public class RangeMinSegmentTree {

	private int[] input;
	private int[] segTreeArray;

	public RangeMinSegmentTree(int[] input) {
		this.input = input;
		segTreeArray = new int[4 * input.length];
	}

	public void constructRangeMinSegmentTree() {
		constructRangeMinSegmentTree(0, input.length - 1, 0);
	}

	public void constructRangeMinSegmentTree(int low, int high, int treePos) {

		if (low == high) {
			segTreeArray[treePos] = input[low];
			return;
		}

		int mid = (low + high) / 2;
		constructRangeMinSegmentTree(low, mid, 2 * treePos + 1);
		constructRangeMinSegmentTree(mid + 1, high, 2 * treePos + 2);

		segTreeArray[treePos] = Math.min(segTreeArray[2 * treePos + 1], segTreeArray[2 * treePos + 2]);

	}

	public int queryRangeMin(int qLow, int qHigh, int low, int high, int treePos) {

		// Total overlap and no need to go down further in the tree
		if (low >= qLow && high <= qHigh) {
			return segTreeArray[treePos];
		}

		// No Overlap
		if (high < qLow || low > qHigh) {
			return Integer.MAX_VALUE;
		}

		int mid = (low + high) / 2;
		return Math.min(queryRangeMin(qLow, qHigh, low, mid, 2 * treePos + 1),
				queryRangeMin(qLow, qHigh, mid + 1, high, 2 * treePos + 2));

	}
}
