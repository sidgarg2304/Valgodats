package com.vishal.interviews.linkedin.careercup;

import java.util.*;

public class PowerIterator {

	public static void main(String[] args) {
		PowerIterator iter = new PowerIterator();
		for (int i = 0; i < 10; i++) {
			if(i == 5){
				iter.reset();
			}
			System.out.println(iter.next());
		}
	}

	PriorityQueue<Power> minHeap;

	PowerIterator() {
		minHeap = new PriorityQueue<Power>(new Comparator<Power>() {
			public int compare(Power a, Power b) {
				return a.val - b.val;

			}
		});
		minHeap.offer(new Power(2, 2));		
	}

	int next() {
		int res = minHeap.peek().val;

		while (!minHeap.isEmpty() && minHeap.peek().val == res) {
			Power toRemove = minHeap.poll();
			if (toRemove.power == 2) {
				minHeap.offer(new Power(toRemove.base + 1, 2));
			}
			minHeap.offer(new Power(toRemove.base, toRemove.power + 1));
		}
		return res;
	}

	boolean hasNext() {
		return !minHeap.isEmpty();
	}
	
	void reset(){
		minHeap.clear();
		minHeap.offer(new Power(2, 2));
	}

}

class Power {

	Power(int power, int base) {
		this.power = power;
		this.base = base;
		this.val = (int) Math.pow(base, power);
	}

	int power;
	int base;
	int val;

	@Override
	public String toString() {
		return "" + base + "^" + power + "=" + val;
	}
}
