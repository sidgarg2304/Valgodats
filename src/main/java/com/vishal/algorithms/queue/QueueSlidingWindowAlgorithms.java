package com.vishal.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSlidingWindowAlgorithms {

	public static void main(String[] args) {
		
		testMovingAverage();
	}
	
	public static void testMovingAverage(){
		
		MovingAverage movingAverage = new MovingAverage(3);
		movingAverage.add(2);
		movingAverage.add(4);
		movingAverage.add(6);
		movingAverage.add(6);
		movingAverage.add(8);
		System.out.println(movingAverage.avg);
	}

}

class MovingAverage {

	Queue<Integer> queue;
	double avg = 0;
	int size = 0;

	public MovingAverage(int size) {
		queue = new LinkedList<Integer>();
		this.size = size;
	}
	
	public void add(int val){
		if(queue.size() < size){
			queue.offer(val);
			
			avg = (avg * (queue.size()-1) + val )/ queue.size();
		}else{
			int head = queue.poll();
			double minus = (double)head/this.size;
			queue.offer(val);
			double add = (double)val/this.size;
			
			avg = avg - minus + add;			
		}
	}

}
