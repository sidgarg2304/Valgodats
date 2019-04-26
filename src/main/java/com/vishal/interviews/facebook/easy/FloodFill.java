package com.vishal.interviews.facebook.easy;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int[][] res = new int[image.length][image[0].length];

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = image[i][j];
			}
		}

		dfs(sr, sc, res, newColor, image[sr][sc]);
		return res;
	}

	void dfs(int i, int j, int[][] res, int newColor, int oldColor) {

		if (i < 0 || j < 0 || i >= res.length || j >= res[0].length || res[i][j] != oldColor) {
			return;
		}

		res[i][j] = newColor;

		dfs(i - 1, j, res, newColor, oldColor);
		dfs(i + 1, j, res, newColor, oldColor);
		dfs(i, j - 1, res, newColor, oldColor);
		dfs(i, j + 1, res, newColor, oldColor);

	}

}
