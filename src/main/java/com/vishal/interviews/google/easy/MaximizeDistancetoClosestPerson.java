package com.vishal.interviews.google.easy;

import java.util.*;

/**
 * 849. Maximize Distance to Closest Person
 * 
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.
 *
 */
public class MaximizeDistancetoClosestPerson {

	public static void main(String[] args) {

	}
	
	public int maxDistToClosestDP(int[] seats) {
      int[] dp = new int[seats.length];
		int leftOnePos = seats[0] == 1 ? 0 : -1;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				leftOnePos = i;
				continue;
			}
			if (leftOnePos != -1) {
				dp[i] = i - leftOnePos;
			}
		}
		
		System.out.println(Arrays.toString(dp));

		int res = Integer.MIN_VALUE;
		int rightOnePos = seats[seats.length - 1] == 1 ? seats.length - 1 : -1;
		for (int i = seats.length - 1; i >= 0; i--) {
			if(seats[i] == 1) {
				rightOnePos = i;
				continue;
			}
			
			if(rightOnePos != -1) {
              if(dp[i] != 0) {
				    dp[i] = Math.min(dp[i], rightOnePos - i);
              } else {
                  dp[i] = rightOnePos - i;
              }
			}
			res = Math.max(res, dp[i]);
		}
		
		return res;
  }

	/**
	 * Approach #1: Next Array [Accepted]
Intuition

Let left[i] be the distance from seat i to the closest person sitting to the left of i. Similarly, let right[i] be the distance to the closest person sitting to the right of i. This is motivated by the idea that the closest person in seat i sits a distance min(left[i], right[i]) away.

Algorithm

To construct left[i], notice it is either left[i-1] + 1 if the seat is empty, or 0 if it is full. right[i] is constructed in a similar way.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of seats.

Space Complexity: O(N)O(N), the space used by left and right.


	 */
	public int maxDistToClosest(int[] seats) {
      int N = seats.length;
      int[] left = new int[N], right = new int[N];
      Arrays.fill(left, N);
      Arrays.fill(right, N);

      for (int i = 0; i < N; ++i) {
          if (seats[i] == 1) left[i] = 0;
          else if (i > 0) left[i] = left[i-1] + 1;
      }

      for (int i = N-1; i >= 0; --i) {
          if (seats[i] == 1) right[i] = 0;
          else if (i < N-1) right[i] = right[i+1] + 1;
      }

      int ans = 0;
      for (int i = 0; i < N; ++i)
          if (seats[i] == 0)
              ans = Math.max(ans, Math.min(left[i], right[i]));
      return ans;
  }
	
	/**
	 * Approach #2: Two Pointer [Accepted]
Intuition

As we iterate through seats, we'll update the closest person sitting to our left, and closest person sitting to our right.

Algorithm

Keep track of prev, the filled seat at or to the left of i, and future, the filled seat at or to the right of i.

Then at seat i, the closest person is min(i - prev, future - i), with one exception. i - prev should be considered infinite if there is no person to the left of seat i, and similarly future - i is infinite if there is no one to the right of seat i.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of seats.

Space Complexity: O(1)O(1).
	 */
	public int maxDistToClosestTwoPointer(int[] seats) {
      int N = seats.length;
      int prev = -1, future = 0;
      int ans = 0;

      for (int i = 0; i < N; ++i) {
          if (seats[i] == 1) {
              prev = i;
          } else {
              while (future < N && seats[future] == 0 || future < i)
                  future++;

              int left = prev == -1 ? N : i - prev;
              int right = future == N ? N : future - i;
              ans = Math.max(ans, Math.min(left, right));
          }
      }

      return ans;
  }
	
	/**
	 * Approach #3: Group by Zero [Accepted]
Intuition

In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.

Algorithm

For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.

For groups of empty seats between the edge of the row and one other person, the answer is K, and we should take into account those answers too.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of seats.

Space Complexity: O(1)O(1). (In Python, seats[::-1] uses O(N)O(N) space, but this can be remedied.)
	 */
	public int maxDistToClosestGroupByZero(int[] seats) {
      int N = seats.length;
      int K = 0; //current longest group of empty seats
      int ans = 0;

      for (int i = 0; i < N; ++i) {
          if (seats[i] == 1) {
              K = 0;
          } else {
              K++;
              ans = Math.max(ans, (K + 1) / 2);
          }
      }

      for (int i = 0; i < N; ++i)  if (seats[i] == 1) {
          ans = Math.max(ans, i);
          break;
      }

      for (int i = N-1; i >= 0; --i)  if (seats[i] == 1) {
          ans = Math.max(ans, N - 1 - i);
          break;
      }

      return ans;
  }
}
