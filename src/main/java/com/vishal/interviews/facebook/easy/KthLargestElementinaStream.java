package com.vishal.interviews.facebook.easy;

import java.util.*;

public class KthLargestElementinaStream {

	public static void main(String[] args) {

	}
	PriorityQueue<Integer> pq;
   int k;

	
	public KthLargestElementinaStream(int k, int[] nums) {
		this.k = k;
      pq = new PriorityQueue<>(k);
      for (int num : nums) {
          pq.offer(num);
          if (pq.size() > k)  pq.poll();
      }
   }
   
   public int add(int val) {
   	pq.offer(val);
      if (pq.size() > k)  pq.poll();
      return pq.peek();
   }

}
