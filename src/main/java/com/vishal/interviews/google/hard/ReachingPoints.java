package com.vishal.interviews.google.hard;

import java.util.*;

import com.vishal.interviews.util.Point;
/**
 * 780. Reaching Points

A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

Examples:
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: True
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

Input: sx = 1, sy = 1, tx = 2, ty = 2
Output: False

Input: sx = 1, sy = 1, tx = 1, ty = 1
Output: True

Note:

sx, sy, tx, ty will all be integers in the range [1, 10^9].

 *
 */
public class ReachingPoints {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Exhaustive Search [Time Limit Exceeded]
Intuition and Algorithm

Each point has two children as specified in the problem. We try all such points recursively.

	 * @param ty
	 * @return
	 */
	public boolean reachingPointsNaive(int sx, int sy, int tx, int ty) {
      if (sx > tx || sy > ty) return false;
      if (sx == tx && sy == ty) return true;
      return reachingPointsNaive(sx+sy, sy, tx, ty) || reachingPointsNaive(sx, sx+sy, tx, ty);
  }

	
	/**
	 * Approach #2: Dynamic Programming [Time Limit Exceeded]
Intuition and Algorithm

As in Approach #1, we search the children of every point recursively, except we use a set seen so that we don't repeat work.

Complexity Analysis

Time Complexity: O(tx * ty)O(tx∗ty), as at most tx * ty points are searched once per point.

Space Complexity: O(tx * ty)O(tx∗ty), the size of the implicit call stack.
	 */
	Set<Point> seen;
   int tx, ty;

   public boolean reachingPointsDP(int sx, int sy, int tx, int ty) {
       seen = new HashSet();
       this.tx = tx;
       this.ty = ty;
       search(new Point(sx, sy));
       return seen.contains(new Point(tx, ty));
   }

   public void search(Point P) {
       if (seen.contains(P)) return;
       if (P.x > tx || P.y > ty) return;
       seen.add(P);
       search(new Point(P.x + P.y, P.y));
       search(new Point(P.x, P.x + P.y));
   }
   
   /**
    * Approach #3: Work Backwards (Naive Variant) [Time Limit Exceeded]
Intuition

Every parent point (x, y) has two children, (x, x+y) and (x+y, y). However, every point (x, y) only has one parent candidate (x-y, y) if x >= y, else (x, y-x). This is because we never have points with negative coordinates.

Looking at previous successive parents of the target point, we can find whether the starting point was an ancestor. For example, if the target point is (19, 12), the successive parents must have been (7, 12), (7, 5), and (2, 5); so (2, 5) is a starting point of (19, 12).

Algorithm

Repeatedly subtract the smaller of {tx, ty} from the larger of {tx, ty}. The answer is true if and only if we eventually reach sx, sy.

Complexity Analysis

Time Complexity: O(\max(tx, ty))O(max(tx,ty)). If say ty = 1, we could be subtracting tx times.

Space Complexity: O(1)O(1).


    */
   public boolean reachingPointsBackwards(int sx, int sy, int tx, int ty) {
      while (tx >= sx && ty >= sy) {
          if (sx == tx && sy == ty)
              return true;
          if (tx > ty) tx -= ty;
          else ty -= tx;
      }
      return false;
  }
   
   /**
    * Approach #4: Work Backwards (Modulo Variant) [Accepted]
Intuition

As in Approach #3, we work backwards to find the answer, trying to transform the target point to the starting point via applying the parent operation (x, y) -> (x-y, y) or (x, y-x) [depending on which one doesn't have negative coordinates.]

We can speed up this transformation by bundling together parent operations.

Algorithm

Say tx > ty. We know that the next parent operations will be to subtract ty from tx, until such time that tx = tx % ty. When both tx > ty and ty > sy, we can perform all these parent operations in one step, replacing while tx > ty: tx -= ty with tx %= ty.

Otherwise, if say tx > ty and ty <= sy, then we know ty will not be changing (it can only decrease). Thus, only tx will change, and it can only change by subtracting by ty. Hence, (tx - sx) % ty == 0 is a necessary and sufficient condition for the problem's answer to be True.

The analysis above was for the case tx > ty, but the case ty > tx is similar. When tx == ty, no more moves can be made.

Complexity Analysis

Time Complexity: O(\log(\max{(tx, ty)}))O(log(max(tx,ty))). The analysis is similar to the analysis of the Euclidean algorithm, and we assume that the modulo operation can be done in O(1)O(1) time.

Space Complexity: O(1)O(1).
    */
   public boolean reachingPointsWorkBackwardsModuloVariant(int sx, int sy, int tx, int ty) {
      while (tx >= sx && ty >= sy) {
          if (tx == ty) break;
          if (tx > ty) {
              if (ty > sy) tx %= ty;
              else return (tx - sx) % ty == 0;
          } else {
              if (tx > sx) ty %= tx;
              else return (ty - sy) % tx == 0;
          }
      }
      return (tx == sx && ty == sy);
  }
}
