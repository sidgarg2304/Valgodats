package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class DesignCompressedStringIterator {

	public static void main(String[] args) {
		DesignCompressedStringIterator i = new DesignCompressedStringIterator("x6");
	}

	Queue<int[]> queue;

	public DesignCompressedStringIterator(String compressedString) {
		queue = new LinkedList<>();
		int i = 0;
		while (i < compressedString.length()) {
			char c = compressedString.charAt(i);
			int j = i + 1;
			while (j < compressedString.length() && compressedString.charAt(j) >= '0'
					&& compressedString.charAt(j) <= '9') {
				j++;
			}

			int num = Integer.parseInt(compressedString.substring(i + 1, j));

			queue.offer(new int[] { c - 'a', num });

			i = j;
		}
	}

	public char next() {
		if (queue.isEmpty()) {
			return ' ';
		}

		int[] top = queue.peek();
		char res = (char) (top[0] + 'a');		
		if(--top[1] == 0){
			queue.poll();
		}
		return res;
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

}
