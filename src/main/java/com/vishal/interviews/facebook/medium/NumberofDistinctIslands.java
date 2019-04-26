package com.vishal.interviews.facebook.medium;

import java.util.*;

public class NumberofDistinctIslands {

	public static void main(String[] args) {

	}
	
/**
 * Approach #1: Hash By Local Coordinates [Accepted]
Intuition and Algorithm

At the beginning, we need to find every island, which we can do using a straightforward depth-first search. The hard part is deciding whether two islands are the same.

Since two islands are the same if one can be translated to match another, let's translate every island so the top-left corner is (0, 0) For example, if an island is made from squares [(2, 3), (2, 4), (3, 4)], we can think of this shape as [(0, 0), (0, 1), (1, 1)] when anchored at the top-left corner.

From there, we only need to check how many unique shapes there ignoring permutations (so [(0, 0), (0, 1)] is the same as [(0, 1), (1, 0)]). We use sets directly as we have showcased below, but we could have also sorted each list and put those sorted lists in our set structure shapes.

In the Java solution, we converted our tuples (r - r0, c - c0) to integers. We multiplied the number of rows by 2 * grid[0].length instead of grid[0].length because our local row-coordinate could be negative.
 */
	
	int[][] grid;
   boolean[][] seen;
   Set<Integer> shape;
   
   public void explore(int r, int c, int r0, int c0) {
       if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
               grid[r][c] == 1 && !seen[r][c]) {
           seen[r][c] = true;
           shape.add((r - r0) * 2 * grid[0].length + (c - c0));
           explore(r+1, c, r0, c0);
           explore(r-1, c, r0, c0);
           explore(r, c+1, r0, c0);
           explore(r, c-1, r0, c0);
       }
   }
   public int numDistinctIslands(int[][] grid) {
       this.grid = grid;
       seen = new boolean[grid.length][grid[0].length];
       Set shapes = new HashSet<HashSet<Integer>>();

       for (int r = 0; r < grid.length; r++) {
           for (int c = 0; c < grid[0].length; c++) {
               shape = new HashSet<Integer>();
               explore(r, c, r, c);
               if (!shape.isEmpty()) {
                   shapes.add(shape);
               }
           }
       }

       return shapes.size();
   }
   
   

   
}

//2nd solution

/**
 * Approach #2: Hash By Path Signature [Accepted]
Intuition and Algorithm

When we start a depth-first search on the top-left square of some island, the path taken by our depth-first search will be the same if and only if the shape is the same. We can exploit this by recording the path we take as our shape - keeping in mind to record both when we enter and when we exit the function. The rest of the code remains as in Approach #1.
 */
class NumberofDistinctIslands2{
	int[][] grid;
   boolean[][] seen;
   ArrayList<Integer> shape;

   public void explore(int r, int c, int di) {
       if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
               grid[r][c] == 1 && !seen[r][c]) {
           seen[r][c] = true;
           shape.add(di);
           explore(r+1, c, 1);
           explore(r-1, c, 2);
           explore(r, c+1, 3);
           explore(r, c-1, 4);
           shape.add(0);
       }
   }
   public int numDistinctIslands(int[][] grid) {
       this.grid = grid;
       seen = new boolean[grid.length][grid[0].length];
       Set shapes = new HashSet<ArrayList<Integer>>();

       for (int r = 0; r < grid.length; r++) {
           for (int c = 0; c < grid[0].length; c++) {
               shape = new ArrayList<Integer>();
               explore(r, c, 0);
               if (!shape.isEmpty()) {
                   shapes.add(shape);
               }
           }
       }

       return shapes.size();
   }
}
