package com.vishal.interviews.facebook.medium;

public class Flatten2DVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[][] v;
	int r = 0;
	int c = 0;

	public Flatten2DVector(int[][] v) {
		this.v = v;
	}

	public int next() {
		if (hasNext()) {
		    int ret = v[r][c];
		    c++;
		    return ret; 
        }
        return Integer.MIN_VALUE;
	}

	public boolean hasNext() {

		if (r >= v.length) {
			return false;
		}

		if (c >= v[r].length) {
			r++;
			return hasNext();
		}
		return true;
	}

}
