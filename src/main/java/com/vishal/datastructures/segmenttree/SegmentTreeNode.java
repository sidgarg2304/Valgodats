package com.vishal.datastructures.segmenttree;

public class SegmentTreeNode {

	int st;
	int en;
	int sum;

	SegmentTreeNode left;
	SegmentTreeNode right;

	public SegmentTreeNode(int st, int en) {
		this.st = st;
		this.en = en;
	}
}
