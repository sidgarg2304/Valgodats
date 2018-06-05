package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class KthLargestElementinanArray {

	public static void main(String[] args) {

	}
	
	public int findKthLargest(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
			return -1;
		}
      
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for(int i: nums){
      	minHeap.offer(i);
      	if(minHeap.size() > k){
      		minHeap.poll();
      	}
      }
      return minHeap.peek();
	}

}
