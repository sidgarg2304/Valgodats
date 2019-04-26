package com.vishal.interviews.facebook.easy;

import java.util.Comparator;
import java.util.PriorityQueue;


public class KClosestPointstoOrigin {

	public static int[][] kClosest(int[][] points, int K) {      

		if(points == null || points.length <= K){
			return points;
		}
		PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return (int) (b.d - a.d);
			}
		});

		for (int i = 0; i < points.length; i++) {
			int[] cur = points[i];
			double d = cur[0] * cur[0] + (cur[1] * cur[1]);
			minHeap.offer(new Point(cur, d));
			if (minHeap.size() > K) {
				minHeap.poll();
			}
		}

		int[][] res = new int[K][2];
		int i = K-1;
		while(!minHeap.isEmpty()){
			res[i--] = minHeap.poll().p;
		}
		return res;
	}

}

class Point {
	int[] p;
	double d;

	Point(int[] p, double d) {
		this.p = p;
		this.d = d;
	}
}