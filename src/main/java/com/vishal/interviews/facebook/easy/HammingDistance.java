package com.vishal.interviews.facebook.easy;

/**
 * 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * 
 */
public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Java 1 Line Solution 
	 * What does come to your mind first when you see this sentence "corresponding bits are different"? 
	 * Yes, XOR! Also, do not forget there is a decent function Java provided: Integer.bitCount() ~~~
	 */
	
	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
	
	/**
	 * Java 3-Line Solution
	 */
	public int hammingDistance2(int x, int y) {
	    int xor = x ^ y, count = 0;
	    for (int i=0;i<32;i++) count += (xor >> i) & 1;
	    return count;
	}

}
