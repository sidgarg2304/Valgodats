package com.vishal.datastructures.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.vishal.algorithms.interval.Interval;
import com.vishal.datastructures.linkedlist.ListNode;

public class HeapAlgorithms {

	public static void main(String[] args) {
		testMinHeap();
		testMergeKSortedArrays();
		testMedianTracker();
		testFindNumOfMettingRooms();
	}

	public static void testMinHeap() {
		MinHeap<Integer> minHeap = new MinHeap<>();
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(4);

		System.out.println(minHeap);

		minHeap.add(5);
		System.out.println(minHeap);
		minHeap.delete();
		System.out.println(minHeap);
	}

	public static void testMedianTracker() {
		MedianTracker medianTracker = new MedianTracker();
		medianTracker.addRandomValue(1);
		medianTracker.addRandomValue(5);
		medianTracker.addRandomValue(2);
		medianTracker.addRandomValue(4);
		medianTracker.addRandomValue(3);

		System.out.println("Median of the elements is " + medianTracker.getMedian());
	}

	public static void testFindNumOfMettingRooms() {
		Interval[] meetings = new Interval[4];
		meetings[0] = new Interval(8, 9);
		meetings[1] = new Interval(10, 12);
		meetings[2] = new Interval(11, 14);
		meetings[3] = new Interval(13, 17);

		System.out.println("Same person " + (canAttendMeeting(meetings) ? "can" : "cannot") + " attend all the meetings: "
				+ Arrays.toString(meetings));
		System.out.println("num of meeting rooms required for the meetings to take palce " + Arrays.toString(meetings)
				+ " are " + findNumOfMettingRooms(meetings));

	}

	public static boolean canAttendMeeting(Interval[] meetings) {
		Arrays.sort(meetings, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getLow() - o2.getLow();
			}
		});

		for (int i = 1; i < meetings.length; i++) {
			if (meetings[i].getLow() < meetings[i - 1].getHigh()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Merge all non overlapping intervals
	 * 
	 * @param meetings
	 * @return
	 */
	public static int findNumOfMettingRooms(Interval[] meetings) {

		Arrays.sort(meetings, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getLow() - o2.getLow();
			}
		});
		Queue<Integer> priorityQueue = new PriorityQueue<>();
		int count = 1;
		priorityQueue.offer(meetings[0].getHigh());

		for (int i = 1; i < meetings.length; i++) {

			if (meetings[i].getLow() < priorityQueue.peek()) {
				count++;
			} else {
				priorityQueue.poll();
			}

			priorityQueue.offer(meetings[i].getHigh());
		}

		return count;
	}

	public static void testMergeKSortedArrays() {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };

		int[] result = mergeKSortedArrays(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}

	public static int[] mergeKSortedArrays(int[][] arrays) {

		Queue<ArrayContainer> priorityQueue = new PriorityQueue<>();
		int resLen = 0;
		for (int i = 0; i < arrays.length; i++) {
			ArrayContainer ac = new ArrayContainer(arrays[i], 0);
			resLen += arrays[i].length;
			priorityQueue.offer(ac);
		}

		int[] res = new int[resLen];
		int k = 0;
		while (!priorityQueue.isEmpty()) {
			ArrayContainer ac = priorityQueue.poll();
			res[k++] = ac.getArr()[ac.getIndex()];

			if (ac.getIndex() < ac.getArr().length - 1) {
				ac.setIndex(ac.getIndex() + 1);
				priorityQueue.offer(ac);
			}
		}
		return res;

	}

	public static ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {

		Queue<ListNode<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<ListNode<Integer>>() {

			@Override
			public int compare(ListNode<Integer> o1, ListNode<Integer> o2) {
				return o1.getValue() - o2.getValue();
			}

		});

		for (int i = 0; i < lists.length; i++) {
			priorityQueue.add(lists[i]);
		}

		ListNode<Integer> res = new ListNode<>(0);
		ListNode<Integer> p = res;
		while (!priorityQueue.isEmpty()) {
			ListNode<Integer> l = priorityQueue.poll();
			p.setNext(new ListNode<Integer>(l.getValue()));

			if (l.getNext() != null) {
				priorityQueue.offer(l.getNext());
			}
		}

		return res.getNext();
	}
}

class ArrayContainer implements Comparable<ArrayContainer> {

	private int[] arr;
	private int index;

	public ArrayContainer(int[] arr, int index) {
		this.arr = arr;
		this.index = index;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(ArrayContainer ac) {
		return this.arr[this.index] - ac.arr[ac.index];
	}

}
