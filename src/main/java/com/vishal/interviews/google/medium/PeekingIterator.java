package com.vishal.interviews.google.medium;

import java.util.Iterator;

/**
 * 284. Peeking Iterator
 * 
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * 
 * Call next() gets you 1, the first element in the list.
 * 
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * 
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 * 
 * Hint:
 * 
 * 1. Think of "looking ahead". You want to cache the next element.
 * 
 * 2. Is one variable sufficient? Why or why not?
 * 
 * 3. Test your design with call order of peek() before next() vs next() before
 * peek().
 * 
 * 4. For a clean implementation, check out Google's guava library source
 * https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33
 * /guava-gwt/src-super/com/google/common/collect/super/com/google/common/
 * collect/Iterators.java#L1125 code.
 * 
 * Follow up: How would you extend your design to be generic and work with all
 * types, not just integer?
 * 
 */
public class PeekingIterator {

	public static void main(String[] args) {

	}

}

/**
 * cache the next element. If next is null, there is no more elements in
 * iterator.
 * 
 * Edit: check AlexTheGreat's answer. It's better.
 * 
 *
 */
class PeekingIteratorSol implements Iterator<Integer> {
	private Integer next = null;
	private Iterator<Integer> iter;

	public PeekingIteratorSol(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext())
			next = iter.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res = next;
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}
}