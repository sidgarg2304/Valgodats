package com.vishal.interviews.google.easy;

import java.util.*;
/**
 * 604. Design Compressed String Iterator
 * 
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '
 *
 */
public class DesignCompressedStringIterator {

	public static void main(String[] args) {

	}
	
	Queue<int[]> queue;
   public DesignCompressedStringIterator(String compressedString) {
       queue = new LinkedList<>();
		int i = 0;
		while (i < compressedString.length()) {
			char c = compressedString.charAt(i);
			int j = i + 1;
			while (j< compressedString.length() && compressedString.charAt(j) >= '0' && compressedString.charAt(j) <= '9') {
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
