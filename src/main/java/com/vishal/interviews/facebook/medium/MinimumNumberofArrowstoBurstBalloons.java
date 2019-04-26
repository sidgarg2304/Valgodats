package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMinArrowShots(int[][] points) {

		if(points == null || points.length == 0){
			return 0;
		}
		
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		
		int curArrowPos = points[0][1];
		int res = 1;
		for(int i = 1; i< points.length; i++){
			if(curArrowPos >= points[i][0] && curArrowPos <= points[i][1]){
				continue;
			}
			
			curArrowPos = points[i][1];
			res++;
		}
		
		return res;
	}

}
