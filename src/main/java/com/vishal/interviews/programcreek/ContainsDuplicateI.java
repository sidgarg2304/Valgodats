package com.vishal.interviews.programcreek;

import java.util.*;

public class ContainsDuplicateI {

	public static void main(String[] args) {

	}
	
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0){
			return false;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i: nums){
			if(!set.add(i)){
				return true;
			}
		}
		
		return false;
	}

}
