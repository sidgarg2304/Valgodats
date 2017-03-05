package com.vishal.interviews.google.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 */
public class FindMedianfromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Short simple Java/C++/Python, O(log n) + O(1)
I keep two heaps (or priority queues):

Max-heap small has the smaller half of the numbers.
Min-heap large has the larger half of the numbers.
This gives me direct access to the one or two middle values (they're the tops of the heaps), so getting the median takes O(1) time. And adding a number takes O(log n) time.

Supporting both min- and max-heap is more or less cumbersome, depending on the language, so I simply negate the numbers in the heap in which I want the reverse of the default order. To prevent this from causing a bug with -231 (which negated is itself, when using 32-bit ints), I use integer types larger than 32 bits.

Using larger integer types also prevents an overflow error when taking the mean of the two middle numbers. I think almost all solutions posted previously have that bug.
 *
 */
class MedianFinderSimple {

	private Queue<Long> small = new PriorityQueue<>(), large = new PriorityQueue<>();

	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}
}

/**
 * Share my java solution logn to insert, O(1) to query

Not sure why it is marked as hard, i think this is one of the easiest questions on leetcode.
 *
 */
class MedianFinderConstQuery {
	// max queue is always larger or equal to min queue
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

	// Adds a number into the data structure.
	public void addNum(int num) {
		max.offer(num);
		min.offer(max.poll());
		if (max.size() < min.size()) {
			max.offer(min.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (max.size() == min.size())
			return (max.peek() + min.peek()) / 2.0;
		else
			return max.peek();
	}

}

/**
 * Easy to understand double-heap solution in Java
 * 
 * The basic idea is to maintain two heaps: a max-heap and a min-heap. The max
 * heap stores the smaller half of all numbers while the min heap stores the
 * larger half. The sizes of two heaps need to be balanced each time when a new
 * number is inserted so that their size will not be different by more than 1.
 * Therefore each time when findMedian() is called we check if two heaps have
 * the same size. If they do, we should return the average of the two top values
 * of heaps. Otherwise we return the top of the heap which has one more element.
 * 
 * To do that, we first need to add two PriorityQueues to the class as the
 * max-heap and min-heap:
 * 
 * We then define the constructor of the class so that the PriorityQueues get
 * initialized. By default, the sorting order of a PriorityQueue is natural
 * order which means it is a min-heap by default. Hence we need to provide a new
 * Comparator to the constructor of the max heap to specify the reversed order.
 *
 * Now we have the data structure properly built. Let's write the addNum()
 * function next.
 * 
 * There are several possible situations when a new number is inserted:
 * 
 * 1)If both heap are empty, meaning that we are inserting the first number, we
 * just arbitrarily inserted it into a heap, let's say, the min-heap.
 * 
 * 2)If min-heap has more elements (later we will argue that the size won't be
 * different by more than 1), we need to compare the new number with the top of
 * the min-heap. If it is larger than that, then the new number belongs to the
 * larger half and it should be added to the min-heap. But since we have to
 * balance the heap, we should move the top element of the min-heap to the
 * max-heap. For the min-heap, we inserted a new number but removed the original
 * top, its size won't change. For the max-heap, we inserted a new element (the
 * top of the min-heap) so its size will increase by 1.
 * 
 * 3)If max-heap has more elements, we did the similar thing as 2).
 * 
 * 4)If they have the same size, we just compare the new number with one of the
 * top to determine which heap the new number should be inserted. We just simply
 * inserted it there.
 * 
 * It can be seen that for each insertion if it was in situation 1) and 4), then
 * after insertion the heap size difference will be 1. For 2) and 3), the size
 * of the heap with fewer element will increase by 1 to catch up with the heap
 * with more elements. Hence their sizes are well-balanced and the difference
 * will never exceeds 1.
 * 
 * Obviously, the median will be the top element of the heap which has one more
 * element (if max-heap and min-heap have different sizes), or the average of
 * the two tops (if max-heap and min-heap have equal sizes). So the findMedian()
 * function is very straightforward:
 * 
 * 
 */
class MedianFinderDoubleHeapSol {
	private PriorityQueue<Integer> minH;
	private PriorityQueue<Integer> maxH;

	MedianFinderDoubleHeapSol(){
       minH = new PriorityQueue<Integer>();
       maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2) {
               if (o1.intValue()>o2.intValue()) return -1;
               if (o1.intValue()<o2.intValue()) return 1;
               return 0;
           }
       });
   }

	// Adds a number into the data structure.
	public void addNum(int num) {
		if ((minH.size() == 0) && (maxH.size() == 0))
			minH.add(num);
		else if ((minH.size()) > (maxH.size())) {
			if (num > minH.peek()) {
				maxH.add(minH.poll());
				minH.add(num);
			} else
				maxH.add(num);
		} else if ((minH.size()) < (maxH.size())) {
			if (num < maxH.peek()) {
				minH.add(maxH.poll());
				maxH.add(num);
			} else
				minH.add(num);
		} else {
			if (num < maxH.peek())
				maxH.add(num);
			else
				minH.add(num);
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if ((minH.size() == 0) && (maxH.size() == 0))
			return 0.0;
		if ((minH.size()) > (maxH.size()))
			return (double) (minH.peek());
		if ((minH.size()) < (maxH.size()))
			return (double) (maxH.peek());
		return ((double) (maxH.peek() + minH.peek())) / 2.0;
	}
}

