package com.vishal.interviews.google.medium;

import java.util.*;

/**
 * 841. Keys and Rooms
 * 
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.

 *
 */
public class KeysandRooms {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Depth-First Search [Accepted]
Intuition and Algorithm

When visiting a room for the first time, look at all the keys in that room. For any key that hasn't been used yet, add it to the todo list (stack) for it to be used.

See the comments of the code for more details.

Complexity Analysis

Time Complexity: O(N + E)O(N+E), where NN is the number of rooms, and EE is the total number of keys.

Space Complexity: O(N)O(N) in additional space complexity, to store stack and seen.
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      boolean[] seen = new boolean[rooms.size()];
      seen[0] = true;
      Stack<Integer> stack = new Stack();
      stack.push(0);

      //At the beginning, we have a todo list "stack" of keys to use.
      //'seen' represents at some point we have entered this room.
      while (!stack.isEmpty()) { // While we have keys...
          int node = stack.pop(); // Get the next key 'node'
          for (int nei: rooms.get(node)) // For every key in room # 'node'...
              if (!seen[nei]) { // ...that hasn't been used yet
                  seen[nei] = true; // mark that we've entered the room
                  stack.push(nei); // add the key to the todo list
              }
      }

      for (boolean v: seen)  // if any room hasn't been visited, return false
          if (!v) return false;
      return true;
  }

}
