package com.vishal.interviews.google.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 281. Zigzag Iterator
 * 
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2]
 * 
 * v2 = [3, 4, 5, 6]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * Clarification for the follow up question - Update (2015-09-18):
 * 
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
 * example, given the following input:
 * 
 * [1,2,3]
 * 
 * [4,5,6,7]
 * 
 * [8,9]
 * 
 * It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {

	public static void main(String[] args) {

	}

}

/**
 * Simple Java solution for K-vector
 * 
 * Uses a linkedlist to store the iterators in different vectors. Every time we
 * call next(), we pop an element from the list, and re-add it to the end to
 * cycle through the lists.
 * 
 */
class ZigzagIteratorSimple {
	LinkedList<Iterator> list;

	public ZigzagIteratorSimple(List<Integer> v1, List<Integer> v2) {
		list = new LinkedList<Iterator>();
		if (!v1.isEmpty())
			list.add(v1.iterator());
		if (!v2.isEmpty())
			list.add(v2.iterator());
	}

	public int next() {
		Iterator<Integer> poll = list.remove();
		int result = (Integer) poll.next();
		if (poll.hasNext())
			list.add(poll);
		return result;
	}

	public boolean hasNext() {
		return !list.isEmpty();
	}
}

/**
 * Short Java O(1) space Two iterators, one for each list. Switching them before
 * reading the next number instead of afterwards saves a bit of code, I think.
 * 
 */
class ZigzagIteratorTwoIterators {

	private Iterator<Integer> i, j, tmp;

	public ZigzagIteratorTwoIterators(List<Integer> v1, List<Integer> v2) {
		i = v2.iterator();
		j = v1.iterator();
	}

	public int next() {
		if (j.hasNext()) {
			tmp = j;
			j = i;
			i = tmp;
		}
		return i.next();
	}

	public boolean hasNext() {
		return i.hasNext() || j.hasNext();
	}
}