package com.vishal.interviews.linkedin.easy;

/**
 * 605. Can Place Flowers
 * 
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
 *
 */
public class CanPlaceFlowers {

	public static void main(String[] args) {

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {

			if (flowerbed[i] == 1) {
				continue;
			}
			int left = i == 0 ? 0 : flowerbed[i - 1];
			int right = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
			if (left == 0 && right == 0) {
				flowerbed[i] = 1;
				count++;
			}
		}

		return count >= n;
	}
}
