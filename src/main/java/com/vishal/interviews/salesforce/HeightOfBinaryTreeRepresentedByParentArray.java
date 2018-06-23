package com.vishal.interviews.salesforce;

public class HeightOfBinaryTreeRepresentedByParentArray {

	public static void main(String[] args) {

	}

	int findHeight(int parent[]) {

		int[] depth = new int[parent.length];
		for (int i = 0; i < depth.length; i++) {
			fillDepth(parent, i, depth);
		}

		int max = 0;
		for (int i = 0; i < depth.length; i++) {
			max = Math.max(max, depth[i]);
		}
		return max;

	}

	void fillDepth(int[] parent, int i, int[] depth) {
		if (depth[i] != 0) {
			return;
		}

		if (parent[i] == -1) {
			depth[i] = 1;
		}

		if (depth[parent[i]] != 0) {
			fillDepth(parent, parent[i], depth);
		}

		// Depth of this node is depth of parent plus 1
		depth[i] = depth[parent[i]] + 1;
	}

}
