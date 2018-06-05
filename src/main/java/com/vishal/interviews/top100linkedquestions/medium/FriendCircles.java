package com.vishal.interviews.top100linkedquestions.medium;

public class FriendCircles {

	public static void main(String[] args) {

	}

	public int findCircleNum(int[][] M) {
		int res = 0;
		if (M == null || M.length == 0) {
			return res;
		}

		boolean[] partOfCircle = new boolean[M.length];
		for (int i = 0; i < M.length; i++) {
			if (!partOfCircle[i]) {
				dfs(M, partOfCircle, i);
				res++;
			}
		}

		return res;
	}

	void dfs(int[][] M, boolean[] partOfCircle, int i) {

		for(int j = 0; j< M.length; j++){
			if(M[i][j] == 1 && !partOfCircle[j]){
				partOfCircle[j] = true;
				dfs(M, partOfCircle, j);
			}
		}
	}

}
