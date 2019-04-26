package com.vishal.interviews.uber.medium;

import java.util.*;

public class VerifyPreorderSerializationofaBinaryTree {

	public static void main(String[] args) {

	}
	
	/**
	  5
    / \
   2   6
  / \
 1   3
	 */
	//Input: [5,2,1,3,6]

	int nextPos = 1;

	public boolean verifyPreorder(int[] preorder) {

		if (preorder == null || preorder.length == 0) {
			return true;
		}

		return verify(preorder, Integer.MIN_VALUE, preorder[0]) && verify(preorder, Integer.MAX_VALUE, preorder[0]);
	}

	boolean verify(int[] preorder, int left, int right) {

		if (nextPos == preorder.length) {
			return true;
		}

		int nextVal = preorder[nextPos++];
		return nextVal > left && verify(preorder, left, nextVal) && verify(preorder, nextVal, right);
	}

}