/**
 * Java/Python two heap solution, O(log n) add, O(1) find
 * 
 * The invariant of the algorithm is two heaps, small and large, each represent
 * half of the current list. The length of smaller half is kept to be n / 2 at
 * all time and the length of the larger half is either n / 2 or n / 2 + 1
 * depend on n's parity.
 * 
 * This way we only need to peek the two heaps' top number to calculate median.
 * 
 * Any time before we add a new number, there are two scenarios, (total n
 * numbers, k = n / 2):
 * 
 * (1) length of (small, large) == (k, k) (2) length of (small, large) == (k, k
 * + 1) After adding the number, total (n + 1) numbers, they will become:
 * 
 * (1) length of (small, large) == (k, k + 1) (2) length of (small, large) == (k
 * + 1, k + 1) Here we take the first scenario for example, we know the large
 * will gain one more item and small will remain the same size, but we cannot
 * just push the item into large. What we should do is we push the new number
 * into small and pop the maximum item from small then push it into large (all
 * the pop and push here are heappop and heappush). By doing this kind of
 * operations for the two scenarios we can keep our invariant.
 * 
 * Therefore to add a number, we have 3 O(log n) heap operations. Luckily the
 * heapq provided us a function "heappushpop" which saves some time by combine
 * two into one. The document says:
 * 
 * Push item on the heap, then pop and return the smallest item from the heap.
 * The combined action runs more efficiently than heappush() followed by a
 * separate call to heappop(). Alltogether, the add operation is O(logn), The
 * findMedian operation is O(1).
 * 
 * Note that the heapq in python is a min heap, thus we need to invert the
 * values in the smaller half to mimic a "max heap".
 * 
 * 
 * A further observation is that the two scenarios take turns when adding
 * numbers, thus it is possible to combine the two into one. For this please see
 * stefan's post
 * 
 * https://discuss.leetcode.com/topic/27541/very-short-o-log-n-o-1
 */
class MedianFinderTwoHeapSol {
	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	private boolean even = true;

	public double findMedian() {
		if (even)
			return (small.peek() + large.peek()) / 2.0;
		else
			return small.peek();
	}

	public void addNum(int num) {
		if (even) {
			large.offer(num);
			small.offer(large.poll());
		} else {
			small.offer(num);
			large.offer(small.poll());
		}
		even = !even;
	}
}

/**
 * Same idea as before, but really exploiting the symmetry of the two heaps by
 * switching them whenever a number is added. Still O(log n) for adding and O(1)
 * for median. Partially inspired by peisi's updated solution.
 * 
 * Update: Added a new Java version (the first one).
 *
 */
class MedianFinderVeryShort {

	Queue<Integer> q = new PriorityQueue<>(), z = q, t, Q = new PriorityQueue<>(Collections.reverseOrder());

	public void addNum(int num) {
		(t = Q).add(num);
		(Q = q).add((q = t).poll());
	}

	public double findMedian() {
		return (Q.peek() + z.peek()) / 2.;
	}
};

