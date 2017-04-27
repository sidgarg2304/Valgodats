package com.vishal.interviews.facebook.medium;

import java.util.*;

public class RandomPickIndex {

	public static void main(String[] args) {

	}
	
	Random rand;
	Map<Integer, List<Integer>> map;
	
	public RandomPickIndex(int[] nums){
		map = new HashMap<>();
		for(int i = 0; i< nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(i, new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}
		rand = new Random();
	}
	
	public int pick(int target) {
      List<Integer> positions = map.get(target);
      return positions.get(rand.nextInt(positions.size()));
      
   }

}
