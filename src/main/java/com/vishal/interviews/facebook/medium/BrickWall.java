package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 554. Brick Wall
 *
 */
public class BrickWall {

	public static void main(String[] args) {

	}
	
	public static int leastBricks(List<List<Integer>> wall) {
		
		if(wall == null || wall.size() == 0){
			return 0;
		}
      
		Map<Integer, Integer> map = new HashMap<>();
		
		int rows = wall.size();
		int min = rows;
		for(int i = 0; i< wall.size();i++){
			List<Integer> row = wall.get(i);
			int sum = 0;
			for(int j = 0; j< row.size();j++){
				sum += row.get(j);
				map.put(sum, map.getOrDefault(sum, 0)+1);
				min = Math.min(map.get(sum), min);
			}
		}
		
		return rows - min;
   }

}
