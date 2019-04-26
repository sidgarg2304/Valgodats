package com.vishal.interviews.uber.easy;

public class ConstructQuadTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node construct(int[][] grid) {
		return construct(grid, 0, 0, grid.length);
	}

	public Node construct(int[][] grid, int r, int c, int len) {

		if (len == 1) {
			return new Node(grid[r][c] == 1, true, null, null, null, null);
		}

		Node root = new Node();		
		Node topLeft = construct(grid, r, c, len / 2);
		Node topRight = construct(grid, r, c + len / 2, len / 2);
		Node botLeft = construct(grid, r + len / 2, c, len / 2);
		Node botRight = construct(grid, r + len / 2, c + len / 2, len / 2);

		if (topLeft.isLeaf && topRight.isLeaf && botRight.isLeaf && botLeft.isLeaf && topLeft.val == topRight.val
				&& topRight.val == botLeft.val && botLeft.val == botRight.val) {
			root.isLeaf = true;
			root.val = topLeft.val;
		} else {
			root.topLeft = topLeft;
			root.topRight = topLeft;
			root.bottomLeft = botLeft;
			root.bottomRight = botRight;
		}

		return root;
	}

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
		}

		public Node(boolean _val, boolean _isLeaf) {
			val = _val;
			isLeaf = _isLeaf;
		}

		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	}

}
