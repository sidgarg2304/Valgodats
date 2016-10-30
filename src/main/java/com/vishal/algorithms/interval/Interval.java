package com.vishal.algorithms.interval;

public class Interval {

	public Interval(int low, int high) {
		this.low = low;
		this.high = high;
	}

	private int low;
	private int high;

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String toString() {
		return getLow() + "->" + getHigh();
	}

}
