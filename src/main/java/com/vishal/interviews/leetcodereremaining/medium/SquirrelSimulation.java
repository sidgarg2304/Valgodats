package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 573. Squirrel Simulation
 * 
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal 
 * distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at 
 * one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.

Example 1:
Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12
Explanation:

 *
 */
public class SquirrelSimulation {

	public static void main(String[] args) {

	}

	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

		int sum = 0;
		int shortestDistFromNutToSquirrel = Integer.MAX_VALUE;
		int nutDistToRemove = 0;
		for (int[] nut : nuts) {
			int dist = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
			sum += 2 * dist;
			int squirellDist = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
			if(squirellDist < shortestDistFromNutToSquirrel){
				shortestDistFromNutToSquirrel = squirellDist;
				nutDistToRemove = dist;
			}
		}
		
		return sum - nutDistToRemove + shortestDistFromNutToSquirrel;
	}

}
