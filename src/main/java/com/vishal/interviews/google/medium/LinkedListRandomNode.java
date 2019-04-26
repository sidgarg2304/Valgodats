package com.vishal.interviews.google.medium;

import java.util.Random;

/**
 * 382. Linked List Random Node
 * 
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */
public class LinkedListRandomNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Java Solution with cases explain
When I first got this question, I went through some articles, but it is painful for me to understand abstract notations like i, k, m, n, n-1, k+1...

After I read this one: http://blog.jobbole.com/42550/, it comes with a simple example and I understood suddenly, and write the code by myself. I translate it to English, so more people can benefit from it.

Start...
When we read the first node head, if the stream ListNode stops here, we can just return the head.val. The possibility is 1/1.

When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace r as the value of the current node, otherwise we don't touch r, so its value is still the value of head.

When we read the third node, now the result r is one of value in the head or second node. We just decide if we replace the value of r as the value of current node(third node). The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.

We can continue to do like this until the end of stream ListNode.
 * @author vkotha
 *
 */
class LinkedListRandomNodeSolution {
   
   ListNode head;
   Random random;
   
   public LinkedListRandomNodeSolution(ListNode head) {
       this.head = head;                
   }
   
   public int getRandom() {
       
       ListNode c = head;
       int r = c.val;
       for(int i=1;c.next != null;i++){
           
           c = c.next;
           if(randInt(0,i) == i) r = c.val;                        
       }
       
       return r;
   }
   
   private int randInt(int min, int max) {
       return min + (int)(Math.random() * ((max - min) + 1));
   }
   
   
}

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int v){
		val = v;
	}
}

/**
 * O(n) time
 * O(1) space
 * @author vkotha
 *
 */
class LinkedListRandomNodeSolution2 {

   /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
   ListNode head = null;
   Random randomGenerator = null;
   public LinkedListRandomNodeSolution2(ListNode head) {
       this.head = head;
       this.randomGenerator = new Random();

   }
   
   /** Returns a random node's value. */
   public int getRandom() {
       ListNode result = null;
       ListNode current = head;
       
       for(int n = 1; current!=null; n++) {
           if (randomGenerator.nextInt(n) == 0) {
               result = current;
           }
           current = current.next;
       }
       
       return result.val;
       
   }
}