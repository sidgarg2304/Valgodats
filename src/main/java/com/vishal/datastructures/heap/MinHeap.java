package com.vishal.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

	List<T> elements;

	public MinHeap() {
		elements = new ArrayList<>();
	}

	public void add(T value) {
		elements.add(value);
		siftUp();
	}

	private void siftUp() {

		int k = elements.size() - 1;

		while (true) {
			int p = (k - 1) / 2;
			if (elements.get(p).compareTo(elements.get(k)) == -1) {
				swap(p, k);
			} else {
				break;
			}
			k = p;
		}

	}

	public T delete() {
		// We need to delete first Node
		T res = elements.get(0);
		// Replace last Node with first Node
		T lastHeapNode = elements.remove(elements.size() - 1);
		elements.set(0, lastHeapNode);
		siftDown();
		return res;
	}

	private void siftDown() {

		int p = 0;
		while (2 * p + 2 < elements.size()) {
			int c1 = 2 * p + 1;
			int c2 = 2 * p + 2;

			int largestChild = c1;
			if (elements.get(c1).compareTo(elements.get(c2)) == -1) {
				largestChild = c2;
			}

			if (elements.get(p).compareTo(elements.get(largestChild)) == -1) {
				// swap p and largestChild
				swap(p, largestChild);
				p = largestChild;
			} else {
				break;
			}
		}
	}

	private void swap(int i, int j) {
		T temp = elements.get(i);
		elements.set(i, elements.get(j));
		elements.set(j, temp);
	}

	public String toString() {
		return elements.toString();
	}

}
