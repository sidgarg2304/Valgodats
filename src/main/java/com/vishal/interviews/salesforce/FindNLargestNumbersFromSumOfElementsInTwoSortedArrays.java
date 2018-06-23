package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * Given two sorted arrays of integers, A and B, find the set of n largest
 * numbers where each number is the sum of an integer from A and an integer from
 * B.
 *
 */
public class FindNLargestNumbersFromSumOfElementsInTwoSortedArrays {

	public static void main(String[] args) {

		System.out.println(findNLargest(new int[] { 2, 4, 7 }, new int[] { 1, 3, 5 }, 7));
		
		
	}

	/**
	 *      2  4  7
	 *     --------
	 *  1 | 3  5  8
	 *  3 | 5  7 10
	 *  5 | 7  9 12
	 *  
	 *  // 12 10 9 8 7 7 5 5 3
	 */
	static List<Integer> findNLargest(int[] nums1, int[] nums2, int n) {

		List<Integer> res = new ArrayList<>();

		PriorityQueue<QueueElement> maxHeap = new PriorityQueue<>(new Comparator<QueueElement>() {
			public int compare(QueueElement e1, QueueElement e2) {
				return e2.val - e1.val;
			}
		});
		Set<QueueElement> visited = new HashSet<>();
		maxHeap.offer(
				new QueueElement(nums1[nums1.length - 1] + nums2[nums2.length - 1], nums1.length - 1, nums2.length - 1));
		while (n > 0) {
			QueueElement cur = maxHeap.poll();
									
			if (visited.contains(cur)) {			
				continue;
			}
			
			res.add(cur.val);
			visited.add(cur);
			
			int i = cur.x;
			int j = cur.y;

			if (i > 0) {				
				maxHeap.offer(new QueueElement(nums1[i - 1] + nums2[j], i - 1, j));
			}

			if (j > 0) {				
				maxHeap.offer(new QueueElement(nums1[i] + nums2[j - 1], i, j - 1));
			}
			n--;
		}
		

		return res;
	}

}

class QueueElement {

	public QueueElement(int val, int x, int y) {
		this.val = val;
		this.x = x;
		this.y = y;
	}

	int val;
	int x;
	int y;

	@Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}		
		if (o instanceof QueueElement) {
			QueueElement q = (QueueElement) o;
			
			return q.x == this.x && q.y == this.y;
		}		
		return false;
	}
	
	@Override
	public int hashCode(){
		return x + y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}
