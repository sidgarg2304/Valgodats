package com.vishal.algorithms.maths;

public class MathsAlgorithms {

	public static void main(String[] args) {
//		System.out.println(isPerfectSquare(121));
//		System.out.println(Math.random());
		
		int [] a = {1,3,3,3,3,4};
		System.out.println(findDuplicate(a));
	}
	
	public static int findDuplicate(int[] nums) {
	    int slow = 0;
	    int fast = 0;
	 
	    do{
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	    } while(slow != fast);
	 
	    System.out.println("fast = "+ fast + " and slow is " + slow);
	    int find = 0;
	 
	    while(find != slow){
	        slow = nums[slow];
	        find = nums[find];
	    }
	    return find;
	}	

	static boolean isPerfectSquare(int n) {

		int i = 1;

		while (n > 0) {
			n -= i;
			i += 2;
		}

		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}
}
