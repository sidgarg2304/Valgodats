package com.vishal.interviews.leetcodereremaining.medium;

public class OneThreeTwo132Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean find132pattern(int[] nums) {
      if(nums.length<3) return false;
      
      int start = 0;
      while(start<nums.length-1){
          while(start<nums.length-1 && nums[start]>=nums[start+1]) start++;
          // start is lowest now
          int m = start+1;
          while(m<nums.length-1 && nums[m]<=nums[m+1]) m++;
          // m is highest now
          int j = m+1;
          while(j<nums.length){
              if(nums[j]>nums[start] && nums[j]<nums[m]) return true;
              j++;
          }
          start = m+1;
      }
      return false;
  }

}
