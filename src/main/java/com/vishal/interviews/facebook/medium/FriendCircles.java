package com.vishal.interviews.facebook.medium;

public class FriendCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findCircleNum(int[][] M) {

		int circles = 0;

		boolean[] partOfCircle = new boolean[M.length];

		for (int i = 0; i < M.length; i++) {
			if (!partOfCircle[i]) {
				circles++;
				dfs(M, partOfCircle, i);
			}
		}
		return circles;
	}

	void dfs(int[][] M, boolean[] partOfCircle, int i) {

		for(int j = 0; j< M[0].length; j++) {
			if(M[i][j] == 1 && !partOfCircle[j]) {
				partOfCircle[j] = true;
				dfs(M, partOfCircle, j);
			}
		}
	}

}
