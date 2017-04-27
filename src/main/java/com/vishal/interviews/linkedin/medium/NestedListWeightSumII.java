package com.vishal.interviews.linkedin.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 364. Nested List Weight Sum II
 * 
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Different from the previous question where weight is increasing from root to
 * leaf, now the weight is defined from bottom up. i.e., the leaf level integers
 * have weight 1, and the root level integers have the largest weight.
 * 
 * Example 1:
 * 
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at
 * depth 2)
 * 
 * Example 2:
 * 
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2,
 * and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 * 
 * The question needs to be re-defined.
The weight increases from the leaf to the root.

However, the following situation is not clearly defined. I will illustrate it using a tree structure.

    a
  /    \
 b      c
          \
           d
What is the weight of a? Is it 2 to 3?
 */
public class NestedListWeightSumII {

	public static void main(String[] args) {

	}

	public int depthSumInverseNoDepthNoMultiplication(List<NestedInteger> nestedList) {
		int unweighted = 0, weighted = 0;
		while (!nestedList.isEmpty()) {
			List<NestedInteger> nextLevel = new ArrayList<>();
			for (NestedInteger ni : nestedList) {
				if (ni.isInteger())
					unweighted += ni.getInteger();
				else
					nextLevel.addAll(ni.getList());
			}
			weighted += unweighted;
			nestedList = nextLevel;
		}
		return weighted;
	}

	public int depthSumInverseBFS(List<NestedInteger> nestedList) {
		if (nestedList == null)
			return 0;
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
		int prev = 0;
		int total = 0;
		for (NestedInteger next : nestedList) {
			queue.offer(next);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelSum = 0;
			for (int i = 0; i < size; i++) {
				NestedInteger current = queue.poll();
				if (current.isInteger())
					levelSum += current.getInteger();
				List<NestedInteger> nextList = current.getList();
				if (nextList != null) {
					for (NestedInteger next : nextList) {
						queue.offer(next);
					}
				}
			}
			prev += levelSum;
			total += prev;
		}
		return total;
	}

	/**
	 * Share my 2ms intuitive-one pass-no multiplication solution
	 * 
	 * The idea is to pass the current found integer sum into the next level of
	 * recursion, and return it back again. So that we don't have to count the
	 * number of levels in the nested list.
	 * 
	 * I think code itself is quite self explanatory.
	 * 
	 * @param nestedList
	 * @return
	 */
	public int depthSumInverseIntutiveOnePass(List<NestedInteger> nestedList) {
		return helper(nestedList, 0);
	}

	private int helper(List<NestedInteger> niList, int prev) {
		int intSum = prev;
		List<NestedInteger> levelBreak = new ArrayList<>();

		for (NestedInteger ni : niList) {
			if (ni.isInteger()) {
				intSum += ni.getInteger();
			} else {
				levelBreak.addAll(ni.getList());
			}
		}

		int listSum = levelBreak.isEmpty() ? 0 : helper(levelBreak, intSum);

		return listSum + intSum;
	}
}

class NestedInteger {
	int val;
	List<NestedInteger> list;

	int getInteger() {
		return val;
	}

	boolean isInteger() {
		return true;
	}

	List<NestedInteger> getList() {
		return list;
	}
}
