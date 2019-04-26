package com.vishal.interviews.facebook.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canCross(int[] stones) {

		if (stones == null || stones.length == 0) {
			return true;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i : stones) {
			map.put(i, new HashSet<>());
		}
		map.get(0).add(1);

		for (int i = 0; i < stones.length; i++) {
			int stone = stones[i];
			for (int step : map.get(stone)) {
				int nextReach = stone + step;
				if (nextReach == stones[stones.length - 1]) {
					return true;
				}

				Set<Integer> nextSteps = map.get(nextReach);
				if (nextSteps != null) {
					nextSteps.add(step);
					if (step - 1 > 0) {
						nextSteps.add(step - 1);
					}
					nextSteps.add(step + 1);
				}

			}
		}

		return false;

	}

}
